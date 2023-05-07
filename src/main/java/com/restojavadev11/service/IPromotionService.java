package com.restojavadev11.service;

import com.restojavadev11.entity.PromotionEntity;
import com.restojavadev11.parameters.PromotionParameters;

import java.util.List;
import java.util.Optional;

public interface IPromotionService {

    List<PromotionEntity> allPromotions();

    Optional<PromotionEntity> getPromotionById(long id);

    PromotionEntity newPromotion(PromotionParameters promotionParameters);

    void deletePromotion(long id);

    void updatePromotion(PromotionEntity newPromotion);

}
