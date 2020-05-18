package com.lev.example.services;


import com.lev.example.entity.Book;
import com.lev.example.entity.Library;
import com.lev.example.entity.Record;
import com.lev.example.exceptions.NoSuchBookException;
import com.lev.example.exceptions.OverLimitBooksException;
import com.lev.example.exceptions.OverLimitTimeUsingBookException;
import com.lev.example.exceptions.TakeSameBookException;
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

    static final long ONE_YEAR = 31536000000L;
    static final int LIMIT_BOOKS = 4;

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
    public void setAmountOfSpecificBook(Library library) {
        libraryRepository.save(library);

    }

    @Override
    public void newRecord(AddNewRecordRequest addNewRecordRequest) {

        Record record = new Record();
        record.setIdReader(addNewRecordRequest.getIdReader());
        record.setIdBook(addNewRecordRequest.getIdReader());
        record.setDateTake(new java.sql.Date(new Date().getTime()));

        int amountOfSpecificBook = libraryRepository.findByIdBook(record.getIdBook()).get().getAmountBook();
        List <Record> allRecordsOfSpecificReader = recordRepository.findAllByIdReader(record.getIdReader());



        //Checking if there is enough such a book in the library
        if (amountOfSpecificBook > 0) {

       } else {
           throw new NoSuchBookException();
       }

       //Checking if the reader has less than 3 books
       if (allRecordsOfSpecificReader.size()<LIMIT_BOOKS) {

       } else {
           throw new OverLimitBooksException();
       }

       //Checking if the reader hasn't the same book he wants to take
        allRecordsOfSpecificReader.stream()
                .map(Record::getIdBook)
                .filter(i->i.equals(record.getIdBook()))
                .findAny().orElseThrow(TakeSameBookException::new);


       //Checking if the reader hasn't overtaken book
        allRecordsOfSpecificReader.stream()
                .filter(d->d.getReturnDate()==null)
                .map(Record::getDateTake)
                .map(x->new Date().getTime()-x.getTime())
                .filter(x->x>ONE_YEAR).findAny().orElseThrow(OverLimitTimeUsingBookException::new);

        //Adding new Record
        recordRepository.save(record);

        }

    @Override
    public void closeRecord(CloseRecordRequest closeRecordRequest) {
        Record record = recordRepository.findByIdReaderAndIdBook(closeRecordRequest.getIdReader(), closeRecordRequest.getIdBook());

        record.setReturnDate(new java.sql.Date(new Date().getTime()));
        recordRepository.save(record);
    }
}


