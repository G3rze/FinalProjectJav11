package com.restojavadev11.service.implementation;

import com.restojavadev11.entity.ReservationEntity;
import com.restojavadev11.entity.ReservationTableEntity;
import com.restojavadev11.entity.TableEntity;
import com.restojavadev11.parameters.ReservationParameters;
import com.restojavadev11.parameters.ReservationTableParameters;
import com.restojavadev11.repositories.ReservationRepository;
import com.restojavadev11.repositories.ReservationTableRepository;
import com.restojavadev11.repositories.TableRepostory;
import com.restojavadev11.service.IReservationService;
import com.restojavadev11.service.IReservationTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationTableService implements IReservationTableService {
    @Autowired
    private ReservationTableRepository reservationTableRepository;
    @Autowired
    private ReservationRepository reservationRepository;
    @Autowired
    private TableRepostory tableRepostory;


    @Override
    public List<ReservationTableEntity> allReservationTables() {
        return reservationTableRepository.findAll();
    }

    @Override
    public Optional<ReservationTableEntity> getReservationTableById(long id) {
        return reservationTableRepository.findById(id);
    }

    @Override
    public ReservationTableEntity newReservationTable(ReservationTableParameters reservationTableParameters) {
        ReservationTableEntity newReservationTable = new ReservationTableEntity();
        ReservationEntity reservation = reservationRepository.findById(reservationTableParameters.getIdReservation());
        TableEntity table = tableRepostory.findById(reservationTableParameters.getIdTable());

        newReservationTable.setReservation(reservation);
        newReservationTable.setTable(table);
        newReservationTable.setRtStartTime(reservationTableParameters.getStartTime());

        return newReservationTable;
    }

    @Override
    public void updateReservationTable(ReservationTableEntity newReservationTable) {
        reservationTableRepository.save(newReservationTable);
    }

    @Override
    public void deleteReservationTableById(long id) {
        reservationTableRepository.deleteById(id);
    }
}
