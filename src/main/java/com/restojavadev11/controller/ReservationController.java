package com.restojavadev11.controller;

import com.restojavadev11.entity.ReservationEntity;
import com.restojavadev11.parameters.ReservationParameters;
import com.restojavadev11.service.IReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservation")
public class ReservationController {

    @Autowired
    private IReservationService reservationService;

    @GetMapping("getAll")
    public List<ReservationEntity> getAllReservations(){
        return reservationService.allReservations();
    }

    @PostMapping("createReservation")
    public void createReservation(@RequestBody ReservationParameters reservationParameters){
        reservationService.newReservation(reservationParameters);
    }

    @PostMapping("updateReservation")
    public void updateReservation(@RequestBody ReservationParameters reservationParameters){
        reservationService.updateReservation(reservationParameters);
    }

    @PostMapping("cancelReservation")
    public void cancelReservation(@RequestBody ReservationParameters reservationParameters){
        reservationService.cancelReservation(reservationParameters);
    }

    @PostMapping("inProgressReservation")
    public void setInProgressReservation(@RequestBody ReservationParameters reservationParameters){
        reservationService.setInProcessReservation(reservationParameters);
    }
    @PostMapping("closeReservation")
    public void closeReservation(@RequestBody ReservationParameters reservationParameters){
        reservationService.closeReservation(reservationParameters);
    }

    @PostMapping("claimReservation")
    public void claimReservation(@RequestBody ReservationParameters reservationParameters){
        reservationService.claimReservation(reservationParameters);
    }
}
