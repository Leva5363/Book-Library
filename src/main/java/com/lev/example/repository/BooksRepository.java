package com.lev.example.repository;

import com.lev.example.entity.Books;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface BooksRepository extends JpaRepository <Books, Integer> {
//    @Transactional
    List<Books> findByIdAuthor(int IdAuthor);


}
