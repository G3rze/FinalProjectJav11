package com.restojavadev11.service.implementation;

import com.restojavadev11.exceptions.DataAccessException;
import com.restojavadev11.service.ITableService;
import com.restojavadev11.entity.TableEntity;
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
            //Catch the corresponding exception with the DataAccesEx. class, if there's a problem with the id search
            throw new DataAccessException("Cannot find the table id", e);
        }
    }

    @Override
    public void inserTable(TableEntity table) {
        try {
            tableRepostory.save(table);
        }catch (Exception e){
            throw new DataAccessException("Cannot insert table to database", e);
        }
    }


}
