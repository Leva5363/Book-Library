package com.lev.example.repository;

import com.lev.example.entity.Library;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LibraryRepository extends JpaRepository <Library, Integer> {

    Optional <Library> findByIdBook(Integer IdBook);
}
