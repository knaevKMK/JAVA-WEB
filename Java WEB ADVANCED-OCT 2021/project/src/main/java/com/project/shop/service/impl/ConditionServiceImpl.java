package com.project.shop.service.impl;

import com.project.shop.repository.impl.BaseRepositoryImpl;
import com.project.shop.model.entity.ConditionItem;
import com.project.shop.model.enums.ConditionEnum;
import com.project.shop.repository.ConditionRepository;
import com.project.shop.service.ConditionService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ConditionServiceImpl extends BaseRepositoryImpl<ConditionItem> implements ConditionService {
    private final ConditionRepository conditionRepository;

    public ConditionServiceImpl(ConditionRepository conditionRepository) {
        this.conditionRepository = conditionRepository;
    }

    @Override
    public void seedData() {
        if (conditionRepository.count()!=0){
            return;
        }
        List<ConditionItem> conditionItems = Arrays.stream(ConditionEnum.values())
                .map(cEnum -> {
                    ConditionItem conditionItem = new ConditionItem();
                    conditionItem
                            .setConditionTitle(cEnum)
                            .setTitle(cEnum.name())
                            .setDescription("Description for " + cEnum.name());
                    conditionItem=this.onCreate(conditionItem);

                    return conditionItem;
                }).collect(Collectors.toList());
        this.conditionRepository.saveAll(conditionItems);
    }
}
