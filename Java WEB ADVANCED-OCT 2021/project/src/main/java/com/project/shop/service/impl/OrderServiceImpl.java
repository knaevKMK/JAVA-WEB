package com.project.shop.service.impl;

import com.project.shop.model.binding.BuyBindingModel;
import com.project.shop.model.binding.OrderBindingModel;
import com.project.shop.model.entity.Account;
import com.project.shop.model.entity.Listing;
import com.project.shop.model.entity.Order;
import com.project.shop.model.service.ListingServiceModel;
import com.project.shop.model.view.OrderViewModel;
import com.project.shop.repository.OrderRepository;
import com.project.shop.service.AccountService;
import com.project.shop.service.ListingService;
import com.project.shop.service.OrderService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl extends BaseServiceImpl<Order> implements OrderService {

    private final OrderRepository orderRepository;
    private final ListingService listingService;
    private final AccountService accountService;
    private final ModelMapper modelMapper;

    public OrderServiceImpl(OrderRepository orderRepository, ListingService listingService, AccountService accountService, ModelMapper modelMapper) {
        this.orderRepository = orderRepository;
        this.listingService = listingService;
        this.accountService = accountService;
        this.modelMapper = modelMapper;
    }

    @Override
    public Order placeOrder(BuyBindingModel buyModel, String buyer) {
        Order order = new Order();
        order.setQuantity(buyModel.getQuantity())
                .setPrice(buyModel.getPrice());
        Account buyerAccount = accountService.getAccountByUserName(buyer)
                .orElseThrow(() -> new NullPointerException(
                "You are not authorized to buy this item"));
        order.setBuyer(buyerAccount);
        Listing listing = listingService.getListingById(buyModel.getId())
                .orElseThrow(() -> new NullPointerException("Listing not available"));
        order.setListing(listing);
//        order.setSeller(listing.getSeller());
        order = this.onCreate(order, buyerAccount.getUsername());
        order.setCompleted(false);
        order.setDeliveryAddress("Please add delivery Address");
        return orderRepository.saveAndFlush(order);
    }

    @Override
    public Optional<OrderViewModel> getOrderBuyId(UUID id) {

        return orderRepository.findById(id)
                .map(e -> modelMapper.map(e, OrderViewModel.class))
                .stream().findFirst()
                ;
    }


    @Override
    public UUID confirmOrder(OrderBindingModel orderBindingModel, String username) throws IllegalAccessException {
        Order order = orderRepository.findById(orderBindingModel.getId())
                .orElseThrow(() -> new NullPointerException("Order not available"));
        if (!order.getBuyer().getUsername().equals(username)) {
            throw new IllegalAccessException("You are not authorized to complete this order");
        }
        Listing listing = listingService.getListingById(orderBindingModel.getListingId())
                .orElseThrow(() -> new NullPointerException("Listing not available"));


        Account buyer = accountService.findByUsername(username)
                .orElseThrow(() -> new NullPointerException("You are not authorized"));
        if(!Objects.equals(listing.getSellingFormat().getPrice(), order.getPrice())){
            throw new IllegalArgumentException("Price does not match");
        }
        int availableQuantity = listing.getSellingFormat().getQuantity();
        if(availableQuantity-orderBindingModel.getQuantity()<0){
            throw new IllegalArgumentException("Not enough quantity");
        }
        listing.getSellingFormat().setQuantity(availableQuantity-orderBindingModel.getQuantity());

        listingService.updateListing(listing);
        order.setQuantity(orderBindingModel.getQuantity());
        order.setDeliveryAddress(orderBindingModel.getDeliveryAddress());
        order.setCompleted(true);
        order=this.onModify(order,username);


        return orderRepository.saveAndFlush(order).getId();
    }

    @Override
    public Collection<OrderViewModel> getMyOrders(String sellerUsername, int page, int pcs) {
        return orderRepository.findAll()
                .stream().filter(o -> o.getListing().getSeller().getUsername().equals(sellerUsername))
                .map(e -> modelMapper.map(e, OrderViewModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public Collection<OrderViewModel> getPurchases(String buyerUsername, int page, int pcs) {
        return orderRepository.findAll()
                .stream().filter(o -> o.getBuyer().getUsername().equals(buyerUsername))
                .map(e -> modelMapper.map(e, OrderViewModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public void seedColumns() {
        orderRepository.addPriceColumn();
        orderRepository.addQuantityColumn();
    }
}
