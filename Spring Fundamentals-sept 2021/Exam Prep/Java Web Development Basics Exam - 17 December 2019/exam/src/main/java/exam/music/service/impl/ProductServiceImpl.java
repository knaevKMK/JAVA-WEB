package exam.music.service.impl;

import exam.music.model.entity.Product;
import exam.music.model.service.ProductServiceModel;
import exam.music.model.view.ProductViewModel;
import exam.music.repository.ProductRepository;
import exam.music.service.CategoryService;
import exam.music.service.GenderService;
import exam.music.service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;
    private final CategoryService categoryService;
    private final GenderService genderService;

    public ProductServiceImpl(ProductRepository productRepository, ModelMapper modelMapper, CategoryService categoryService, GenderService genderService) {
        this.productRepository = productRepository;
        this.modelMapper = modelMapper;
        this.categoryService = categoryService;
        this.genderService = genderService;
    }


    @Override
    public void add(ProductServiceModel model) {
        Product product = modelMapper.map(model, Product.class);
        product.setCategory(this.categoryService.findByName(model.getCategory().name()));
        product.setSex(this.genderService.findByName(model.getSex().name()));
        this.productRepository.saveAndFlush(product);
    }

    @Override
    public List<ProductViewModel> findAll() {

        return this.productRepository.findAll()
                .stream().map(product->mapToViewModel(product))
                .collect(Collectors.toList());

    }

    @Override
    public ProductViewModel findById(String id) {
        return this.productRepository.findById(id)
                .map(product -> mapToViewModel(product))
                .orElse(null);
    }

    @Override
    public void delete(String id) {
        this.productRepository.deleteById(id);
    }


    private ProductViewModel mapToViewModel (Product product){
        ProductViewModel model = modelMapper.map(product, ProductViewModel.class);
        model.setImageUrl(String.format("/img/%s-%s.jpg", product.getSex().getGender().toUpperCase(), product.getCategory().getName().toUpperCase()));
        return model;
    }
}
