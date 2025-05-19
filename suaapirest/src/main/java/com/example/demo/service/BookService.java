package com.example.demo.service;

import com.example.demo.model.Book;
public interface BookService {

    Book findBookById(Long id) ;

    Book createBook(Book book) ;

    Book updateBook(Book book) ;

    Book deleteBook(Long id) ;
    
}
