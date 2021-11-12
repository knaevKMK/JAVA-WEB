package com.project.shop.init;

import com.project.shop.service.CategoryService;
import com.project.shop.service.ConditionService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DbInit implements CommandLineRunner {
private final ConditionService conditionService;
private final CategoryService categoryService;
    public DbInit(ConditionService conditionService, CategoryService categoryService) {
        this.conditionService = conditionService;
        this.categoryService = categoryService;
    }

    @Override
    public void run(String... args) throws Exception {
        conditionService.seedData();
        categoryService.seedData();
    }
}
