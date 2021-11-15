package com.project.shop.service;

import com.project.shop.model.binding.ConditionBindingModel;
import com.project.shop.model.entity.ConditionItem;

public interface ConditionService {
    void seedData();

    ConditionItem find(ConditionBindingModel itemCondition);
}
