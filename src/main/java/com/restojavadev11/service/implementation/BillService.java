package com.restojavadev11.service.implementation;

import com.restojavadev11.parameters.BillParameters;
import com.restojavadev11.service.IBillService;
import com.restojavadev11.entity.BillEntity;
import com.restojavadev11.repositories.BillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public BillEntity newBill(BillParameters billParameters) {

        return newBill(billParameters);
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
