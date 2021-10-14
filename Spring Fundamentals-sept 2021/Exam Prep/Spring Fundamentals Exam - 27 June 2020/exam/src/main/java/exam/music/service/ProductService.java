package exam.music.service;

import exam.music.model.service.ProductServiceModel;
import exam.music.model.view.ProductViewModel;

import java.util.List;

public interface ProductService {
    void add(ProductServiceModel model);
    List<ProductViewModel> getAll();

    void delete(String id);

    void deleteAll();
}
