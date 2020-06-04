package com.lev.example;

import com.lev.example.entity.Book;
import com.lev.example.entity.Library;
import com.lev.example.entity.Record;
import com.lev.example.exceptions.*;
import com.lev.example.messages.AddNewRecordRequest;
import com.lev.example.messages.CloseRecordRequest;
import com.lev.example.repository.BooksRepository;
import com.lev.example.repository.LibraryRepository;
import com.lev.example.repository.RecordRepository;
import com.lev.example.services.LibraryServiceImpl;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class LibraryServiceTest {

    @InjectMocks
    private LibraryServiceImpl libraryService;

    @Mock
    private BooksRepository booksRepository;

    @Mock
    private LibraryRepository libraryRepository;

    @Mock
    private RecordRepository recordRepository;

    @Mock
    private Book book;


    @Test
    public void getBooksByAuthorTest(){
        ArrayList<Book> books = new ArrayList<>();
        when(booksRepository.findByIdAuthor(1)).thenReturn(books);
        Assertions.assertEquals(libraryService.getBooksByAuthor(1).size(), 0);
        books.add(new Book());
        Assertions.assertEquals(libraryService.getBooksByAuthor(1).size(), 1);

    }

    @Test
    public void getAllBooksTest(){
        ArrayList<Book> books = new ArrayList<>();
        when(booksRepository.findAll()).thenReturn(books);
        Assertions.assertEquals(libraryService.getAllBooks().size(), 0);
        books.add(new Book());
        Assertions.assertEquals(libraryService.getAllBooks().size(), 1);
    }

    @Test
    public void getBookByIdTest(){
        Book book = new Book();
        book.setName("3 tolstyaka");
        Optional<Book> bookOptional = Optional.of(book);
        when(booksRepository.findById(1)).thenReturn(bookOptional);
        Assertions.assertTrue(libraryService.getBookById(1).isPresent());
        Assertions.assertEquals(libraryService.getBookById(1).get().getName(),"3 tolstyaka");
        when(booksRepository.findById(1)).thenReturn(Optional.empty());
        Assertions.assertFalse(libraryService.getBookById(1).isPresent());
    }

    @Test
    public void saveBookTest(){
        Book book = new Book();
        when(booksRepository.save(book)).thenReturn(book);
        libraryService.saveBook(book);
        Assertions.assertNotNull(book);
    }

    @Test
    public void setAmountOfSpecificBookTest(){
        Library library = new Library();
        library.setIdBook(1);
        when(libraryRepository.findByIdBook(1)).thenReturn(Optional.of(library));
        libraryService.setAmountOfSpecificBook(1,10);
        verify(libraryRepository, times(1)).save(Mockito.any());
        Assertions.assertEquals(library.getAmountBook(), 10);

        Optional libraryNull = Optional.empty();
        when(libraryRepository.findByIdBook(20)).thenReturn(libraryNull);
        Assertions.assertThrows(NotFoundIdBookException.class, ()->{libraryService.setAmountOfSpecificBook(20, 10);});

    }


    @Test
    public void newRecordTest(){
        AddNewRecordRequest addNewRecordRequest = new AddNewRecordRequest();
        addNewRecordRequest.setIdBook(1);
        addNewRecordRequest.setIdReader(2);
        addNewRecordRequest.setDateTake(new Date().toString());

        Library library = new Library();
        library.setIdBook(1);
        library.setAmountBook(0);

        when(libraryRepository.findByIdBook(1)).thenReturn(Optional.empty());
        Assertions.assertThrows(NotFoundIdBookException.class, ()->libraryService.newRecord(addNewRecordRequest));

        when(libraryRepository.findByIdBook(1)).thenReturn(Optional.of(library));
        Assertions.assertThrows(NoSuchBookException.class,()->libraryService.newRecord(addNewRecordRequest));

        ArrayList<Record> allRecordsOfSpecificReader = new ArrayList<>();
        allRecordsOfSpecificReader.add(new Record());
        allRecordsOfSpecificReader.add(new Record());
        allRecordsOfSpecificReader.add(new Record());
        allRecordsOfSpecificReader.add(new Record());

        library.setAmountBook(10);
        when(recordRepository.findAllByIdReader(Mockito.anyInt())).thenReturn(allRecordsOfSpecificReader);
        Assertions.assertThrows(OverLimitBooksException.class, ()->libraryService.newRecord(addNewRecordRequest));

        allRecordsOfSpecificReader.remove(0);
        allRecordsOfSpecificReader.remove(0);
        allRecordsOfSpecificReader.remove(0);
        allRecordsOfSpecificReader.get(0).setIdBook(1);
        Assertions.assertThrows(TakeSameBookException.class, ()->libraryService.newRecord(addNewRecordRequest));

        allRecordsOfSpecificReader.get(0).setIdBook(5);

        allRecordsOfSpecificReader.get(0).setDateTake(new Date(new Date().getTime() -  31536000010L));
        Assertions.assertThrows(OverLimitTimeUsingBookException.class, ()->libraryService.newRecord(addNewRecordRequest));

        allRecordsOfSpecificReader.get(0).setDateTake(new Date());
        libraryService.newRecord(addNewRecordRequest);
        verify(recordRepository, Mockito.times(1)).save(Mockito.any());
// when(addNewRecordRequest.getIdReader()).thenReturn(2);
//        int idBook = addNewRecordRequest.getIdBook();
//        int idReader = addNewRecordRequest.getIdReader();


//        when(libraryRepository.findByIdBook(1)).thenReturn(Optional.of(library));
//        Assertions.assertNotNull(libraryRepository.findByIdBook(1));
//        when(libraryRepository.findByIdBook(null)).thenThrow(new NotFoundIdBookException());
//        Assertions.assertThrows(NotFoundIdBookException.class, ()->{libraryRepository.findByIdBook(null);});
//        Library bookRecord = library;
//        when(bookRecord.getAmountBook()).thenReturn(10);
//        Assertions.assertNotNull(library.getAmountBook());
//        int amountOfSpecificBook = library.getAmountBook();

//        when(recordRepository.findAllByIdReader(idReader)).thenReturn(allRecordsOfSpecificReader);
//        Assertions.assertNotNull(recordRepository.findAllByIdReader(idReader));


//        when(amountOfSpecificBook < 0).thenThrow(new NoSuchBookException());
//        ArrayList<Record> allRecordsOfSpecificReader1 = new ArrayList<>();
//
//        allRecordsOfSpecificReader1.add(new Record());
//        allRecordsOfSpecificReader1.add(new Record());

//        when(allRecordsOfSpecificReader.size() > LIMIT_BOOKS)
//                .thenThrow(new OverLimitBooksException());


//        Assertions.assertTrue(amountOfSpecificBook > 0);
//        Assertions.assertTrue(allRecordsOfSpecificReader1.size() < LIMIT_BOOKS);
//        Assertions.assertTrue(li);


    }

    @Test
    public void closeRecordTest(){
        Record record = new Record();
        record.setReturnDate(new java.sql.Date(new Date().getTime()));

        Book book = new Book();
        book.setId(1);

      CloseRecordRequest closeRecordRequest =new CloseRecordRequest();
      closeRecordRequest.setId(2);
      when(booksRepository.findById(1)).thenReturn(Optional.empty());
      Assertions.assertThrows(NoSuchRecordException.class, ()->libraryService.closeRecord(closeRecordRequest));
      when(booksRepository.findById(2)).thenReturn(Optional.of(book));
      book.setId(2);
      when(recordRepository.findById(book.getId())).thenReturn(Optional.of(record));
      libraryService.closeRecord(closeRecordRequest);
      verify(recordRepository, times(1)).save(record);

    }

    @Test
    public void checkingTheSameBookTest(){
        int idBook = 1;
//        libraryServiceMock.

    }

    @Test
    public void checkingOvertakenBookTest(){

    }
}
