package com.restojavadev11.service.implementation;

import com.restojavadev11.service.ITableService;
import com.restojavadev11.models.TableEntity;
import com.restojavadev11.repositories.TableRepostory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TableService implements ITableService {

    @Autowired
    private TableRepostory tableRepostory;

    @Override
    public List<TableEntity> allTables() {
        return tableRepostory.findAll();
    }

    @Override
    public Optional<TableEntity> getTableById(long id) {
        try {
            return tableRepostory.findById(id);
        } catch (Exception e){
            return Optional.empty();
        }
    }
}
