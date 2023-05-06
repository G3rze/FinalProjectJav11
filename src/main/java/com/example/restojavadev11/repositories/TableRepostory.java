package com.example.restojavadev11.repositories;

import com.example.restojavadev11.models.TableEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TableRepostory extends JpaRepository<TableEntity, Long> {
}
