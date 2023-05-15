package com.restojavadev11.repositories;

import com.restojavadev11.entity.PromotionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface PromotionRepository extends JpaRepository<PromotionEntity, Long> {

    PromotionEntity findById(long id);

    List<PromotionEntity> findBypName(String name);
}
