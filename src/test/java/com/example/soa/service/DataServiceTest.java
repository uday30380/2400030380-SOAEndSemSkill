package com.example.soa.service;

import com.example.soa.model.DataRecord;
import com.example.soa.repository.DataRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class DataServiceTest {

    @Mock
    private DataRepository dataRepository;

    @InjectMocks
    private DataService dataService;

    private DataRecord testRecord;

    @BeforeEach
    void setUp() {
        testRecord = new DataRecord(1L, "SOA Docker Compose Lab");
    }

    @Test
    void testGetAllRecords() {
        when(dataRepository.findAll()).thenReturn(Arrays.asList(testRecord));

        List<DataRecord> records = dataService.getAllRecords();

        assertNotNull(records);
        assertEquals(1, records.size());
        assertEquals("SOA Docker Compose Lab", records.get(0).getMessage());
        verify(dataRepository, times(1)).findAll();
    }

    @Test
    void testSaveRecord() {
        when(dataRepository.save(any(DataRecord.class))).thenReturn(testRecord);

        DataRecord saved = dataService.saveRecord(new DataRecord("SOA Docker Compose Lab"));

        assertNotNull(saved);
        assertEquals(1L, saved.getId());
        assertEquals("SOA Docker Compose Lab", saved.getMessage());
        verify(dataRepository, times(1)).save(any(DataRecord.class));
    }
}
