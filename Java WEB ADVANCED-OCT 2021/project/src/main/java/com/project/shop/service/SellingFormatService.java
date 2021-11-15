package com.project.shop.service;

import com.project.shop.model.binding.SellingFormatBindingModel;
import com.project.shop.model.entity.SellingFormat;

public interface SellingFormatService {
    void seedData();

    SellingFormat create(SellingFormatBindingModel sellingFormat);
}
