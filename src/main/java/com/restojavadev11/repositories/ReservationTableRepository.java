package com.restojavadev11.repositories;

import com.restojavadev11.entity.ReservationTableEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationTableRepository extends JpaRepository<ReservationTableEntity, Long> {
}
