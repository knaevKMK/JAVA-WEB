package com.project.shop.service.impl;

import com.project.shop.repository.impl.BaseRepositoryImpl;
import com.project.shop.model.entity.CategoryItem;
import com.project.shop.model.enums.CategoryEnum;
import com.project.shop.model.view.CategoryViewModel;

import com.project.shop.repository.CategoryRepository;
import com.project.shop.service.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Transactional
@Service
public class CategoryServiceImpl extends BaseRepositoryImpl<CategoryItem> implements CategoryService {
private final CategoryRepository categoryRepository;
private final ModelMapper modelMapper;

    public CategoryServiceImpl(CategoryRepository categoryRepository, ModelMapper modelMapper) {
        this.categoryRepository = categoryRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void seedData() {
if (categoryRepository.count()!=0){return;}
        Arrays.stream(CategoryEnum.values())
                .forEach(en->{
                    CategoryItem parentCategoryItem = new CategoryItem();
                    parentCategoryItem
                            .setTitle(en.name())
                            .setDescription("Description for " + en.name());
//                            .setActive(true)
//                            .setCreateOn(LocalDateTime.now())
//                            .setCreateFrom("system");

                    parentCategoryItem=this.onCreate(parentCategoryItem);

                    CategoryItem savedCategoryItem = categoryRepository.saveAndFlush(parentCategoryItem);
                    List<CategoryItem> subList = en.getList()
                            .stream()
                            .map(subEn -> {
                                CategoryItem subCategoryItem = new CategoryItem();
                                subCategoryItem
                                        .setParentCategory(savedCategoryItem)
                                        .setTitle(subEn)
                                        .setDescription("Sub Category of "+savedCategoryItem.getTitle());
                                subCategoryItem=this.onCreate(subCategoryItem);
//                                        .setActive(true)
//                                        .setCreateOn(LocalDateTime.now())
//                                        .setCreateFrom("system");
                                return subCategoryItem;
                            }).collect(Collectors.toList());
                    this.categoryRepository.saveAll(subList);
                });

    }

    @Override
    public List<CategoryViewModel> getAll() {
        return this.categoryRepository.findAll().stream()
                .map(t->modelMapper.map(t,CategoryViewModel.class))
                .collect(Collectors.toList());
    }
}
