package com.project.shop.config;

import com.project.shop.model.entity.*;
import com.project.shop.model.service.ListingReadModel;
import com.project.shop.model.view.*;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
@Configuration
public class ApplicationBeanConfiguration {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();

        modelMapper.createTypeMap(Listing.class, ListingInListViewModel.class)
                .addMappings(mapper -> mapper.map(src -> src.getSellingFormat().getPrice(), ListingInListViewModel::setPrice));
modelMapper.createTypeMap(Listing.class, ListingViewModel.class)
                .addMappings(mapper->mapper.map(src->src.getPayment().getTitle(),ListingViewModel::setPayment));


        modelMapper.createTypeMap(Order.class, OrderViewModel.class)
                .addMappings(mapper -> {
                    mapper.map(src -> src.getListing().getTitle(), OrderViewModel::setListingTitle);
                    mapper.map(src -> src.getListing().getImageUrl(), OrderViewModel::setListingImageUrl);
                    mapper.map(src -> src.getBuyer().getUsername(), OrderViewModel::setBuyerUsername);
                    mapper.map(src -> src.getListing().getCreateFrom(), OrderViewModel::setSellerUsername);

                });

        modelMapper.createTypeMap(Message.class, MsgListViewModel.class)
                .addMappings(mapper -> {
                    mapper.map(src -> src.getRecipient().getUsername(), MsgListViewModel::setRecipient);
                    mapper.map(BaseEntity::getCreateFrom, MsgListViewModel::setSender);
                    mapper.map(src -> src.getListing().getTitle(), MsgListViewModel::setTitle);
                });
        modelMapper.createTypeMap(Message.class, MsgViewModel.class)
                .addMappings(mapper->{
                    mapper.map(BaseEntity::getCreateFrom,MsgViewModel::setSender);
                    mapper.map(src->src.getRecipient().getUsername(),MsgViewModel::setRecipient);

                });

        modelMapper.createTypeMap(Feedback.class,FeedbackInListVewModel.class)
                .addMappings(mapper->{
                   mapper.map(src->src.getOrder().getBuyer().getUsername(),FeedbackInListVewModel::setSender);
                    mapper.map(src->src.getOrder().getListing().getTitle(),FeedbackInListVewModel::setListingTitle);
                    mapper.map(src->src.getOrder().getListing().getCreateFrom(),FeedbackInListVewModel::setRecipient);
                });
        return modelMapper;
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }

}
