package com.example.soa.controller;

import com.example.soa.model.DataRecord;
import com.example.soa.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * REST Controller exposing endpoints under /api/data.
 *
 * Student ID: 2400030380
 */
@RestController
@RequestMapping("/api/data")
public class DataController {

    private final DataService dataService;

    @Autowired
    public DataController(DataService dataService) {
        this.dataService = dataService;
    }

    /**
     * GET /api/data
     * Retrieve all records from PostgreSQL database.
     *
     * @return List of DataRecord JSON objects with HTTP 200 OK
     */
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<DataRecord>> getAllData() {
        List<DataRecord> records = dataService.getAllRecords();
        return ResponseEntity.ok(records);
    }

    /**
     * POST /api/data
     * Insert a new record into PostgreSQL database.
     *
     * @param record JSON payload containing message
     * @return Created DataRecord with HTTP 201 Created
     */
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DataRecord> createData(@RequestBody DataRecord record) {
        DataRecord savedRecord = dataService.saveRecord(record);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedRecord);
    }
}
