package com.restojavadev11.service.implementation;

import com.restojavadev11.exceptions.DataAccessException;
import com.restojavadev11.parameters.ReservationParameters;
import com.restojavadev11.service.IReservationService;
import com.restojavadev11.entity.ReservationEntity;
import com.restojavadev11.repositories.ReservationRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ReservationService implements IReservationService {


    private ReservationRepository reservationRepository;

    @Override
    public List<ReservationEntity> allReservations() {
        return reservationRepository.findAll();
    }

    @Override
    public Optional<ReservationEntity> getReservationById(long id) {
        try {
            return Optional.ofNullable(reservationRepository.findById(id));
        } catch (Exception e){
            //Catch the corresponding exception with the DataAccesEx. class, if there's a problem with the id search
            throw new DataAccessException("Cannot find the reservation id", e);
        }
    }

    @Override
    @Transactional
    public Optional<ReservationEntity> newReservation(ReservationParameters reservationParameters) {
        Long id = reservationRepository.createReservation(reservationParameters.getDate(),
                reservationParameters.getStartTime(), reservationParameters.getEndTime(),
                reservationParameters.getNPeople(),reservationParameters.getNTable(),
                reservationParameters.getStatus(), reservationParameters.getIdCustomer());
        return reservationRepository.findById(id);
    }


    @Override
    @Transactional
    public void updateReservation(ReservationParameters reservationParameters) {
        reservationRepository.updateReservation(reservationParameters.getId(), reservationParameters.getDate(),
                reservationParameters.getStartTime(), reservationParameters.getEndTime(),
                reservationParameters.getNPeople(),reservationParameters.getNTable(),
                reservationParameters.getIdCustomer(), reservationParameters.getIdEmployee(), reservationParameters.getStatus());
    }

    @Override
    @Transactional
    public void setInProcessReservation(ReservationParameters reservationParameters){
        reservationRepository.inProcessReservation(reservationParameters.getId());
    }
    @Override
    @Transactional
    public void cancelReservation(ReservationParameters reservationParameters){
        reservationRepository.cancelReservation(reservationParameters.getId());
    }
    @Override
    @Transactional
    public void closeReservation(ReservationParameters reservationParameters){
        reservationRepository.closeReservation(reservationParameters.getId());
    }
    @Override
    @Transactional
    public void claimReservation(ReservationParameters reservationParameters){
        reservationRepository.claimReservation(reservationParameters.getId(), reservationParameters.getIdEmployee());
    }


}
