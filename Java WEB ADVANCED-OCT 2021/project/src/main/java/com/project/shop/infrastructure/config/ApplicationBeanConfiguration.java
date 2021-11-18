package com.project.shop.infrastructure.config;

import com.project.shop.model.binding.ConditionBindingModel;
import com.project.shop.model.entity.CategoryItem;
import com.project.shop.model.entity.ConditionItem;
import com.project.shop.model.entity.Listing;
import com.project.shop.model.view.*;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.print.attribute.standard.Destination;

@Configuration
public class ApplicationBeanConfiguration {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();

        TypeMap<ConditionItem, ConditionViewModel> conditionTypeMap = modelMapper.createTypeMap(ConditionItem.class, ConditionViewModel.class);
        modelMapper.createTypeMap(ConditionBindingModel.class, ConditionItem.class);

        modelMapper.createTypeMap(Listing.class, ListingInListViewModel.class)
                .addMappings(mapper -> {
                    mapper.map(src -> src.getSellingFormat().getPrice(), ListingInListViewModel::setPrice);
                });

        modelMapper.createTypeMap(Listing.class, ListingViewModel.class)
        //            .addMappings(mapper->{
//               mapper.map(Listing::getCategory,(dest,v)->dest.setCategory(modelMapper.map(v, CategoryViewModel.class)));
//                mapper.map(Listing::getCondition,(dest,v)->dest.setCondition(modelMapper.map(v, ConditionViewModel.class)));
//                mapper.map(Listing::getSellingFormat,(dest,v)->dest.setSellingFormat(modelMapper.map(v, SellingVewModel.class)));
//                mapper.map(Listing::getDeliveryDomestic,(dest,v)->dest.setDeliveryDomestic(modelMapper.map(v, DeliveryViewModel.class)));
//                mapper.map(Listing::getDeliveryInternational,(dest,v)->dest.setDeliveryInternational(modelMapper.map(v, DeliveryViewModel.class)));

        //         })
        ;
        return modelMapper;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(10);
    }
}
