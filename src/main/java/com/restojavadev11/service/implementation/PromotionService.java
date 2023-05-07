package com.restojavadev11.service.implementation;

import com.restojavadev11.service.IPromotionService;
import com.restojavadev11.models.PromotionEntity;
import com.restojavadev11.repositories.PromotionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PromotionService implements IPromotionService {

    @Autowired
    private PromotionRepository promotionRepository;

    @Override
    public List<PromotionEntity> allPromotions() {
        return promotionRepository.findAll();
    }

    @Override
    public Optional<PromotionEntity> getPromotionById(long id) {
        try {
            return promotionRepository.findById(id);
        } catch (Exception e){
            return Optional.empty();
        }
    }

    @Override
    public PromotionEntity newPromotion(String name, String description, double discount, Date startDate, Date finishDate) {
        return newPromotion(name, description, discount,startDate, finishDate);
    }

    @Override
    public void deletePromotion(long id) {
        promotionRepository.deleteById(id);
    }

    @Override
    public void updatePromotion(PromotionEntity newPromotion) {
        promotionRepository.save(newPromotion);
    }
}
