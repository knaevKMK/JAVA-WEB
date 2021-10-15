package exam.music.service.impl;

import exam.music.model.entity.CategoryEntity;
import exam.music.model.entity.CategoryEnum;
import exam.music.repository.CategoryRepository;
import exam.music.service.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;
    private final ModelMapper modelMapper;

    public CategoryServiceImpl(CategoryRepository categoryRepository, ModelMapper modelMapper) {
        this.categoryRepository = categoryRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public void seedData() {
        if (this.categoryRepository.count()==0){
            Arrays.stream(CategoryEnum.values())
                    .forEach( categoryEnum -> {
                        this.categoryRepository.saveAndFlush(new CategoryEntity(categoryEnum.name()));
                    });
        }
    }

    @Override
    public CategoryEntity findByName(String name) {

        return this.categoryRepository.findByName(name);
    }
}
