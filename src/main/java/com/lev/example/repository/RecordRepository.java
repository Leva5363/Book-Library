package com.lev.example.repository;

import com.lev.example.entity.Record;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecordRepository extends JpaRepository <Record, Integer> {
}
