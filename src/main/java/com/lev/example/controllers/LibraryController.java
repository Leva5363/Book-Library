package com.lev.example.controllers;


import com.lev.example.entity.AddNewRecordEntity;
import com.lev.example.entity.Book;
import com.lev.example.entity.Library;
import com.lev.example.entity.Record;
import com.lev.example.services.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


import java.sql.Date;
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
            return libraryService.getBooksById(id).get();
    }

    @PostMapping("/saveBook")
    public HttpStatus saveBookStatus(@RequestBody Book book) {
        libraryService.saveBook(book);
        return HttpStatus.CREATED;
    }

    @PostMapping("/addBookToLibrary")
    public HttpStatus addBookToLibrary(@RequestBody Library library){
        libraryService.addBookToLibrary(library);
        return HttpStatus.CREATED;
    }

    @PostMapping("/newRecord")
        public HttpStatus newRecord(@RequestBody AddNewRecordEntity addNewRecordEntity) {
        System.out.println(" Date take is "+addNewRecordEntity.getDateTake());
        Record record = new Record(addNewRecordEntity.getIdBook(),addNewRecordEntity.getIdReader(),
                Date.valueOf(addNewRecordEntity.getDateTake()),
                Date.valueOf(addNewRecordEntity.getReturnDate()));
        libraryService.newRecord(record);
        return HttpStatus.CREATED;
        }

        @PostMapping("/closeRecord")
    public HttpStatus closeRecord(@RequestBody Record record) {
        libraryService.closeRecord(record);
        return HttpStatus.ACCEPTED;
        }
}
