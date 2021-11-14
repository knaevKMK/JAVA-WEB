package com.project.shop.init;

import com.project.shop.service.CategoryService;
import com.project.shop.service.ConditionService;
import com.project.shop.service.DeliveryService;
import com.project.shop.service.SellingFormatService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DbInit implements CommandLineRunner {
private final ConditionService conditionService;
private final CategoryService categoryService;
private final DeliveryService deliveryService;
private final SellingFormatService sellingFormatService;


    public DbInit(ConditionService conditionService, CategoryService categoryService, DeliveryService deliveryService, SellingFormatService sellingFormatService) {
        this.conditionService = conditionService;
        this.categoryService = categoryService;
        this.deliveryService = deliveryService;
        this.sellingFormatService = sellingFormatService;
    }

    @Override
    public void run(String... args) throws Exception {
        conditionService.seedData();
        categoryService.seedData();
        deliveryService.seedData();
        sellingFormatService.seedData();
    }
}
