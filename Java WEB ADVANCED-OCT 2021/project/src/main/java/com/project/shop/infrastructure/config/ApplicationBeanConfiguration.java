package com.project.shop.infrastructure.config;

import com.project.shop.model.binding.ConditionBindingModel;
import com.project.shop.model.entity.ConditionItem;
import com.project.shop.model.entity.Listing;
import com.project.shop.model.entity.Order;
import com.project.shop.model.entity.SellingFormat;
import com.project.shop.model.view.*;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationBeanConfiguration {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();

        modelMapper.createTypeMap(ConditionBindingModel.class, ConditionItem.class);
        modelMapper.createTypeMap(SellingFormat.class, SellingVewModel.class)      ;

        modelMapper.createTypeMap(Listing.class, ListingInListViewModel.class)
                .addMappings(mapper -> mapper.map(src -> src.getSellingFormat().getPrice(), ListingInListViewModel::setPrice));


        modelMapper.createTypeMap(Listing.class, ListingViewModel.class)
                .addMappings(mapper->{
  //                  mapper.map(src-> src.getCreateOn().plusDays(src.getSellingFormat().getDuration()),ListingViewModel::setEndOn);
//                    mapper.map(src-> src.getWatchers().size(),ListingViewModel::setWatchCount);
                });


        modelMapper.createTypeMap(Order.class, OrderViewModel.class)
                .addMappings(mapper -> {
                    mapper.map(src -> src.getListing().getTitle(), OrderViewModel::setListingTitle);
                    mapper.map(src -> src.getListing().getImageUrl(), OrderViewModel::setListingImageUrl);
                    mapper.map(src -> src.getBuyer().getUsername(), OrderViewModel::setBuyerUsername);
                    mapper.map(src -> src.getListing().getCreateFrom(), OrderViewModel::setSellerUsername);

                });

        return modelMapper;
    }


}
