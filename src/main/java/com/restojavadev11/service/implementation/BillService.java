package com.restojavadev11.service.implementation;

import com.restojavadev11.entity.*;
import com.restojavadev11.exceptions.DataAccessException;
import com.restojavadev11.parameters.BillParameters;
import com.restojavadev11.repositories.*;
import com.restojavadev11.service.IBillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BillService  implements IBillService {

    @Autowired
    private BillRepository billRepository;
    @Autowired
    private ReservationRepository reservationRepository;
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
        long idReservation = billParameters.getIdReservation();
        ReservationEntity reservation = reservationRepository.findById(idReservation);

        if (billParameters.getIdPromotion() != null) {
            long idPromotion = billParameters.getIdPromotion();
            PromotionEntity promotion = promotionRepository.findById(idPromotion);
            newBill.setPromotionEntity(promotion);
        }
        newBill.setReservation(reservation);
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
