package com.project.shop.web;

import com.project.shop.model.Response;
import com.project.shop.model.view.ConditionViewModel;
import com.project.shop.service.ConditionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Map;
@CrossOrigin
@RestController
@RequestMapping("api/condition")
public class ConditionController {
    private final ConditionService conditionService;

    public ConditionController(ConditionService conditionService) {
        this.conditionService = conditionService;
    }

    @GetMapping("all")
    public ResponseEntity<Response> getAll(){
        Collection<ConditionViewModel> all = conditionService.getAll();
        return ResponseEntity.ok(Response
                        .builder()
                        .timeStamp(LocalDateTime.now())
                        .data(Map.of("conditions",all))
                        .message("Category list")
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .build()
        );
    }
}
