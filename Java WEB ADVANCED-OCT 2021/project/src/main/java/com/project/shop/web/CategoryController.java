package com.project.shop.web;

import com.project.shop.model.Response;
import com.project.shop.model.binding.CategoryBindingModel;
import com.project.shop.model.view.CategoryViewModel;
import com.project.shop.service.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/all")
    public ResponseEntity<Response> getAll(){
        Collection<CategoryViewModel> all = categoryService.getAll();
        return ResponseEntity.ok(Response
                .builder()
                .timeStamp(LocalDateTime.now())
                .data(Map.of("categories",all))
                .message("Category list")
                .status(HttpStatus.OK)
                .statusCode(HttpStatus.OK.value())
                .build());
    }
}
