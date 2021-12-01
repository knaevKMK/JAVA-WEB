package com.project.shop.service;

import com.project.shop.model.binding.SellingFormatBindingModel;
import com.project.shop.model.entity.SellingFormat;
import com.project.shop.model.view.ConditionViewModel;
import com.project.shop.model.view.SellingVewModel;

import java.util.Collection;

public interface SellingFormatService {

    SellingFormat create(SellingFormatBindingModel sellingFormat);

    Collection<SellingVewModel> getAll();

}
