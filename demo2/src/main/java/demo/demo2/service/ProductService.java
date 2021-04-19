package demo.demo2.service;

import demo.demo2.entity.Product;
import demo.demo2.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    public List<Product> saveProducts(List<Product> products) {
        return productRepository.saveAll(products);
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(int id) {
        return productRepository.findById(id).orElse(null);
    }

    public Product getProductByName(String name) {
        return productRepository.findByName(name);
    }

    public String deleteProduct(int id) {
        productRepository.deleteById(id);
        return "Product removed!";
    }

    public Product updateProduct(int id ,Product product) {
        Product temp = productRepository.findById(id).orElse(null);
        if (temp != null) {
            temp.setName(product.getName());
            temp.setQuantity(product.getQuantity());
            temp.setPrice(product.getPrice());
            productRepository.save(temp);
        }
        return temp;
    }
}
