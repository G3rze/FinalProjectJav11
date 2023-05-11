package com.restojavadev11.repositories;

import com.restojavadev11.entity.TableEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface TableRepostory extends JpaRepository<TableEntity, Long> {
}
