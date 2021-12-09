package com.project.shop.service.impl;

import com.google.gson.Gson;
import com.project.shop.config.util.IOUtil;
import com.project.shop.config.util.IOUtilImpl;
import com.project.shop.constants.Paths;
import com.project.shop.identityArea.models.entity.UserEntity;
import com.project.shop.model.Page;
import com.project.shop.model.Response;
import com.project.shop.model.binding.AdvSearch;
import com.project.shop.model.entity.Account;
import com.project.shop.model.entity.BaseEntity;
import com.project.shop.model.entity.Listing;
import com.project.shop.model.service.ListingReadModel;
import com.project.shop.model.service.ListingServiceModel;
import com.project.shop.model.view.ListingInListViewModel;
import com.project.shop.repository.ListingRepository;
import com.project.shop.service.*;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Hibernate;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import javax.management.Query;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.*;


@Service
@Transactional
@Slf4j
public class ListingServiceImpl extends BaseServiceImpl<Listing> implements ListingService {

    private final ListingRepository listingRepository;
    private final ModelMapper modelMapper;
    private final CategoryService categoryService;
    private final ConditionService conditionService;
    private final SellingFormatService sellingFormatService;
    private final DeliveryService deliveryService;
    private final AccountService accountService;
    private final PaymentService paymentService;
    private final IOUtil ioUtil;
    private final Gson gson;
    //EntityManager em = new ;

    public ListingServiceImpl(ListingRepository listingRepository,
                              ModelMapper modelMapper, CategoryService categoryService,
                              ConditionService conditionService, SellingFormatService sellingFormatService,
                              DeliveryService deliveryService, AccountService accountService, PaymentService paymentService, Gson gson) {
        this.listingRepository = listingRepository;
        this.modelMapper = modelMapper;
        this.categoryService = categoryService;
        this.conditionService = conditionService;
        this.sellingFormatService = sellingFormatService;
        this.deliveryService = deliveryService;
        this.accountService = accountService;
        this.paymentService = paymentService;
        this.gson = gson;
        this.ioUtil = new IOUtilImpl();
    }


    @Override
    public Response getAllListings(Authentication authentication,
                                   int page, int limit, String sortBy, String sort, String filter, String search) {
        log.info("Fetch Listings from page " + page + " with " + limit + "/page");


        if (listingRepository.count() == 0) {
            Response response = new Response(new Page(0, 1, 1));
            response.setOkRequestResponse("listings", new ArrayList<ListingInListViewModel>(), "Listings retrieved");
            return response;
        }
        int size = (int) filterQuery((PageRequest.of(0, (int) listingRepository.count())),
                search, filter, authentication).getContent().size();
        int totalPages = (int) Math.ceil(size / (limit * 1.00));
        Pageable pageListing = getPageable(page, limit, sort, sortBy);

        List<Listing> listings = filterQuery(pageListing, search, filter, authentication).getContent();

        List<ListingInListViewModel> models = listings.stream()
                .map(l -> {
                    ListingInListViewModel model = modelMapper.map(l, ListingInListViewModel.class);
                    System.out.println();
                    return model;
                }).collect(Collectors.toList());
        Response response = new Response(new Page(page, limit, totalPages));

        response.setOkRequestResponse("listings", models, "Listings retrieved");
        return response;
    }


    private Slice<Listing> filterQuery(Pageable listingPage, String search, String filter, Authentication authentication) {
        if (filter == null && search == null) {
            return listingRepository.findAll(listingPage);
        }
        if (filter != null) {
            switch (filter.trim().toLowerCase()) {
                case "watchlist":

                    Account account = getAccount(authentication);
                    isAccountExist(account);
                    return listingRepository.findAllWatched(account.getUsername(), listingPage);
                case "mylist":
                    account = getAccount(authentication);
                    isAccountExist(account);
                    return listingRepository.findAllByCreateFrom(account.getUsername(), listingPage);
                case "daily_deals":
                    return listingRepository.findAllByCreateOnAfter(LocalDateTime.now().minusDays(1), listingPage);

                case "outlet":
                    return listingRepository.findAllByCreateOnAfter(LocalDateTime.now().minusDays(20), listingPage);

            }
        }
        if (search != null) {
            return listingRepository.findAllByTitleContainingOrDescriptionContaining(search.trim(), search.trim(), listingPage);
        }
        return listingRepository.findAll(listingPage);
    }

    private void isAccountExist(Account account) {
        if (account == null) {
            throw new NullPointerException("Please login");
        }
    }

