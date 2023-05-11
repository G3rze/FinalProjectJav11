package com.restojavadev11.service.implementation;

import com.restojavadev11.exceptions.DataAccessException;
import com.restojavadev11.parameters.PromotionParameters;
import com.restojavadev11.service.IPromotionService;
import com.restojavadev11.entity.PromotionEntity;
import com.restojavadev11.repositories.PromotionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
            //Catch the corresponding exception with the DataAccesEx. class, if there's a problem with the id search
            throw new DataAccessException("Cannot find the promotion id", e);
        }
    }

    @Override
    public PromotionEntity newPromotion(PromotionParameters promotionParameters) {
        PromotionEntity newPromotionEntity = new PromotionEntity();

        newPromotionEntity.setPName(promotionParameters.getName());
        newPromotionEntity.setPDescription(promotionParameters.getDescription());
        newPromotionEntity.setPDiscount(promotionParameters.getDiscount());
        newPromotionEntity.setPStartDate(promotionParameters.getStartDate());
        newPromotionEntity.setPFinishDate(promotionParameters.getFinishDate());

        return newPromotionEntity;
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
