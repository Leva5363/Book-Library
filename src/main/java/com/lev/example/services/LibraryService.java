package com.lev.example.services;

import com.lev.example.entity.Book;
import com.lev.example.entity.Library;
import com.lev.example.entity.Record;

import java.util.List;
import java.util.Optional;

public interface LibraryService {
    List<Book> getBooksByAuthor(int idAuthor);

    List<Book> getAllBooks();

    Optional<Book> getBooksById(int id);

    void saveBook(Book book);

    void addBookToLibrary(Library library);

    void newRecord(Record record);

    void closeRecord(Record record);
}
