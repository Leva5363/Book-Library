package com.lev.example.controllers;


import com.lev.example.entity.Books;
import com.lev.example.services.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Book;
import java.util.List;

@RestController
@RequestMapping("library")
public class LibraryController {

    @Autowired
    private LibraryService libraryService;

    @GetMapping("/getBooksByAuthor")
    public List<Books> getBooksByAuthor(@RequestParam int idAuthor) {
        return libraryService.getBooksByAuthor(idAuthor);
    }

    @GetMapping("/getAllBooks")
        public List <Books> getAllBooks() {
        return libraryService.getAllBooks();
        }

    @GetMapping("/getBookById")
    public Books getBookById(@RequestParam int id) {
        return libraryService.getBooksById(id);
        }

    @PostMapping("/saveBook")
    public HttpStatus saveBookStatus(@RequestBody Books book) {
        libraryService.saveBook(book);
        return HttpStatus.CREATED;
    }
}
