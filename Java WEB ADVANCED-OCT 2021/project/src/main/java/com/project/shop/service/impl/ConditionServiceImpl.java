package com.project.shop.service.impl;

import com.project.shop.model.binding.ConditionBindingModel;
import com.project.shop.model.entity.ConditionItem;
import com.project.shop.model.enums.ConditionEnum;
import com.project.shop.model.view.ConditionViewModel;
import com.project.shop.repository.ConditionRepository;
import com.project.shop.service.ConditionService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ConditionServiceImpl extends BaseServiceImpl<ConditionItem> implements ConditionService {
    private final ConditionRepository conditionRepository;
    private final ModelMapper modelMapper;

    public ConditionServiceImpl(ConditionRepository conditionRepository, ModelMapper modelMapper) {
        this.conditionRepository = conditionRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void seedData() {
        if (conditionRepository.count() != 0) {
            return;
        }
        List<ConditionItem> conditionItems = Arrays.stream(ConditionEnum.values())
                .map(cEnum -> {
                    ConditionItem conditionItem = new ConditionItem();
                    conditionItem
                            .setConditionTitle(cEnum)
                            .setTitle(cEnum.getTitle())
                            .setDescription("Description for " + cEnum.getTitle());
                    conditionItem = this.onCreate(conditionItem);

                    return conditionItem;
                }).collect(Collectors.toList());
        this.conditionRepository.saveAll(conditionItems);
    }

    @Override
    public ConditionItem find(ConditionBindingModel itemCondition) {
        if (itemCondition.getTitle() == null) {
            return this.conditionRepository.findById(itemCondition.getId())
                    // .orElseThrow(() -> new NullPointerException("Condition does not exist"));
                    .orElse(null);
        }
        return conditionRepository.findByTitle(itemCondition.getTitle().name())
                .orElse(null);
        //   .orElseThrow(() -> new NullPointerException("Condition does not exist"));

    }

    @Override
    public Collection<ConditionViewModel> getAll() {
        return conditionRepository
                .findAll()
                .stream()
                .map(e -> modelMapper.map(e, ConditionViewModel.class))
                .collect(Collectors.toList());
    }
}
