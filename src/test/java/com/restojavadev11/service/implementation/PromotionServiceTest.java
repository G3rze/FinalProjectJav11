package com.restojavadev11.service.implementation;

import com.restojavadev11.entity.CustomerEntity;
import com.restojavadev11.entity.MenuEntity;
import com.restojavadev11.entity.PromotionEntity;
import com.restojavadev11.repositories.PromotionRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.sql.Date;
import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class PromotionServiceTest {

    @Mock
    private PromotionRepository promotionRepository;
    @InjectMocks
    private PromotionService promotionService;
    private PromotionEntity promotionEntity;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        promotionEntity = new PromotionEntity();
        promotionEntity.setIdPromotion(Long.valueOf(1));
        promotionEntity.setPName("Test");
        promotionEntity.setPDescription("This is the description");
        promotionEntity.setPDiscount(0.4);
        promotionEntity.setPStartDate(Date.valueOf("2023-06-28"));
        promotionEntity.setPFinishDate(Date.valueOf("2023-09-02"));
    }

    @Test
    void allPromotions() {
        when(promotionRepository.findAll()).thenReturn(Arrays.asList(promotionEntity));
        assertNotNull(promotionService.allPromotions());
    }

    @Test
    void getPromotionById() {

        //En comprobacion
        Long promotionId = Long.valueOf(1);

        when(promotionRepository.findById(promotionId)).thenReturn(Optional.of(promotionEntity));

        Optional<PromotionEntity> actualPromotionEntity = promotionService.getPromotionById(promotionId);

        assertEquals(promotionEntity, actualPromotionEntity.get());
    }
}