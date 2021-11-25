package com.project.shop.web;

import com.project.shop.infrastructure.identity.models.entity.UserEntity;
import com.project.shop.model.Response;
import com.project.shop.model.binding.BuyBindingModel;
import com.project.shop.model.binding.ListingCreateModel;
import com.project.shop.model.binding.OrderBindingModel;
import com.project.shop.model.view.ListingInListViewModel;
import com.project.shop.model.view.OrderViewModel;
import com.project.shop.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.UUID;
@CrossOrigin
@RestController
@RequestMapping("api/orders")
public class OrderController {
private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("my-purchase")
    public ResponseEntity<Response> getMyPurchases(Authentication authentication) {
        Response response = new Response();
        if (authentication==null){
            return ResponseEntity.ok(response
                    .setOkRequestResponse("my-purchases", null, "You need login"));
        }
        UserEntity user= (UserEntity) authentication.getPrincipal();
        Collection<OrderViewModel> myPurchase = orderService.getPurchases(user.getUsername(),0, 30);
        return ResponseEntity.ok(response
                .setOkRequestResponse("my-purchases", myPurchase, "My Purchases retrieved"));
    }
    @GetMapping("my-order")
    public ResponseEntity<Response> getMyOrders(Authentication authentication) {
        Response response = new Response();
        if (authentication==null){
            return ResponseEntity.ok(response
                    .setOkRequestResponse("listings", null, "You need login"));
        }
        UserEntity user= (UserEntity) authentication.getPrincipal();
        Collection<OrderViewModel> watchListing = orderService.getMyOrders(user.getUsername(),0, 30);
        return ResponseEntity.ok(response
                .setOkRequestResponse("listings", watchListing, "My Orders retrieved"));
    }
    @GetMapping("order/{id}")
    public ResponseEntity<Response> getOrderById(@PathVariable UUID id
            , Authentication authentication) {
        Response response = new Response();
        if (authentication==null){
            return ResponseEntity.ok(response
                    .setOkRequestResponse("order", null, "You must login"));
        }
        UserEntity user= (UserEntity) authentication.getPrincipal();
        OrderViewModel orderModel = orderService.getOrderBuyId(id).orElseThrow(()->new NullPointerException(
                "Order with id:"+id+"does not exist"));
        return ResponseEntity.ok(response
                .setOkRequestResponse("order", orderModel, "Order with id: "+id+"retrieved"));
    }
    @PostMapping("confirm/")
    public ResponseEntity<Response> confirm(@RequestBody OrderBindingModel orderBindingModel,
            Authentication authentication) {
        Response response = new Response();
        if (authentication==null){
            return ResponseEntity.ok(response
                    .setOkRequestResponse("cofirm", null, "You need login"));
        }
        UserEntity user= (UserEntity) authentication.getPrincipal();
        try{
        var confirmOrder = orderService.confirmOrder(orderBindingModel,user.getUsername());
        return ResponseEntity.ok(response
                .setOkRequestResponse("confirm", confirmOrder, "Order confirmation retrieved"));
        }catch (Exception ex){

            return ResponseEntity.ok(response
                    .setBadRequestResponse("order", orderBindingModel, ex, "Order has errors"));
        }
    }
    @PostMapping("buy")
    public ResponseEntity<Response> buyListing(  @RequestBody BuyBindingModel buyBindingModel
            , Authentication authentication
    ) {
        Response response = new Response();
        try {
            if (authentication == null) {
                throw new IllegalStateException("Please Sign-in before continue");
            }
            if (buyBindingModel.getId() == null) {
                return ResponseEntity.notFound().build();
            }

            UserEntity principal = (UserEntity) authentication.getPrincipal();
            UUID order = orderService.placeOrder(buyBindingModel,principal.getUsername()).getId();
            return ResponseEntity.ok(response
                    .setOkRequestResponse("order", order, "Listing buy it now"));
        } catch (Exception e) {

            return ResponseEntity.ok(response
                    .setBadRequestResponse("buy", buyBindingModel, e, "Buy it now has errors"));
        }
    }
}
