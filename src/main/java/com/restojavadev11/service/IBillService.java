package com.restojavadev11.service;

import com.restojavadev11.entity.BillEntity;
import com.restojavadev11.parameters.BillParameters;

import java.util.List;
import java.util.Optional;

public interface IBillService {

    List<BillEntity> allBills();

    Optional<BillEntity> getBillById(Long id);

    BillEntity newBill(BillParameters billParameters);

    void deleteBill(long id);


    void updateBill(BillEntity newBill);

}
