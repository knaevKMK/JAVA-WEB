package exam.music.service.impl;

import exam.music.model.entity.Product;
import exam.music.model.service.ProductServiceModel;
import exam.music.model.view.ProductViewModel;
import exam.music.repository.ProductRepository;
import exam.music.service.CategoryService;
import exam.music.service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {
    private final ModelMapper modelMapper;
    private final ProductRepository productRepository;
    private final CategoryService categoryService;

    public ProductServiceImpl(ModelMapper modelMapper, ProductRepository productRepository, CategoryService categoryService) {
        this.modelMapper = modelMapper;
        this.productRepository = productRepository;
        this.categoryService = categoryService;
    }

    public void add(ProductServiceModel model) {
        Product map = modelMapper.map(model, Product.class);
        map.setCategory(this.categoryService.findByName(model.getCategory()));
        System.out.println();
        this.productRepository.saveAndFlush(map);
    }


    @Override
    public List<ProductViewModel> getAll() {
        return this.productRepository.findAll()
                .stream().map(product -> {
                    ProductViewModel model = modelMapper.map(product, ProductViewModel.class);
                    model.setCategory(product.getCategory().getName().name());
                    return model;
                }).collect(Collectors.toList());
    }

    @Override
    public void delete(String id) {
        this.productRepository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        this.productRepository.deleteAll();
    }
}
