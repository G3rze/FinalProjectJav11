package com.restojavadev11.service.implementation;

import com.restojavadev11.parameters.ReservationParameters;
import com.restojavadev11.service.IReservationService;
import com.restojavadev11.entity.ReservationEntity;
import com.restojavadev11.repositories.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public ReservationEntity newReservation(ReservationParameters reservationParameters) {
        return newReservation(reservationParameters);
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
