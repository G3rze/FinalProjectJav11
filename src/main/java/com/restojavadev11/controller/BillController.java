package com.restojavadev11.controller;

import com.restojavadev11.entity.BillEntity;
import com.restojavadev11.parameters.BillParameters;
import com.restojavadev11.service.IBillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/bill")
public class BillController {

    @Autowired
    private IBillService billService;

    @PreAuthorize("hasRole('ADMIN') or hasAuthority('SCOPE_ROLE_ADMIN')")
    @GetMapping("/getAll")
    public List<BillEntity> getAllBills(){
        return billService.allBills();
    }

    @PreAuthorize("hasAnyRole('ADMIN','WORKER') or hasAnyAuthority('SCOPE_ROLE_CUSTOMER', 'SCOPE_ROLE_CUSTOMER')")
    @GetMapping("/getById{id}")
    public Optional<BillEntity> getBillById(@RequestParam("id") long id){
        return billService.getBillById(id);
    }

    @PreAuthorize("hasRole('ADMIN') or hasAuthority('SCOPE_ROLE_ADMIN')")
    @PostMapping("/create")
    public void insertNewBill(@RequestBody BillParameters billParameters){
        BillEntity newBill = billService.newBill(billParameters);
        billService.updateBill(newBill);
    }

}
