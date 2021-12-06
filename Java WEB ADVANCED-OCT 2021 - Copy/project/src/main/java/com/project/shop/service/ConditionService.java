package com.project.shop.service;

import com.project.shop.model.binding.ConditionBindingModel;
import com.project.shop.model.entity.ConditionItem;
import com.project.shop.model.view.ConditionViewModel;

import java.util.Collection;

public interface ConditionService {
    void seedData();

    ConditionItem find(ConditionBindingModel itemCondition);

    Collection<ConditionViewModel> getAll();

    ConditionItem findByTitle(String title);
}
