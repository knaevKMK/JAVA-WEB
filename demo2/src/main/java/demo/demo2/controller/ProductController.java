package demo.demo2.controller;


import com.fasterxml.jackson.annotation.JsonFormat;
import demo.demo2.entity.Product;
import demo.demo2.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    public ProductService productService;


    @GetMapping("/product_id/{id}")
    public Product getProductById(@PathVariable int id) {
        System.out.println(id);
        return this.productService.getProductById(id);
    }

    @GetMapping("/product/{name}")
    public Product getProductByName(@PathVariable String name) {
        return this.productService.getProductByName(name);
    }

    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return this.productService.getAllProducts();
    }

    @PostMapping("/addProduct")
    public Product addProduct(@RequestBody @JsonFormat Product product) {
        return this.productService.saveProduct(product);
    }

    @PostMapping("/addProducts")
    public List<Product> addProducts(@JsonFormat List<Product> products) {
        return this.productService.saveProducts(products);
    }

    @PutMapping("/update/{id}")
    public Product upodateProduct(@PathVariable int id,
            @RequestBody @JsonFormat Product product) {
        return this.productService.updateProduct(id,product);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteProduct(@PathVariable int id) {
        return this.productService.deleteProduct(id);
    }
}
