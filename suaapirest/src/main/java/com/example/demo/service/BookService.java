package com.example.demo.service;

import com.example.demo.model.Book;
public interface BookService {

    Book findBookById(Long id) ;

    Book createBook(Book book) ;
    
}
