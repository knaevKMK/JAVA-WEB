package com.exam.examandery01.service.impl;

import com.exam.examandery01.model.entity.Item;
import com.exam.examandery01.model.services.ItemServiceModel;
import com.exam.examandery01.repository.ItemRepository;
import com.exam.examandery01.service.CategoryService;
import com.exam.examandery01.service.ItemService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class ItemServiceImpl implements ItemService {

    private final ItemRepository itemRepository;
    private final ModelMapper modelMapper;
private final CategoryService categoryService;
    public ItemServiceImpl(ItemRepository itemRepository, ModelMapper modelMapper, CategoryService categoryService) {
        this.itemRepository = itemRepository;
        this.modelMapper = modelMapper;
        this.categoryService = categoryService;
    }


    @Override
    public String add(ItemServiceModel model) {
        Item item = modelMapper.map(model, Item.class);
     item.setCategory(this.categoryService.findByCategoryName(model.getCategory()));
        System.out.println();
      return   this.itemRepository.saveAndFlush(item).getId();
    }
}