    private Account getAccount(Authentication authentication) {
        if (authentication == null) {
            throw new NullPointerException("Please login before continue");
        }
        UserEntity principal = (UserEntity) authentication.getPrincipal();
        return accountService.getAccountByUserName(principal.getUsername()).orElse(null);
    }

    @Override
    public Optional<Listing> getListingById(UUID id) {
        log.info("Details for listing with id: " + id);
        return listingRepository.findById(id);
    }

    @Override
    public boolean deleteListing(UUID id, String username) throws IllegalAccessException {
        Optional<Listing> listing = listingRepository
                .findById(id);
        if (listing.isEmpty()) {
            return false;
        }
        if (!listing.get().getSeller().getUsername().equals(username)) {
            throw new IllegalAccessException("You are not authorise to delete this item");
        }
        log.info("Deleted listing id: " + id);
        listing.get().setActive(false);
        Listing listing1 = this.onModify(listing.get(), username);
        listingRepository.saveAndFlush(listing1);
        return true;
    }

    @Override
    public UUID createListing(ListingServiceModel listingServiceModel) {
        Listing listing = modelMapper.map(listingServiceModel, Listing.class);
        Account account = this.accountService.findByUsername(listingServiceModel.getUsernameCreator()).orElseThrow(() ->
                new NullPointerException("You are not make registration yet"));
        listing.setSeller(account);

        setNestedEntities(listing, listingServiceModel);
        listing = this.onCreate(listing, account.getUsername());

        Listing listing1 = listingRepository.saveAndFlush(listing);
        log.info("Create listing id: " + listing.getId().toString());
        return listing1.getId();
    }

    @Override

    public UUID updateListing(ListingServiceModel listingServiceModel) {
        Listing listing = listingRepository.findById(listingServiceModel.getId())
                .orElseThrow(() -> new NullPointerException("Listing with this "
                        + listingServiceModel.getId().toString() + " does not exist"));
        Account account = this.accountService.findByUsername(listingServiceModel.getUsernameCreator()).orElseThrow(() ->
                new NullPointerException("You are not make registration yet"));

        Listing listingMapped = modelMapper.map(listingServiceModel, Listing.class);
        listingMapped.setId(listing.getId());
        listingMapped.setSeller(account);
        setNestedEntities(listingMapped, listingServiceModel);
        listingMapped.setCreateOn(listing.getCreateOn())
                .setCreateFrom(listing.getCreateFrom())
                .setActive(true);
        listingMapped = this.onModify(listingMapped, account.getUsername());
        Listing listing1 = listingRepository.saveAndFlush((listingMapped));
        log.info("Updated listing id: " + listing1.getId().toString());
        return listing1.getId();
    }

    @Override
    public void updateListing(Listing listing) {
        listing = this.onModify(listing, "system-order");
        listingRepository.saveAndFlush((listing));
        log.info("Decrease listing quantity");

    }

    @Override
    public boolean watchListing(UUID id, String username) {
        Account buyer = accountService.getAccountByUserName(username)
                .orElseThrow(() -> new NullPointerException("You must login before watch this listing"));

        boolean unWatched = buyer.getWatchList().removeIf(e -> e.getId().equals(id));
        if (!unWatched) {
            buyer.getWatchList().add(this.getListingById(id)
                    .orElseThrow(() -> new NullPointerException("Listing gone")));
        }
        accountService.save(buyer);
        return !unWatched;
    }


    @Override
    public Collection<ListingInListViewModel> getWatchListings(String username, int page, int limit) {
        log.info("Fetch Listings from page " + page + " with " + limit + "/page");
        Stream<Listing> listingStream = listingRepository.findAll(PageRequest.of(page, limit))
                .stream()
                .filter(BaseEntity::isActive)
                .filter(e -> e.getSeller().getUsername().equals(username));
        Stream<ListingInListViewModel> collect = listingStream
                .map(l -> {
                    ListingInListViewModel model = modelMapper.map(l, ListingInListViewModel.class);
                    System.out.println();
                    return model;
                });

        return collect.collect(Collectors.toList());
    }

    @Override
    public List<Listing> getAllById(List<UUID> ids) {
        return listingRepository.findAllById(ids);
    }


