package com.restojavadev11.controller;

import com.restojavadev11.entity.PromotionEntity;
import com.restojavadev11.entity.TableEntity;
import com.restojavadev11.parameters.TableParameters;
import com.restojavadev11.service.ITableService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tables")
public class TableController {

    private final ITableService tableService;

    public TableController(ITableService tableService) {
        this.tableService = tableService;
    }

    @GetMapping("/getAll")
    @PreAuthorize("hasAnyRole('WORKER', 'ADMIN', 'CUSTOMER') or hasAnyAuthority('SCOPE_ROLE_WORKER', 'SCOPE_ROLE_ADMIN', 'SCOPE_ROLE,CUSTOMER')")
    public List<TableEntity> listTables(){
        return tableService.allTables();
    }

    @GetMapping("/getById{id}")
    @PreAuthorize("hasAnyRole('WORKER', 'ADMIN', 'CUSTOMER') or hasAnyAuthority('SCOPE_ROLE_WORKER', 'SCOPE_ROLE_ADMIN', 'SCOPE_ROLE,CUSTOMER')")
    public Optional<TableEntity> getTableById(@RequestParam("id") long id){
        return tableService.getTableById(id);
    }

    @PostMapping("/insertTables")
    @PreAuthorize("hasAnyRole('ADMIN') or hasAnyAuthority('SCOPE_ROLE_ADMIN')")
    public void insertTable(@RequestBody TableParameters tableParameters){
        System.out.println(tableParameters.getCapacity());
        try {
            TableEntity newTable = tableService.createTable(tableParameters);
            tableService.updateTable(newTable);

            HttpHeaders responseHeader = new HttpHeaders();
            responseHeader.set("location", "/tables/getById" + "?id=" + newTable.getIdNTable());
            new ResponseEntity(responseHeader, HttpStatus.CREATED);
        }catch (Exception e){
            new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
