package com.lev.example.services;

import com.lev.example.entity.Book;
import com.lev.example.repository.LibraryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lev.example.repository.BooksRepository;

import java.util.List;
import java.util.Optional;


@Service
public class LibraryServiceImpl implements LibraryService {

    @Autowired
    private BooksRepository booksRepository;

    @Autowired
    LibraryRepository libraryRepository;

    @Override
    public List<Book> getBooksByAuthor(int idAuthor) {
        return booksRepository.findByIdAuthor(idAuthor);
    }

    @Override
    public List<Book> getAllBooks() {
        return booksRepository.findAll();
    }

    @Override
    public Optional<Book> getBooksById(int id) {
        return booksRepository.findById(id);
    }

    @Override
    public void saveBook(Book book) {
        booksRepository.save(book);
        }

    @Override
    public void addBookToLibrary(int amount) {
        libraryRepository.addBookToLibrary(amount);

    }


}