    private Listing setNestedEntities(Listing listingMapped, ListingServiceModel listingServiceModel) {
        listingMapped.setPayment(paymentService.getPaymentById(listingServiceModel.getPayment())
                .orElseThrow(() -> new NullPointerException("Payment does not exist")));
        listingMapped.setCategory(categoryService.find(listingServiceModel.getCategory()));
        listingMapped.setCondition(conditionService.find(listingServiceModel.getCondition()));
        listingMapped.setSellingFormat(sellingFormatService.create(listingServiceModel.getSellingFormat()));
        listingMapped.setDeliveryDomestic(deliveryService.create(listingServiceModel.getDeliveryDomestic()));
        listingMapped.setDeliveryInternational(deliveryService.create(listingServiceModel.getDeliveryInternational()));
        return listingMapped;
    }

    @Override
    public void seedData() {
        if (listingRepository.count() > 0) {
            return;
        }
        try {
            String content = String.join("", ioUtil.readFile(Paths.LISTING_JSON_FILEPATH));

            Arrays.stream(gson.fromJson(content, ListingReadModel[].class))
                    .forEach(reader -> {
                        try {
                            Listing model = modelMapper.map(reader, Listing.class);
                            model.setCategory(categoryService.find(reader.getCategory()));
                            model.setCondition(conditionService.findByTitle(reader.getCondition()));
                            model.setSellingFormat(sellingFormatService.create(reader.getSellingFormat()));
                            model.setDeliveryDomestic(deliveryService.create(reader.getDeliveryDomestic()));
                            model.setDeliveryInternational(deliveryService.create(reader.getDeliveryInternational()));
                            model.setPayment(paymentService.findByTitle(reader.getPaymentTitle()));
                            model.setSeller(this.accountService.findByUsername(reader.getUsernameCreator()).orElseThrow(() ->
                                    new NullPointerException("You are not make registration yet")));
                            model = this.onCreate(model, reader.getUsernameCreator());
                            listingRepository.saveAndFlush(model);
                        } catch (Exception e) {

                        }
                    });
        } catch (Exception e) {
        }
    }

    @Override
    public Response getAdvSearch(AdvSearch search, int page, int limit) {

        if (listingRepository.count() == 0) {
            Response response = new Response(new Page(0, 1, 1));
            response.setOkRequestResponse("listings", new ArrayList<ListingInListViewModel>(), "Listings retrieved");
            return response;
        }
        int size = (int) listingRepository.count() / limit;
        int totalPages = (int) Math.ceil(size / (limit * 1.00));
        Pageable pageListing = PageRequest.of(page, limit, getSorting(search));

        ExampleMatcher matcher = ExampleMatcher
                .matchingAny()
//                .withMatcher("title", contains().ignoreCase())
//                .withMatcher("description", contains().ignoreCase())
//                .withMatcher("createFrom", contains().ignoreCase())
                .withIgnoreCase()
                .withIgnoreNullValues()
                .withIgnorePaths("id");
        Listing example = new Listing();
        for (Field field : search.getClass().getDeclaredFields()) {
            try {
                if (field.get(search) != null) {
                    getQueryFilter(matcher, example, field.getName(), field.get(search).toString(), search);
                }
            } catch (IllegalAccessException e) {
                continue;
            }
        }

        List<ListingInListViewModel> listings = listingRepository.findAll(Example.of(example, matcher), pageListing)
                .stream().map(l -> {
                    ListingInListViewModel model = modelMapper.map(l, ListingInListViewModel.class);

                    return model;
                }).collect(Collectors.toList());
        Response response = new Response(new Page(page, limit, totalPages));
        try {
            response.setOkRequestResponse("listings", listings, "Listings retrieved");
        } catch (Exception e) {
            response.setBadRequestResponse("listings", listings, e, e.getMessage());
        }

        return response;
    }

    private Sort getSorting(AdvSearch search) {
        //  Sort price = mySort("price", search.getPriceSort());
        Sort title = mySort("title", search.getPriceSort());
        Sort time = mySort("createFrom", search.getPriceSort());
        return title.and(time);
    }

    private Sort mySort(String fieldName, Byte value) {
        if (value != null && value == 1) {
            return Sort.by(fieldName).descending();
        } else {
            return Sort.by(fieldName).ascending();
        }
    }

    private void getQueryFilter(
            ExampleMatcher matcher, Listing example, String fieldName,
            String value,
            AdvSearch search) {

        switch (fieldName) {
            case "title":
                example.setTitle(value);
                break;
            case "description":
                example.setDescription(value);
                break;
            case "seller":
                example.setCreateFrom(value);
                break;
            case "category":break;
            case "condition":break;
            case "sellingFormat":break;
            case "price":
                switch (search.getPriceArrow()) {
                    case 1:
                    case 0:
                    default:
                }
                break;
        }

    }


}
