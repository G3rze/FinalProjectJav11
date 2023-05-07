package com.restojavadev11.service;

import com.restojavadev11.models.PromotionEntity;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface IPromotionService {

    List<PromotionEntity> allPromotions();

    Optional<PromotionEntity> getPromotionById(long id);

    PromotionEntity newPromotion(String name, String description, double discount, Date startDate, Date finishDate);

    void deletePromotion(long id);

    void updatePromotion(PromotionEntity newPromotion);

}
