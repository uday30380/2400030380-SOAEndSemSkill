package com.example.soa.service;

import com.example.soa.model.DataRecord;
import com.example.soa.repository.DataRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

// Unit test for DataService logic
// Student ID: 2400030380
@ExtendWith(MockitoExtension.class)
public class DataServiceTest {

    @Mock
    private DataRepository dataRepository;

    @InjectMocks
    private DataService dataService;

    @Test
    public void testGetAllRecords() {
        DataRecord record = new DataRecord(1L, "SOA Docker Compose Lab");
        when(dataRepository.findAll()).thenReturn(Arrays.asList(record));

        List<DataRecord> records = dataService.getAllRecords();

        assertNotNull(records);
        assertEquals(1, records.size());
        assertEquals("SOA Docker Compose Lab", records.get(0).getMessage());
        verify(dataRepository, times(1)).findAll();
    }

    @Test
    public void testSaveRecord() {
        DataRecord record = new DataRecord("SOA Docker Test");
        DataRecord savedRecord = new DataRecord(1L, "SOA Docker Test");
        when(dataRepository.save(record)).thenReturn(savedRecord);

        DataRecord result = dataService.saveRecord(record);

        assertNotNull(result);
        assertEquals(1L, result.getId());
        assertEquals("SOA Docker Test", result.getMessage());
        verify(dataRepository, times(1)).save(record);
    }
}
