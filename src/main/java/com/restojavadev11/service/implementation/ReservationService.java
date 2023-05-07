package com.restojavadev11.service.implementation;

import com.restojavadev11.service.IReservationService;
import com.restojavadev11.models.ReservationEntity;
import com.restojavadev11.repositories.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ReservationService implements IReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    @Override
    public List<ReservationEntity> allReservations() {
        return reservationRepository.findAll();
    }

    @Override
    public Optional<ReservationEntity> getReservationById(long id) {
        try {
            return reservationRepository.findById(id);
        } catch (Exception e){
            return Optional.empty();
        }
    }

    @Override
    public ReservationEntity newReservation(Date date, Time startTime, Time endTime, int nPeople, int nTable, long idCustomer, long idBill, long idEmployee) {
        return newReservation(date, startTime, endTime, nPeople, nTable, idCustomer, idBill, idEmployee);
    }

    @Override
    public void deleteReservation(long id) {
        reservationRepository.deleteById(id);
    }

    @Override
    public void updateReservation(ReservationEntity newReservation) {
        reservationRepository.save(newReservation);
    }
}
