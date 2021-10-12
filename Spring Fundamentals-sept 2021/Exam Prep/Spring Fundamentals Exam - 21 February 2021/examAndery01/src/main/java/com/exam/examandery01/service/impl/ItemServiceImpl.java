package com.exam.examandery01.service.impl;

import com.exam.examandery01.model.entity.Item;
import com.exam.examandery01.model.services.ItemServiceModel;
import com.exam.examandery01.model.view.ItemViewModel;
import com.exam.examandery01.repository.ItemRepository;
import com.exam.examandery01.service.CategoryService;
import com.exam.examandery01.service.ItemService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
     item.setImageUrl(String.format("/img/%s-%s.jpg", model.getGender(), model.getCategory().getCategory().name()));
      //  System.out.println();
      return   this.itemRepository.saveAndFlush(item).getId();
    }

    @Override
    public ItemViewModel GetItemById(String id) {
        return this.itemRepository.findById(id).map(item -> modelMapper.map(item,ItemViewModel.class)).orElse(null);
    }

    @Override
    public List<ItemViewModel> getAll() {
        return this.itemRepository.findAll()
                .stream()
                .map(item ->  modelMapper.map(item, ItemViewModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public void delete(String id) {

       this.itemRepository.deleteById(id);


    }
}
