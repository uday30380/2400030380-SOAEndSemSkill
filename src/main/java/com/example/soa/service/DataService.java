package com.example.soa.service;

import com.example.soa.model.DataRecord;
import com.example.soa.repository.DataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Service layer implementing business logic for data operations.
 *
 * Student ID: 2400030380
 */
@Service
@Transactional
public class DataService {

    private final DataRepository dataRepository;

    @Autowired
    public DataService(DataRepository dataRepository) {
        this.dataRepository = dataRepository;
    }

    /**
     * Retrieve all data records from PostgreSQL.
     *
     * @return List of DataRecord entities
     */
    @Transactional(readOnly = true)
    public List<DataRecord> getAllRecords() {
        return dataRepository.findAll();
    }

    /**
     * Insert a new data record into PostgreSQL.
     *
     * @param record DataRecord to be persisted
     * @return Persisted DataRecord with generated ID
     */
    public DataRecord saveRecord(DataRecord record) {
        if (record == null) {
            throw new IllegalArgumentException("Record cannot be null");
        }
        return dataRepository.save(record);
    }

    /**
     * Retrieve a single record by its ID.
     *
     * @param id Record ID
     * @return DataRecord or null if not found
     */
    @Transactional(readOnly = true)
    public DataRecord getRecordById(Long id) {
        return dataRepository.findById(id).orElse(null);
    }
}
