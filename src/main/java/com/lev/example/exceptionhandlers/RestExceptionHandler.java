package com.lev.example.exceptionhandlers;


import com.lev.example.exceptions.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(NoSuchBookException.class)
    public ResponseEntity<String> noSuchBookExceptionHandler() {
        logger.error("No such a book in the library, expected exception");
        return new ResponseEntity<>("No such a book in the library", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(OverLimitBooksException.class)
    public ResponseEntity<String> overLimitBooksExceptionHandler() {
        logger.error("The reader has more than 3 books, expected exception");
        return new ResponseEntity<>("The reader has more than 3 books", HttpStatus.NOT_ACCEPTABLE);
    }

    @ExceptionHandler(OverLimitTimeUsingBookException.class)
    public ResponseEntity<String> overLimitTimeUsingBookExceptionHandler() {
        logger.error("The reader has overtaken book, expected exception");
        return new ResponseEntity<>("The reader has overtaken book", HttpStatus.NOT_ACCEPTABLE);
    }

    @ExceptionHandler(TakeSameBookException.class)
    public ResponseEntity<String> takeSameBookExceptionHandler(){
        logger.error("The reader has overtaken book, expected exception");
        return new ResponseEntity<>("The reader has overtaken book", HttpStatus.NOT_ACCEPTABLE);
    }

    @ExceptionHandler(NotFoundIdBookException.class)
    public ResponseEntity<String> notFoundIdBookExceptionHandler(){
        logger.error("There is no book with such Id, error of customer.");
        return new ResponseEntity<>("There is no book with such Id!", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(NoSuchRecordException.class)
    public ResponseEntity<String> noSuchRecordExceptionHandler(){
        return new ResponseEntity<>("There is no such record, error of customer",HttpStatus.NOT_FOUND);
    }
}
