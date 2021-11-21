package com.project.shop.init;

import com.project.shop.infrastructure.identity.service.IdentityService;
import com.project.shop.service.CategoryService;
import com.project.shop.service.ConditionService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DbInit implements CommandLineRunner {
private final ConditionService conditionService;
private final CategoryService categoryService;
private  final IdentityService identityService;


    public DbInit(ConditionService conditionService, CategoryService categoryService, IdentityService identityService) {
        this.conditionService = conditionService;
        this.categoryService = categoryService;
        this.identityService = identityService;
    }

    @Override
    public void run(String... args) throws Exception {
        conditionService.seedData();
        categoryService.seedData();
        identityService.initializeUsersAndRoles();
    }
}
