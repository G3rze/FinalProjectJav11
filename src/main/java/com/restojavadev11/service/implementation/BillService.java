package com.restojavadev11.service.implementation;

import com.restojavadev11.service.IBillService;
import com.restojavadev11.models.BillEntity;
import com.restojavadev11.repositories.BillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class BillService  implements IBillService {

    @Autowired
    private BillRepository billRepository;

    @Override
    public List<BillEntity> allBills() {
        return billRepository.findAll();
    }

    @Override
    public Optional<BillEntity> getReserveById(Long id) {
        try {
            return billRepository.findById(id);
        } catch (Exception e){
            return Optional.empty();
        }
    }

    @Override
    public BillEntity newBill(Date date, Time time, Double total, long promotion) {

        return newBill(date, time,total,promotion);
    }

    @Override
    public void deleteBill(long id) {
        billRepository.deleteById(id);
    }

    @Override
    public void updateBill(BillEntity newBill) {
        billRepository.save(newBill);
    }
}
