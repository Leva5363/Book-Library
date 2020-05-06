package com.lev.example.controllers;


import com.lev.example.entity.Book;
import com.lev.example.services.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("library")
public class LibraryController {

    @Autowired
    private LibraryService libraryService;

    @GetMapping("/getBooksByAuthor")
    public List<Book> getBooksByAuthor(@RequestParam int idAuthor) {
        return libraryService.getBooksByAuthor(idAuthor);
    }

    @GetMapping("/getAllBooks")
        public List <Book> getAllBooks() {
        return libraryService.getAllBooks();
        }

    @GetMapping("/getBookById")
    public Book getBookById(@RequestParam int id) {
            return libraryService.getBooksById(id).get();
    }

    @PostMapping("/saveBook")
    public HttpStatus saveBookStatus(@RequestBody Book book) {
        libraryService.saveBook(book);
        return HttpStatus.CREATED;
    }

    @PostMapping("/addBookToLibrary")
    public HttpStatus addBookToLibrary(@RequestParam int amount){
        libraryService.addBookToLibrary(amount);
        return HttpStatus.CREATED;
    }
}
