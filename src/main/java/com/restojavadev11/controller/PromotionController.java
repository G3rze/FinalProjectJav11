package com.restojavadev11.controller;

import com.restojavadev11.entity.PromotionEntity;
import com.restojavadev11.exceptions.DataAccessException;
import com.restojavadev11.parameters.PromotionParameters;
import com.restojavadev11.service.IPromotionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/promotion")
public class PromotionController {

    @Autowired
    private IPromotionService promotionService;

    @GetMapping("/getAll")
    public List<PromotionEntity> getAllPromotion(){
       return promotionService.allPromotions();
    }

    @GetMapping("getById{id}")
    public Optional<PromotionEntity> getPromotionById(@RequestParam("id") long id){
        return promotionService.getPromotionById(id);
    }

    @PostMapping("/create")
    public void insertPromotion(@RequestBody PromotionParameters promotionParameters){
        PromotionEntity newPromotionEntity = promotionService.newPromotion(promotionParameters);
        promotionService.updatePromotion(newPromotionEntity);
    }

    @DeleteMapping("delete{id}")
    public void deletePromotionById(@RequestParam("id") long id){
        promotionService.deletePromotion(id);
    }

}
