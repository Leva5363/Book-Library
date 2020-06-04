package com.lev.example.controllers;

import com.lev.example.messages.AddNewRecordRequest;
import com.lev.example.entity.Book;
import com.lev.example.messages.CloseRecordRequest;
import com.lev.example.messages.SetAmountRequest;
import com.lev.example.services.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


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
        return libraryService.getBookById(id).get();
    }

    @PostMapping("/saveBook")
    public HttpStatus saveBookStatus(@RequestBody Book book) {
        libraryService.saveBook(book);
        return HttpStatus.CREATED;
    }

    @PostMapping("/setAmountOfSpecificBook")
    public HttpStatus setAmountOfSpecificBook(@RequestBody SetAmountRequest setAmountRequest){
        libraryService.setAmountOfSpecificBook(setAmountRequest.getIdBook(), setAmountRequest.getAmount());
        return HttpStatus.ACCEPTED;
    }

    @PostMapping("/newRecord")
    public HttpStatus newRecord(@RequestBody AddNewRecordRequest addNewRecordRequest) {
        libraryService.newRecord(addNewRecordRequest);
        return HttpStatus.CREATED;
    }

    @PutMapping("/closeRecord")
    public HttpStatus closeRecord(@RequestBody CloseRecordRequest closeRecordRequest) {
        libraryService.closeRecord(closeRecordRequest);
        return HttpStatus.ACCEPTED;
    }
}
