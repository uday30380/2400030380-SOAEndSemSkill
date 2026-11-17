package com.example.soa.controller;

import com.example.soa.model.DataRecord;
import com.example.soa.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

// REST Controller providing endpoints for data records
// Student ID: 2400030380
@RestController
@RequestMapping("/api/data")
@CrossOrigin(origins = "*")
public class DataController {

    @Autowired
    private DataService dataService;

    // GET /api/data - Retrieve all records from PostgreSQL
    @GetMapping
    public ResponseEntity<List<DataRecord>> getAllData() {
        List<DataRecord> records = dataService.getAllRecords();
        return new ResponseEntity<>(records, HttpStatus.OK);
    }

    // POST /api/data - Insert a new record into PostgreSQL
    @PostMapping
    public ResponseEntity<DataRecord> createData(@RequestBody DataRecord record) {
        DataRecord saved = dataService.saveRecord(record);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }
}
