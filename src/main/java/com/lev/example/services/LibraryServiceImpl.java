package com.lev.example.services;

import com.lev.example.entity.Book;
import com.lev.example.entity.Library;
import com.lev.example.entity.Record;
import com.lev.example.repository.LibraryRepository;
import com.lev.example.repository.RecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lev.example.repository.BooksRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;


@Service
public class LibraryServiceImpl implements LibraryService {

    @Autowired
    private BooksRepository booksRepository;

    @Autowired
    LibraryRepository libraryRepository;

    @Autowired
    RecordRepository recordRepository;

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
    public void addBookToLibrary(Library library) {
        libraryRepository.save(library);

    }

    @Override
    public void newRecord(Record record) {
        if (libraryRepository.findById(record.getIdBook()).get().getAmountBook()>0) {

       } else {
           System.out.println("No such a book");
           return;
       }
       if (recordRepository.findAllByIdReader(record.getIdReader()).size()>3) {

       } else {
           System.out.println("The reader has more than 3 books");
           return;
       }

        ArrayList <Integer> idBookList = new ArrayList<>();
        ArrayList <Date> dateTakeList = new ArrayList<>();
       for (Record r:recordRepository.findAllByIdReader(record.getIdReader())) {
            idBookList.add(r.getIdBook());
       }

       for (Integer i : idBookList) {
           if (i.equals(record.getIdBook())) {
               System.out.println("The reader has the same book");
               return;
           }
       }

        for (Record r:recordRepository.findAllByIdReader(record.getIdReader())) {
           if(r.getReturnDate().equals(null)) {
               dateTakeList.add(r.getDateTake());
           }
        }


        for(Date date : dateTakeList) {
           Date todayDate = new Date();
           Long difInMinus = todayDate.getTime() - date.getTime();
           if (difInMinus > 31536000) {
               return;
           }
        }

        recordRepository.save(record);

        }

    @Override
    public void closeRecord(Record record) {
        recordRepository.findById(record.getIdBook()).get().setReturnDate(record.getReturnDate());
    }


}
