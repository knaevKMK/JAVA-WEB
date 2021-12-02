package com.project.shop.web;

import com.project.shop.identityArea.models.entity.UserEntity;
import com.project.shop.model.Response;
import com.project.shop.model.binding.BuyBindingModel;
import com.project.shop.model.binding.OrderBindingModel;
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

    @GetMapping("purchases")
    public ResponseEntity<Response> getMyPurchases(
            @RequestParam(required = false, defaultValue = "0") int page,
            @RequestParam(required = false, defaultValue = "30") int limit,
            @RequestParam (required = false) String query,
            Authentication authentication) {
        Response response = new Response();
        if (authentication==null){
            return ResponseEntity.ok(response
                    .setOkRequestResponse("purchases", null, "You need login"));
        }
        UserEntity user= (UserEntity) authentication.getPrincipal();
        Collection<OrderViewModel> myPurchase = orderService.getPurchases(query,user.getUsername(),0, 30);
        return ResponseEntity.ok(response
                .setOkRequestResponse("purchases", myPurchase, "My Purchases retrieved"));
    }
    @GetMapping("solds")
    public ResponseEntity<Response> getMyOrders(
            @RequestParam(required = false, defaultValue = "0") int page,
            @RequestParam(required = false, defaultValue = "30") int limit,
            Authentication authentication) {
        Response response = new Response();
        if (authentication==null){
            return ResponseEntity.ok(response
                    .setOkRequestResponse("orders", null, "You need login"));
        }
        UserEntity user= (UserEntity) authentication.getPrincipal();
        Collection<OrderViewModel> watchListing = orderService.getSolds(user.getUsername(),0, 30);
        return ResponseEntity.ok(response
                .setOkRequestResponse("orders", watchListing, "My Orders retrieved"));
    }

    @GetMapping("order/{id}")
    public ResponseEntity<Response> getOrderById(@PathVariable UUID id
            , Authentication authentication) {
        Response response = new Response();
        if (authentication==null){
            return ResponseEntity.ok(response
                    .setOkRequestResponse("order", null, "You must login"));
        }
        OrderViewModel orderModel = orderService.getOrderBuyId(id).orElseThrow(()->new NullPointerException(
                "Order with id:"+id+"does not exist"));
        return ResponseEntity.ok(response
                .setOkRequestResponse("order", orderModel, "Order with id: "+id+"retrieved"));
    }
    @PutMapping("confirm")
    public ResponseEntity<Response> confirm(@RequestBody OrderBindingModel orderBindingModel,
            Authentication authentication) {
        Response response = new Response();
        if (authentication==null){
            return ResponseEntity.ok(response
                    .setOkRequestResponse("confirm", null, "You need login"));
        }
        UserEntity user= (UserEntity) authentication.getPrincipal();
        try{
                    var confirmOrder = orderService.confirmOrder(orderBindingModel,user.getUsername());
        return ResponseEntity.ok(response
                .setOkRequestResponse("confirm", confirmOrder, "Order confirmation retrieved"));
        }catch (Exception ex){

            return ResponseEntity.ok(response
                    .setBadRequestResponse("order", orderBindingModel, ex, ex.getMessage()));
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
                    .setBadRequestResponse("buy", buyBindingModel, e, e.getMessage()));
        }
    }
    @DeleteMapping("cancel/{id}")
    public ResponseEntity<Response> cancelOrder(  @PathVariable UUID id
            , Authentication authentication
    ) {
        Response response = new Response();
        try {
            if (authentication == null) {
                throw new IllegalStateException("Please Sign-in before continue");
            }
            if (id == null) {
                return ResponseEntity.notFound().build();
            }

            UserEntity principal = (UserEntity) authentication.getPrincipal();
            boolean deleted = orderService.cancel(id,principal.getUsername());
            return ResponseEntity.ok(response
                    .setOkRequestResponse("delete", deleted, "Order was canceled"));
        } catch (Exception e) {

            return ResponseEntity.ok(response
                    .setBadRequestResponse("buy", id, e, e.getMessage()));
        }
    }
}
