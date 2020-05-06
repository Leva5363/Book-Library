package com.lev.example.repository;

import com.lev.example.entity.Library;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface LibraryRepository extends JpaRepository <Library, Integer> {

    @Query(value = "insert into LIBRARY(AMOUNT_BOOK) values(amount)", nativeQuery = true)
    void addBookToLibrary(int amount);
}
