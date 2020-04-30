package com.lev.example.repository;

import com.lev.example.entity.Reader;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReaderRepository extends JpaRepository <Reader, Integer> {
}
