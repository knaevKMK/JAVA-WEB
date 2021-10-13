package exam.music.service.impl;

import exam.music.model.entity.Category;
import exam.music.model.entity.CategoryNameEnum;
import exam.music.repository.CategoryRepository;
import exam.music.service.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
          List< Category> categoreis= new ArrayList<>();
           categoreis.add(new Category(CategoryNameEnum.DRINK,1));
           categoreis.add(new Category(CategoryNameEnum.COFFEE,2));
           categoreis.add(new Category(CategoryNameEnum.OTHER,5));
           categoreis.add(new Category(CategoryNameEnum.CAKE,10));

           this.categoryRepository.saveAllAndFlush(categoreis);
        }
    }

    @Override
    public Category getByName(CategoryNameEnum category) {
        return this.categoryRepository.findByName(category);
    }
}
