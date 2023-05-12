package com.restojavadev11.repositories;

import com.restojavadev11.entity.BillEntity;
import com.restojavadev11.entity.MenuEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface BillRepository extends JpaRepository<BillEntity, Long> {
}
