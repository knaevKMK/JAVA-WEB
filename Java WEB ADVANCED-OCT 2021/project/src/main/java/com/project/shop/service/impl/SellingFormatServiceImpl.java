package com.project.shop.service.impl;

import com.project.shop.model.entity.Offer;
import com.project.shop.model.entity.SellingFormat;
import com.project.shop.model.enums.SellingFormatEnum;
import com.project.shop.repository.impl.BaseRepositoryImpl;
import com.project.shop.service.OfferService;
import com.project.shop.service.SellingFormatRepository;
import com.project.shop.service.SellingFormatService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SellingFormatServiceImpl extends BaseRepositoryImpl<SellingFormat> implements SellingFormatService {
    private final SellingFormatRepository sellingRepository;

    public SellingFormatServiceImpl(SellingFormatRepository sellingRepository) {
        this.sellingRepository = sellingRepository;
    }

    @Override
    public void seedData() {
        List<SellingFormat> sellingFormatList = Arrays.stream(SellingFormatEnum.values())
                .map(sellingEnum -> {
                    SellingFormat sellingFormat = new SellingFormat();
                    sellingFormat
                            .setSellingFormatTitle(sellingEnum.name())
                            .setPrice(sellingEnum.getPrice())
                            .setQuantity(sellingEnum.getQuantity())
                            .setDaysDuration(7);

                    sellingFormat = this.onCreate(sellingFormat);

                    return sellingFormat;
                })
                .collect(Collectors.toList());
        this.sellingRepository.saveAllAndFlush(sellingFormatList);
    }
}
