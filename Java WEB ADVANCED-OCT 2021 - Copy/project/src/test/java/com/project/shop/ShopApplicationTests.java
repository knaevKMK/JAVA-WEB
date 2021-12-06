package com.project.shop;

import com.project.shop.identityArea.api.IdentityController;
import com.project.shop.identityArea.models.binding.LoginRequest;
import com.project.shop.identityArea.models.binding.RegisterRequest;
import com.project.shop.model.Response;
import com.project.shop.model.binding.BuyBindingModel;
import com.project.shop.model.binding.ListingCreateModel;
import com.project.shop.web.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;


import javax.servlet.ServletContext;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
class ShopApplicationTests {
    private final String INVALID_UUID = "1b5e7a4e-37f8-48ce-bd93-397e54636bd1";
    private final String VALID_UUID = "1b6e7a4e-37f8-48ce-bd93-397e54636bd1";

    @Autowired
    private IdentityController identityController;

    @Autowired
    private ListingController listingController;
    @Autowired
    private AccountController accountController;
    @Autowired
    private CategoryController categoryController;
    @Autowired
    private ConditionController conditionController;
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

    @Autowired
    private WebApplicationContext webApplicationContext;
    private MockMvc mockMvc;

    @BeforeEach
    public void setup() throws Exception {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
    }

    @Test
    public void controllersExist() {
        ServletContext servletContext = webApplicationContext.getServletContext();

        assertThat(servletContext).isNotNull();
        assertThat(servletContext instanceof MockServletContext).isNotNull();
        assertThat(webApplicationContext.getBean("orderController")).isNotNull();
        assertThat(webApplicationContext.getBean("identityController")).isNotNull();
        assertThat(webApplicationContext.getBean("accountController")).isNotNull();
        assertThat(webApplicationContext.getBean("categoryController")).isNotNull();
        assertThat(webApplicationContext.getBean("feedbackController")).isNotNull();
        assertThat(webApplicationContext.getBean("messageController")).isNotNull();
        assertThat(webApplicationContext.getBean("sellingFormatController")).isNotNull();
        assertThat(webApplicationContext.getBean("listingController")).isNotNull();
        assertThat(webApplicationContext.getBean("conditionController")).isNotNull();
        assertThat(webApplicationContext.getBean("deliveryController")).isNotNull();
    }


