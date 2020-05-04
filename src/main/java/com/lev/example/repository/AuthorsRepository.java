package com.lev.example.repository;

import com.lev.example.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorsRepository extends JpaRepository <Author, Integer> {
}
