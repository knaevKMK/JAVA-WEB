package com.project.shop.service.impl;

import com.project.shop.model.entity.ConditionItem;
import com.project.shop.model.enums.ConditionEnum;
import com.project.shop.repository.ConditionRepository;
import com.project.shop.service.ConditionService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ConditionServiceImpl implements ConditionService {
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
                            .setDescription("Description for " + cEnum.name())
                            .setActive(true)
                            .setCreateOn(LocalDateTime.now())
                            .setCreateFrom("system")
                            .setModifiedOn(LocalDateTime.now())
                            .setModifiedFrom("system");
                    return conditionItem;
                }).collect(Collectors.toList());
        this.conditionRepository.saveAll(conditionItems);
    }
}
