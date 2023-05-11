package com.restojavadev11.controller;

import com.restojavadev11.entity.TableEntity;
import com.restojavadev11.service.ITableService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tables")
public class TableController {

    private final ITableService tableService;

    public TableController(ITableService tableService) {
        this.tableService = tableService;
    }

    @GetMapping("")
    public List<TableEntity> listTables(){
        return tableService.allTables();
    }

    @PostMapping
    public void insertTable(@RequestBody TableEntity table){
        try {
            tableService.inserTable(table);
            HttpHeaders responseHeader = new HttpHeaders();
            responseHeader.set("location", "/api/tables" + "/" + table.getIdNTable());
            new ResponseEntity(responseHeader, HttpStatus.CREATED);
        }catch (Exception e){
            new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
