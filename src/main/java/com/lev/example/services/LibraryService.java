package com.lev.example.services;

import com.lev.example.entity.Books;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lev.example.repository.BooksRepository;

import javax.transaction.Transactional;
import java.util.List;


@Service
public class LibraryService {

    @Autowired
    private BooksRepository booksRepository;

//    @Transactional
    public List<Books> getBooksByAuthor(int IdAuthor){
        return booksRepository.findByIdAuthor(IdAuthor);
    }
}
