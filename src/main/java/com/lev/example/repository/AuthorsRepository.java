package com.lev.example.repository;

import com.lev.example.entity.Authors;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorsRepository extends JpaRepository <Authors, Integer> {
}
