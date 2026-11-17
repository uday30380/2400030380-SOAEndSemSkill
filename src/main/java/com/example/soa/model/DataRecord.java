package com.example.soa.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * JPA Entity representing a record in the PostgreSQL database.
 * Mapped to table 'data_record'.
 *
 * Student ID: 2400030380
 */
@Entity
@Table(name = "data_record")
public class DataRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "message", nullable = false)
    private String message;

    // Default No-Args Constructor required by JPA
    public DataRecord() {
    }

    // Convenience constructor
    public DataRecord(String message) {
        this.message = message;
    }

    // All-Args Constructor
    public DataRecord(Long id, String message) {
        this.id = id;
        this.message = message;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "DataRecord{" +
                "id=" + id +
                ", message='" + message + '\'' +
                '}';
    }
}
