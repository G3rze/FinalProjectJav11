package com.restojavadev11.controller;

import com.restojavadev11.entity.PromotionEntity;
import com.restojavadev11.exceptions.DataAccessException;
import com.restojavadev11.parameters.PromotionParameters;
import com.restojavadev11.service.IPromotionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/promotion")
public class PromotionController {

    @Autowired
    private IPromotionService promotionService;

    @GetMapping("/getAll")
    @PreAuthorize("hasAnyRole('WORKER', 'ADMIN', 'CUSTOMER') or hasAnyAuthority('SCOPE_ROLE_WORKER', 'SCOPE_ROLE_ADMIN', 'SCOPE_ROLE,CUSTOMER')")
    public List<PromotionEntity> getAllPromotion(){
       return promotionService.allPromotions();
    }

    @GetMapping("getById{id}")
    @PreAuthorize("hasAnyRole('WORKER', 'ADMIN', 'CUSTOMER') or hasAnyAuthority('SCOPE_ROLE_WORKER', 'SCOPE_ROLE_ADMIN', 'SCOPE_ROLE,CUSTOMER')")
    public Optional<PromotionEntity> getPromotionById(@RequestParam("id") long id){
        return promotionService.getPromotionById(id);
    }

    @PostMapping("/create")
    @PreAuthorize("hasAnyRole('WORKER', 'ADMIN') or hasAnyAuthority('SCOPE_ROLE_WORKER','SCOPE_ROLE_ADMIN')")
    public void insertPromotion(@RequestBody PromotionParameters promotionParameters){
        PromotionEntity newPromotionEntity = promotionService.newPromotion(promotionParameters);
        promotionService.updatePromotion(newPromotionEntity);
    }
    @GetMapping("/getPromotionByName{name}")
    @PreAuthorize("hasAnyRole('WORKER', 'ADMIN', 'CUSTOMER') or hasAnyAuthority('SCOPE_ROLE_WORKER', 'SCOPE_ROLE_ADMIN', 'SCOPE_ROLE,CUSTOMER')")
    public List<PromotionEntity> getAllPromotionByPName(@RequestParam("name") String name){
        return
        promotionService.allPromotionsByName(name);
    }
}
