package com.lev.example.repository;

import com.lev.example.entity.Books;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Book;
import java.util.List;


@Repository
public interface BooksRepository extends JpaRepository <Books, Integer> {

    List<Books> findByIdAuthor(int IdAuthor);

    Books findById(int id);

//    List<Books> findAllBooks();

//    void saveBook(int id, int idAuthor, String name);


    List<Books> findAll();


    Books save(Book book);


}