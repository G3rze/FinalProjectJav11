package com.restojavadev11.service.implementation;

import com.restojavadev11.entity.MenuEntity;
import com.restojavadev11.entity.OrderEntity;
import com.restojavadev11.entity.PromotionEntity;
import com.restojavadev11.exceptions.DataAccessException;
import com.restojavadev11.parameters.BillParameters;
import com.restojavadev11.repositories.MenuRepository;
import com.restojavadev11.repositories.OrderRepository;
import com.restojavadev11.repositories.PromotionRepository;
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
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private PromotionRepository promotionRepository;

    @Override
    public List<BillEntity> allBills() {
        return billRepository.findAll();
    }

    @Override
    public Optional<BillEntity> getBillById(Long id) {
        try {
            return billRepository.findById(id);
        } catch (Exception e){
            //Catch the corresponding exception with the DataAccesEx. class, if there's a problem with the id search
            throw new DataAccessException("Cannot find the bill id", e);
        }
    }

    @Override
    public BillEntity newBill(BillParameters billParameters) {
        BillEntity newBill = new BillEntity();
        long idOrder = billParameters.getIdOrder();
        OrderEntity order = orderRepository.findById(idOrder);

        if (billParameters.getIdPromotion() != null) {
            long idPromotion = billParameters.getIdPromotion();
            PromotionEntity promotion = promotionRepository.findById(idPromotion);
            newBill.setPromotionEntity(promotion);
        }
        newBill.setOrderEntity(order);
        newBill.setBTime(billParameters.getTime());
        newBill.setBDate(billParameters.getDate());
        newBill.setBTotal(billParameters.getTotal());




        return newBill;
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
