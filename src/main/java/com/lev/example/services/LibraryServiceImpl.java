package com.lev.example.services;


import com.lev.example.entity.Book;
import com.lev.example.entity.Library;
import com.lev.example.entity.Record;
import com.lev.example.exceptions.*;
import com.lev.example.messages.AddNewRecordRequest;
import com.lev.example.messages.CloseRecordRequest;
import com.lev.example.repository.LibraryRepository;
import com.lev.example.repository.RecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lev.example.repository.BooksRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;



@Service
public class LibraryServiceImpl implements LibraryService {

    private static final long ONE_YEAR = 31536000000L;
    private static final int LIMIT_BOOKS = 3;

    @Autowired
    private BooksRepository booksRepository;

    @Autowired
    private LibraryRepository libraryRepository;

    @Autowired
    private RecordRepository recordRepository;



    @Override
    public List<Book> getBooksByAuthor(int idAuthor) {
        return booksRepository.findByIdAuthor(idAuthor);
    }

    @Override
    public List<Book> getAllBooks() {
        return booksRepository.findAll();
    }

    @Override
    public Optional<Book> getBookById(int id) {
        return booksRepository.findById(id);
    }

    @Override
    public void saveBook(Book book) {
        booksRepository.save(book);
    }

    @Override
    public void setAmountOfSpecificBook(int idBook, int amount) {
        Library libraryBook = libraryRepository.findByIdBook(idBook)
                .orElseThrow(NotFoundIdBookException::new);
        libraryBook.setAmountBook(amount);
        libraryRepository.save(libraryBook);
    }

    @Override
    public void newRecord(AddNewRecordRequest addNewRecordRequest) {
        int idBook = addNewRecordRequest.getIdBook();
        int idReader = addNewRecordRequest.getIdReader();
        Library bookRecord = libraryRepository.findByIdBook(idBook)
                .orElseThrow(NotFoundIdBookException::new);

        int amountOfSpecificBook = bookRecord.getAmountBook();
        List <Record> allRecordsOfSpecificReader = recordRepository
                .findAllByIdReader(idReader);

        if (amountOfSpecificBook == 0) {
            throw new NoSuchBookException();
        }
        else  if (allRecordsOfSpecificReader.size() > LIMIT_BOOKS) {
            throw new OverLimitBooksException();
        }
        else if (!checkingTheSameBook(allRecordsOfSpecificReader, idBook)){
            throw new TakeSameBookException();
        }
        else if (!checkingOvertakenBook(allRecordsOfSpecificReader)){
            throw new OverLimitTimeUsingBookException();
        }
        else {
            //Adding new Record
            Record record = new Record();
            record.setIdReader(addNewRecordRequest.getIdReader());
            record.setIdBook(addNewRecordRequest.getIdReader());
            record.setDateTake(new java.sql.Date(new Date().getTime()));

            recordRepository.save(record);
        }
    }

    @Override
    public void closeRecord(CloseRecordRequest closeRecordRequest) {
        Book book = booksRepository.findById(closeRecordRequest.getId())
                .orElseThrow(NoSuchRecordException::new);
        Record record = recordRepository.findById(book.getId()).get();
        record.setReturnDate(new java.sql.Date(new Date().getTime()));
        recordRepository.save(record);
    }

    //Methods for newRecord method
    private boolean checkingTheSameBook(List<Record> allRecordsOfSpecificReader, int idBook){
        return allRecordsOfSpecificReader.stream()
                .noneMatch(i->i.getIdBook() == idBook);

    }

    private boolean checkingOvertakenBook(List<Record> allRecordsOfSpecificReader){
        Date today = new Date();
        return allRecordsOfSpecificReader.stream()
                .filter(d->d.getReturnDate() == null)
                .allMatch(i->i.getReturnDate() != null || i.getDateTake().getTime() > today.getTime() - ONE_YEAR);
    }
}


