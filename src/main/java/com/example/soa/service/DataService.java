package com.example.soa.service;

import com.example.soa.model.DataRecord;
import com.example.soa.repository.DataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// Service layer handling data operations
// Student ID: 2400030380
@Service
public class DataService {

    @Autowired
    private DataRepository dataRepository;

    // Fetch all records from the database
    public List<DataRecord> getAllRecords() {
        return dataRepository.findAll();
    }

    // Save a new record in PostgreSQL
    public DataRecord saveRecord(DataRecord record) {
        return dataRepository.save(record);
    }
}
