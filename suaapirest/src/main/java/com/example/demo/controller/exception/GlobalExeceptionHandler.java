package com.example.demo.controller.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.NoSuchElementException;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


@RestControllerAdvice
public class GlobalExeceptionHandler {

   private final Logger logger = LoggerFactory.getLogger(GlobalExeceptionHandler.class);
    
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleIllegalArgumentException(IllegalArgumentException ex) {
        var message = "Bad request";
        logger.error(message, ex);
        return  new ResponseEntity<>(message, HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<String> handleNoSuchElementException(NoSuchElementException ex) {
        var message = "Resorce ID not found";
        logger.error(message, ex);
        return  new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Throwable.class)
    public ResponseEntity<String> handleUnespectedException(Throwable ex) {
        var message = "Unexpected server error, see logs";
        logger.error(message, ex);
        return  new ResponseEntity<>(message, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
