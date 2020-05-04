package com.lev.example.services;

import com.lev.example.entity.Books;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lev.example.repository.BooksRepository;


import java.util.List;


@Service
public class LibraryServiceImpl implements LibraryService {

    @Autowired
    private BooksRepository booksRepository;

    @Override
    public List<Books> getBooksByAuthor(int IdAuthor) {
        return booksRepository.findByIdAuthor(IdAuthor);
    }

    @Override
    public List<Books> getAllBooks() {
        return booksRepository.findAll();
    }

    @Override
    public Books getBooksById(int id) {
        return booksRepository.findById(id);
    }

    @Override
    public void saveBook(Books book) {
        booksRepository.save(book);

    }

}
