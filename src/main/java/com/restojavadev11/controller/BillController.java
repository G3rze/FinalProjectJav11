package com.restojavadev11.controller;

import com.restojavadev11.entity.BillEntity;
import com.restojavadev11.parameters.BillParameters;
import com.restojavadev11.service.IBillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/bill")
public class BillController {

    @Autowired
    private IBillService billService;

    @GetMapping("/getAll")
    public List<BillEntity> getAllBills(){
        return billService.allBills();
    }

    @GetMapping("/getById{id}")
    public Optional<BillEntity> getBillById(@RequestParam("id") long id){
        return billService.getBillById(id);
    }

    @PostMapping("/create")
    public void insertNewBill(@RequestBody BillParameters billParameters){
        BillEntity newBill = billService.newBill(billParameters);
        billService.updateBill(newBill);
    }

    @DeleteMapping("/deleteById")
    public void deleteBill(@RequestParam("id") long id){
        billService.deleteBill(id);
    }
}
