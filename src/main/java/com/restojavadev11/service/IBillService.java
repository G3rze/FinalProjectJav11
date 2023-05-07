package com.restojavadev11.service;

import com.restojavadev11.models.BillEntity;

import java.sql.Time;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface IBillService {

    List<BillEntity> allBills();

    Optional<BillEntity> getReserveById(Long id);

    BillEntity newBill(Date date, Time time, Double total, long promotion);

    void deleteBill(long id);


    void updateBill(BillEntity newBill);

}
