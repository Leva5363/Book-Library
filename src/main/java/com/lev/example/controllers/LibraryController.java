package com.lev.example.controllers;


import com.lev.example.entity.Books;
import com.lev.example.services.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
}
