package com.restojavadev11.service;

import com.restojavadev11.entity.TableEntity;

import java.util.List;
import java.util.Optional;

public interface ITableService {

    List<TableEntity> allTables();

    Optional<TableEntity> getTableById(long id);

}
