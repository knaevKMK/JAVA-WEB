package exam.music.service.impl;

import exam.music.model.entity.CategoryEntity;
import exam.music.model.entity.CategoryNameEnum;
import exam.music.repository.CategoryRepository;
import exam.music.service.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class CategoryServiceImpl implements CategoryService
{

    private final CategoryRepository categoryRepository;
    private final ModelMapper modelMapper;

    public CategoryServiceImpl(CategoryRepository categoryRepository, ModelMapper modelMapper) {
        this.categoryRepository = categoryRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public CategoryEntity findByName(CategoryNameEnum name) {
        return this.categoryRepository.findByName(name);
    }

    @Override
    public void seedData() {
        if(this.categoryRepository.count()==0){

            Arrays.stream(CategoryNameEnum.values())
                    .forEach(categoryNameEnum -> {
                        int time=0;
                        switch (categoryNameEnum.name().toLowerCase()){
                            case "drink": time=1; break;
                            case "coffee": time=2; break;
                            case "other": time=5; break;
                            case "cake": time=10; break;

                        }
             this.categoryRepository.saveAndFlush(new CategoryEntity(categoryNameEnum,time));

                    });
        }
    }
}
