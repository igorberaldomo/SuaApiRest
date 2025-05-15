package com.example.demo.service.imp;

import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;
import com.example.demo.model.Book;
import com.example.demo.service.BookService;
import com.example.demo.repository.BookRepository;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Book findBookById(Long id) {
        return bookRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public Book createBook(Book bookToCreate) {
        if (bookToCreate.getId() != null && bookRepository.existsById(bookToCreate.getId())) {
            throw new IllegalArgumentException("this Book already exists");
        }
        return bookRepository.save(bookToCreate);
    }


    
}
