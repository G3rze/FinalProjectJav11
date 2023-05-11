package com.restojavadev11.controller;

import com.restojavadev11.entity.PromotionEntity;
import com.restojavadev11.parameters.PromotionParameters;
import com.restojavadev11.service.IPromotionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/promotion")
public class PromotionController {

    @Autowired
    private IPromotionService promotionService;

    @GetMapping("/hola")
    public String hola(){
        return "HOLA MUNDO";
    }

    @GetMapping("/getAll")
    public List<PromotionEntity> getAllPromotion(){
       return promotionService.allPromotions();
    }

    @PostMapping("/create")
    public void createPromotion(@RequestBody PromotionParameters promotionParameters){
        PromotionEntity newPromotionEntity = promotionService.newPromotion(promotionParameters);

        promotionService.updatePromotion(newPromotionEntity);
    }

}
