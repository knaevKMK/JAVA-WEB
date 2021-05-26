package com.shop.SuperMarket.web;


import com.shop.SuperMarket.service.interfaces.ShopService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/shop")
@AllArgsConstructor
public class ShopController {

    private final ShopService shopService;
}
