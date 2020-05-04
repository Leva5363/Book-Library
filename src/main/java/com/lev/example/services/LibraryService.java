package com.lev.example.services;

import com.lev.example.entity.Books;

import java.awt.print.Book;
import java.util.List;

public interface LibraryService {
    List<Books> getBooksByAuthor(int IdAuthor);

    List<Books> getAllBooks();

    Books getBooksById(int id);

    void saveBook(Books book);


}
