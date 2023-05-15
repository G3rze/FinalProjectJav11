package com.restojavadev11.repositories;

import com.restojavadev11.entity.MenuEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface MenuRepository extends JpaRepository<MenuEntity, Long> {

    MenuEntity findById(long id);

}
