package com.restojavadev11.service;

import com.restojavadev11.entity.TableEntity;
import com.restojavadev11.parameters.TableParameters;

import java.util.List;
import java.util.Optional;

public interface ITableService {

    List<TableEntity> allTables();

    Optional<TableEntity> getTableById(long id);

    TableEntity createTable(TableParameters tableParameters);

    void updateTable(TableEntity newTable);

    void deleteTable(long id);

}
