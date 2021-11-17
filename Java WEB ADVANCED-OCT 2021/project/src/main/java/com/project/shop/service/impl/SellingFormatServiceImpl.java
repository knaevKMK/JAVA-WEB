package com.project.shop.service.impl;

import com.project.shop.model.binding.SellingFormatBindingModel;
import com.project.shop.model.entity.SellingFormat;
import com.project.shop.model.view.ConditionViewModel;
import com.project.shop.model.view.SellingVewModel;
import com.project.shop.repository.SellingFormatRepository;
import com.project.shop.service.SellingFormatService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class SellingFormatServiceImpl extends BaseServiceImpl<SellingFormat> implements SellingFormatService {
    private final SellingFormatRepository sellingRepository;
    private  final ModelMapper modelMapper;

    public SellingFormatServiceImpl(SellingFormatRepository sellingRepository, ModelMapper modelMapper) {
        this.sellingRepository = sellingRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void seedData() {

    }

    @Override
    public SellingFormat create(SellingFormatBindingModel sellingFormatModel) {
        SellingFormat sellingFormat= modelMapper.map(sellingFormatModel,SellingFormat.class);
        return sellingRepository.saveAndFlush(sellingFormat);
    }

    @Override
    public Collection<SellingVewModel> getAll() {

        return sellingRepository
                .findAll()
                .stream().map(e-> modelMapper.map(e,SellingVewModel.class))
                .collect(Collectors.toList());
    }
}
