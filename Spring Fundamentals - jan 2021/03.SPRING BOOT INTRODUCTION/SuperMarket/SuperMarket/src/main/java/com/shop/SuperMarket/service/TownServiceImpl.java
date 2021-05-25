package com.shop.SuperMarket.service;

import com.shop.SuperMarket.model.entities.Town;
import com.shop.SuperMarket.model.service.TownServiceModel;
import com.shop.SuperMarket.repositories.TownRepository;
import com.shop.SuperMarket.service.interfaces.TownService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class TownServiceImpl implements TownService {

    private final TownRepository townRepository;
    private final ModelMapper modelMapper;

    @Override
    public void addTown(TownServiceModel townServiceModel) {
        Town town = modelMapper.map(townServiceModel, Town.class);
        this.townRepository.save(town);
    }
}
