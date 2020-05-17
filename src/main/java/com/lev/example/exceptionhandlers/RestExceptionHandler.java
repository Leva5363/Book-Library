package com.lev.example.exceptionhandlers;


import com.lev.example.exceptions.NoSuchBookException;
import com.lev.example.exceptions.OverLimitBooksException;
import com.lev.example.exceptions.OverLimitTimeUsingBookException;
import com.lev.example.exceptions.TakeSameBookException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler (NoSuchBookException.class)
    public ResponseEntity <NoSuchBookException> noSuchBookExceptionHandler() {
        logger.info (NoSuchBookException.class);
        return new ResponseEntity ("No such a book in the library", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler (OverLimitBooksException.class)
    public ResponseEntity <OverLimitBooksException> overLimitBooksExceptionHandler() {
        logger.info(OverLimitBooksException.class);
        return new ResponseEntity("The reader has more than 3 books", HttpStatus.NOT_ACCEPTABLE);
    }

    @ExceptionHandler(OverLimitTimeUsingBookException.class)
    public ResponseEntity <OverLimitTimeUsingBookException> overLimitTimeUsingBookExceptionHandler() {
        logger.info(OverLimitTimeUsingBookException.class);
        return new ResponseEntity("The reader has overtaken book", HttpStatus.NOT_ACCEPTABLE);
    }

    @ExceptionHandler(TakeSameBookException.class)
    public ResponseEntity <TakeSameBookException> takeSameBookExceptionHandler(){
        logger.info(TakeSameBookException.class);
        return new ResponseEntity("The reader has overtaken book", HttpStatus.NOT_ACCEPTABLE);
    }
}
