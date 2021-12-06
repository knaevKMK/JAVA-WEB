package com.project.shop.init;

import com.project.shop.identityArea.request.RegisterHandler;
import com.project.shop.identityArea.service.IdentityService;
import com.project.shop.service.CategoryService;
import com.project.shop.service.ConditionService;
import com.project.shop.service.ListingService;
import com.project.shop.service.PaymentService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DbInit implements CommandLineRunner {
    private final ConditionService conditionService;
    private final CategoryService categoryService;
    private final IdentityService identityService;
    private final RegisterHandler registerHandler;
    private final ListingService listingService;
    private final PaymentService paymentService;

    public DbInit(ConditionService conditionService, CategoryService categoryService, IdentityService identityService, RegisterHandler registerHandler, ListingService listingService, PaymentService paymentService) {
        this.conditionService = conditionService;
        this.categoryService = categoryService;
        this.identityService = identityService;

        this.registerHandler = registerHandler;
        this.listingService = listingService;
        this.paymentService = paymentService;
    }

    @Override
    public void run(String... args) throws Exception {
        paymentService.seedData();
        conditionService.seedData();
        categoryService.seedData();
        identityService.initializeUsersAndRoles();
        registerHandler.seed5Accounts();
        listingService.seedData();
    }
}
