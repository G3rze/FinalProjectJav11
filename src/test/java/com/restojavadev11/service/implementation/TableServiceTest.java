package com.restojavadev11.service.implementation;

import com.restojavadev11.entity.ReservationEntity;
import com.restojavadev11.entity.TableEntity;
import com.restojavadev11.repositories.TableRepostory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class TableServiceTest {

    @Mock
    private TableRepostory tableRepostory;
    @InjectMocks
    private TableService tableService;
    private TableEntity tableEntity;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        tableEntity = new TableEntity();
        tableEntity.setIdNTable(Long.valueOf(1));
        tableEntity.setTCapacity(4);
    }

    @Test
    void allTables() {
        when(tableRepostory.findAll()).thenReturn(Arrays.asList(tableEntity));
        assertNotNull(tableService.allTables());
    }

    @Test
    void getTableById() {

        /*Long tableId = Long.valueOf(1);

        when(tableRepostory.findById(tableId)).thenReturn(Optional.of(tableEntity));

        Optional<TableEntity> actualTableEntity = tableService.getTableById(tableId);

        assertEquals(tableEntity, actualTableEntity.get());*/
    }
}