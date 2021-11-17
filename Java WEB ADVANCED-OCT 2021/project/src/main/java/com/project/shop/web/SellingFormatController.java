package com.project.shop.web;

import com.project.shop.model.Response;
import com.project.shop.model.enums.SellingFormatEnum;
import com.project.shop.model.view.ConditionViewModel;
import com.project.shop.model.view.SellingVewModel;
import com.project.shop.service.SellingFormatService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping("api/selling-format")
public class SellingFormatController {
    private final SellingFormatService sellingFormatService;

    public SellingFormatController(SellingFormatService sellingFormatService) {
        this.sellingFormatService = sellingFormatService;
    }
    @GetMapping("all")
    public ResponseEntity<Response> getAll(){
        Collection<String> all = Arrays.stream(SellingFormatEnum.values())
                .map(Enum::name)
                .collect(Collectors.toList());
        return ResponseEntity.ok(Response
                .builder()
                .timeStamp(LocalDateTime.now())
                .data(Map.of("selling-formats",all))
                .message("Selling Format list")
                .status(HttpStatus.OK)
                .statusCode(HttpStatus.OK.value())
                .build()
        );
    }

}
