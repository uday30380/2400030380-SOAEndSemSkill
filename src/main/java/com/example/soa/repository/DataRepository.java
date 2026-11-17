package com.example.soa.repository;

import com.example.soa.model.DataRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Spring Data JPA Repository for DataRecord entity.
 * Provides standard CRUD database operations.
 *
 * Student ID: 2400030380
 */
@Repository
public interface DataRepository extends JpaRepository<DataRecord, Long> {
}