    //msg
    @Test
    void messageControllerGetAllResponseWithStatus400_NullAuthentication() throws Exception {
        this.mockMvc
                .perform(get("/api/msg/all"))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    //order need authentication all methods
//    @Test
//    void orderControllerMyPurchasesResponseWithStatus400_NullAuthentication() throws Exception {
//         this.mockMvc
//                .perform(get("/api/orders/purchases?page={page}&limit={limit}&query={query}",0,10,""))
//                .andDo(print())
//                .andExpect(status().isBadRequest());
//    }
//    @Test
//    void orderControllerMySoldsResponseWithStatus400_NullAuthentication() throws Exception {
//        ResponseEntity<Response> all = orderController.getMyOrders(0,10, null);
//        assertThat(all.getStatusCode()).isEqualByComparingTo(HttpStatus.OK);
//        assertThat(all.getBody().getStatus()).isEqualByComparingTo(HttpStatus.BAD_REQUEST);
//        assertThat(all.getBody().getData().containsKey("orders")).isTrue();
//    }
    @Test
    void orderControllerCancelResponseWithStatus400_NullAuthentication() throws Exception {

        ResponseEntity<Response> all = orderController.cancelOrder(UUID.fromString(INVALID_UUID), null);
        assertThat(all.getStatusCode()).isEqualByComparingTo(HttpStatus.OK);
        assertThat(all.getBody().getStatus()).isEqualByComparingTo(HttpStatus.BAD_REQUEST);
        assertThat(all.getBody().getData().containsKey("delete")).isTrue();
    }

    @Test
    void orderControllerBuyResponseWithStatus400_NullAuthentication() throws Exception {
        ResponseEntity<Response> all = orderController.buyListing(new BuyBindingModel(), null);
        assertThat(all.getStatusCode()).isEqualByComparingTo(HttpStatus.OK);
        assertThat(all.getBody().getStatus()).isEqualByComparingTo(HttpStatus.BAD_REQUEST);
        assertThat(all.getBody().getData().containsKey("buy")).isTrue();
    }
//    @Test
//    void orderControllerConfirmResponseWithStatus400_NullAuthentication() throws Exception {
//        ResponseEntity<Response> all = orderController.confirm(new OrderBindingModel(), null);
//        assertThat(all.getStatusCode()).isEqualByComparingTo(HttpStatus.OK);
//        assertThat(all.getBody().getStatus()).isEqualByComparingTo(HttpStatus.BAD_REQUEST);
//        assertThat(all.getBody().getData().containsKey("confirm")).isTrue();
//    }
//    @Test
//    void orderControllerUpdateResponseWithStatus400_NullAuthentication() throws Exception {
//        ResponseEntity<Response> all = orderController.getOrderById(UUID.fromString(INVALID_UUID), null);
//        assertThat(all.getStatusCode()).isEqualByComparingTo(HttpStatus.OK);
//        assertThat(all.getBody().getStatus()).isEqualByComparingTo(HttpStatus.BAD_REQUEST);
//        assertThat(all.getBody().getData().containsKey("order")).isTrue();
//        assertThat(all.getBody().getData().get("order")).isNotNull();
//        assertThat(all.getBody().getMessage().equals("You must login")).isTrue();
//    }

    //listing: add with valid, also update
    @Test
    void listingControllerUpdateResponseWithStatus400_InvalidParams() throws Exception {
        ListingCreateModel model = new ListingCreateModel();
        model.setId(UUID.fromString(INVALID_UUID)).setCategory(null)
                .setCondition(null)
                .setDeliveryDomestic(null)
                .setDescription("")
                .setDeliveryInternational(null)
                .setImageUrl("")
                .setTitle("");
        ResponseEntity<Response> all = listingController.updateListing(UUID.fromString(INVALID_UUID), model, null);
        assertThat(all.getStatusCode()).isEqualByComparingTo(HttpStatus.OK);
        assertThat(all.getBody().getStatus()).isEqualByComparingTo(HttpStatus.BAD_REQUEST);
        assertThat(all.getBody().getData().containsKey("listing")).isTrue();
        assertThat(all.getBody().getData().get("listing")).isNotNull();
    }

    @Test
    void listingControllerCreateResponseWithStatus400_InvalidParams() throws Exception {
        ListingCreateModel model = new ListingCreateModel();
        model.setCategory(null)
                .setCondition(null)
                .setDeliveryDomestic(null)
                .setDescription("")
                .setDeliveryInternational(null)
                .setImageUrl("")
                .setTitle("");
        ResponseEntity<Response> all = listingController.createListing(model, null);
        assertThat(all.getStatusCode()).isEqualByComparingTo(HttpStatus.OK);
        assertThat(all.getBody().getStatus()).isEqualByComparingTo(HttpStatus.BAD_REQUEST);
        assertThat(all.getBody().getData().containsKey("listing")).isTrue();
        assertThat(all.getBody().getData().get("listing")).isNotNull();
    }

    @Test
    void listingControllerWatchResponseWithStatus400() throws Exception {
        ResponseEntity<Response> all = listingController.watch(UUID.fromString(INVALID_UUID), null);
        assertThat(all.getStatusCode()).isEqualByComparingTo(HttpStatus.OK);
        assertThat(all.getBody().getStatus()).isEqualByComparingTo(HttpStatus.BAD_REQUEST);
        assertThat(all.getBody().getData().containsKey("watch")).isTrue();
        assertThat(all.getBody().getData().get("watch")).isNotNull();
    }

    @Test
    void listingControllerDeleteResponseWithStatus200() throws Exception {

        ResponseEntity<Response> all = listingController.deleteListingById(UUID.fromString(VALID_UUID), null);
        assertThat(all.getStatusCode()).isEqualByComparingTo(HttpStatus.OK);
        assertThat(all.getBody().getStatus()).isEqualByComparingTo(HttpStatus.BAD_REQUEST);
        assertThat(all.getBody().getData().containsKey("deleted")).isTrue();
        assertThat(all.getBody().getData().get("deleted").equals(false)).isTrue();
        assertThat(all.getBody().getMessage()).isEqualTo("Listing with id: " + VALID_UUID + "  deleted");
    }

    @Test
    void listingControllerDeleteResponseWithStatus400() throws Exception {
        ResponseEntity<Response> all = listingController.deleteListingById(UUID.fromString(INVALID_UUID), null);
        assertThat(all.getStatusCode()).isEqualByComparingTo(HttpStatus.OK);
        assertThat(all.getBody().getStatus()).isEqualByComparingTo(HttpStatus.BAD_REQUEST);
        assertThat(all.getBody().getData().containsKey("deleted")).isTrue();
        assertThat(all.getBody().getData().get("deleted").equals(false)).isTrue();
    }

    @Test
    void listingControllerGetByIdResponseWithStatus200() throws Exception {
        ResponseEntity<Response> all = listingController.getListingById(UUID.fromString(VALID_UUID), null);
        assertThat(all.getStatusCode()).isEqualByComparingTo(HttpStatus.OK);
        assertThat(all.getBody().getStatus()).isEqualByComparingTo(HttpStatus.OK);
        assertThat(all.getBody().getData().containsKey("listing")).isTrue();
        assertThat(all.getBody().getData().get("listing")).isNotNull();
        assertThat(all.getBody().getMessage()).isEqualTo("Listing with id: " + VALID_UUID + "  retrieved");
    }

    @Test
    void listingControllerGetByIdResponseWithStatus400() throws Exception {
        ResponseEntity<Response> all = listingController.getListingById(UUID.fromString(INVALID_UUID), null);
        assertThat(all.getStatusCode()).isEqualByComparingTo(HttpStatus.OK);
        assertThat(all.getBody().getStatus()).isEqualByComparingTo(HttpStatus.BAD_REQUEST);
        assertThat(all.getBody().getData().containsKey("id")).isTrue();
        assertThat(all.getBody().getData().get("id")).isNotNull();
        assertThat(all.getBody().getMessage()).isEqualTo("Listing does not exist");
    }

    @Test
    void listingControllerGetAllResponseWithStatus200() throws Exception {
        ResponseEntity<Response> all = listingController.getAllListings(null, null, null, null, 0, 5, null);
        assertThat(all.getStatusCode()).isEqualByComparingTo(HttpStatus.OK);
        assertThat(all.getBody().getStatus()).isEqualByComparingTo(HttpStatus.OK);
        assertThat(all.getBody().getData().containsKey("listings")).isTrue();
        assertThat(all.getBody().getData().get("listings")).isNotNull();
        assertThat(all.getBody().getMessage()).isEqualTo("Listings retrieved");
    }


    //identity
    @Test
    void identityControllerLogoutResponseWithStatus200() throws Exception {

        ResponseEntity<Response> all = identityController.logout();
        assertThat(all.getStatusCode()).isEqualByComparingTo(HttpStatus.OK);
        assertThat(all.getBody().getStatus()).isEqualByComparingTo(HttpStatus.OK);
        assertThat(all.getBody().getData().containsKey("logout")).isTrue();
        assertThat(all.getBody().getData().get("logout").equals(true)).isTrue();
        assertThat(all.getBody().getMessage()).isEqualTo("Successful Log Out");
    }

    @Test
    void identityControllerConfirmResponseWithStatus400() throws Exception {

        ResponseEntity<Response> all = identityController.confirm("model-token-of-register-user");
        assertThat(all.getStatusCode()).isEqualByComparingTo(HttpStatus.OK);
        assertThat(all.getBody().getStatus()).isEqualByComparingTo(HttpStatus.BAD_REQUEST);
        assertThat(all.getBody().getData().containsKey("confirmed")).isTrue();
        assertThat(all.getBody().getData().get("confirmed").equals(false)).isTrue();
        assertThat(all.getBody().getMessage()).isEqualTo("token not found");
    }

    @Test
    void identityControllerOnRegisterResponseWithStatus400InvalidParams() throws Exception {
        RegisterRequest model = new RegisterRequest();
        model
                .setUsername("de")
                .setFirstName("Demo")
                .setLastName("Demov")
                .setEmail("demo@aa.aa")
                .setPassword("12")
                .setConfirmPassword("123");
        ResponseEntity<Response> all = identityController.register(model);
        assertThat(all.getStatusCode()).isEqualByComparingTo(HttpStatus.OK);
        assertThat(all.getBody().getStatus()).isEqualByComparingTo(HttpStatus.BAD_REQUEST);
        assertThat(all.getBody().getData().containsKey("register")).isTrue();
        assertThat(all.getBody().getData().get("register")).isNotNull();
        assertThat(all.getBody().getMessage()).isEqualTo("un-success registration");
    }

    @Test
    void identityControllerOnRegisterResponseWithStatus200() throws Exception {
        RegisterRequest model = new RegisterRequest();
        model
                .setUsername("demouser")
                .setFirstName("Demo")
                .setLastName("Demov")
                .setEmail("demo@aa.aa")
                .setPassword("12345")
                .setConfirmPassword("12345");
        ResponseEntity<Response> all = identityController.register(model);
        assertThat(all.getStatusCode()).isEqualByComparingTo(HttpStatus.OK);
        assertThat(all.getBody().getStatus()).isEqualByComparingTo(HttpStatus.OK);
        assertThat(all.getBody().getData().containsKey("confirm")).isTrue();
        assertThat(all.getBody().getData().get("confirm")).isNotNull();
        assertThat(all.getBody().getMessage()).isEqualTo("Successful registration");
    }

    @Test
    void identityControllerOnLoginResponseWithStatus400WithNonExistUser() throws Exception {
        //Non Exist username
        LoginRequest model = new LoginRequest();
        model.setUsername("mdivancho").setPassword("12345");
        ResponseEntity<Response> all = identityController.login(model);
        assertThat(all.getStatusCode()).isEqualByComparingTo(HttpStatus.OK);
        assertThat(all.getBody().getStatus()).isEqualByComparingTo(HttpStatus.BAD_REQUEST);
        assertThat(all.getBody().getData().containsKey("login")).isTrue();
        assertThat(all.getBody().getData().get("login")).isNotNull();
        assertThat(all.getBody().getMessage()).isEqualTo("un-success login");
    }

    @Test
    void identityControllerOnLoginResponseWithStatus400WithInvalidParams() throws Exception {
        //invalid username and password
        LoginRequest model = new LoginRequest();
        model.setUsername("i").setPassword("mika");
        ResponseEntity<Response> all = identityController.login(model);
        assertThat(all.getStatusCode()).isEqualByComparingTo(HttpStatus.OK);
        assertThat(all.getBody().getStatus()).isEqualByComparingTo(HttpStatus.BAD_REQUEST);
        assertThat(all.getBody().getData().containsKey("login")).isTrue();
        assertThat(all.getBody().getData().get("login")).isNotNull();
        assertThat(all.getBody().getMessage()).isEqualTo("un-success login");
    }

    @Test
    void identityControllerOnLoginResponseWithStatus200() throws Exception {
        LoginRequest model = new LoginRequest();
        model.setUsername("ivancho").setPassword("12345");
        ResponseEntity<Response> all = identityController.login(model);
        assertThat(all.getStatusCode()).isEqualByComparingTo(HttpStatus.OK);
        assertThat(all.getBody().getStatus()).isEqualByComparingTo(HttpStatus.OK);
        assertThat(all.getBody().getData().containsKey("login")).isTrue();
        assertThat(all.getBody().getData().get("login")).isNotNull();
        assertThat(all.getBody().getMessage()).isEqualTo("Successful Sing-in");
    }

    //category
    @Test
    void categoryControllerResponseWithStatus200() throws Exception {
        ResponseEntity<Response> all = categoryController.getAll();
        assertThat(all.getStatusCode()).isEqualByComparingTo(HttpStatus.OK);
        assertThat(all.getBody().getStatus()).isEqualByComparingTo(HttpStatus.OK);
        assertThat(all.getBody().getData().containsKey("categories")).isTrue();
        assertThat(all.getBody().getData().get("categories")).isNotNull();
        assertThat(all.getBody().getMessage()).isEqualTo("Category list");
        //   mockMvc.perform(get("/api/condition/all")).andExpect(status().isOk());
    }

    //condition
    @Test
    void conditionControllerResponseWithStatus200() throws Exception {
        ResponseEntity<Response> all = conditionController.getAll();
        assertThat(all.getStatusCode()).isEqualByComparingTo(HttpStatus.OK);
        assertThat(all.getBody().getStatus()).isEqualByComparingTo(HttpStatus.OK);
        assertThat(all.getBody().getData().containsKey("conditions")).isTrue();
        assertThat(all.getBody().getData().get("conditions")).isNotNull();
        assertThat(all.getBody().getMessage()).isEqualTo("Condition list");
    }

    //selling format
    @Test
    void sellingFormatControllerResponseWithStatus200() throws Exception {
        ResponseEntity<Response> all = sellingFormatController.getAll();
        assertThat(all.getStatusCode()).isEqualByComparingTo(HttpStatus.OK);
        assertThat(all.getBody().getStatus()).isEqualByComparingTo(HttpStatus.OK);
        assertThat(all.getBody().getData().containsKey("selling-formats")).isTrue();
        assertThat(all.getBody().getData().get("selling-formats")).isNotNull();
        assertThat(all.getBody().getMessage()).isEqualTo("Selling Format list");
    }

    //delivery
    @Test
    void deliveryControllerResponseWithStatus200() throws Exception {
        ResponseEntity<Response> all = deliveryController.getAll();
        assertThat(all.getStatusCode()).isEqualByComparingTo(HttpStatus.OK);
        assertThat(all.getBody().getStatus()).isEqualByComparingTo(HttpStatus.OK);
        assertThat(all.getBody().getData().containsKey("delivery")).isTrue();
        assertThat(all.getBody().getData().get("delivery")).isNotNull();
        assertThat(all.getBody().getMessage()).isEqualTo("Delivery list");
    }


}
