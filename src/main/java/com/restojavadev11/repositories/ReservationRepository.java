package com.restojavadev11.repositories;

import com.restojavadev11.entity.ReservationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<ReservationEntity, Long> {

    ReservationEntity findById(long id);

}
