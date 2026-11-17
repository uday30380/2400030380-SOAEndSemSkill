package com.example.soa.repository;

import com.example.soa.model.DataRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// Repository interface for database CRUD operations
// Student ID: 2400030380
@Repository
public interface DataRepository extends JpaRepository<DataRecord, Long> {
}
