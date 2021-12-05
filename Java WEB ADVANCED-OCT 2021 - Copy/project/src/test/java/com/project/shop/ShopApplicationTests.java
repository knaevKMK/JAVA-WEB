package com.project.shop;

import com.project.shop.identityArea.api.IdentityController;
import com.project.shop.web.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class ShopApplicationTests {

    @Autowired
    private IdentityController identityController;
    @Autowired
    private ListingController listingController;
    @Autowired
    private AccountController accountController;
    @Autowired
    private CategoryController categoryController;
    @Autowired
    private DeliveryController deliveryController;
    @Autowired
    private FeedbackController feedbackController;
    @Autowired
    private MessageController messageController;
    @Autowired
    private OrderController orderController;
    @Autowired
    private SellingFormatController sellingFormatController;


    @Test
    void controllersExist() throws Exception {
        assertThat(identityController).isNotNull();
        assertThat(accountController).isNotNull();
        assertThat(categoryController).isNotNull();
        assertThat(feedbackController).isNotNull();
        assertThat(messageController).isNotNull();
        assertThat(orderController).isNotNull();
        assertThat(sellingFormatController).isNotNull();
        assertThat(listingController).isNotNull();
    }

}
