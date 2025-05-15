package com.example.demo.controller;

import com.example.demo.service.UserService;
import com.example.demo.service.BookService;
import com.example.demo.model.User;
import com.example.demo.model.Book;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/users")
public class userController {

    private final UserService userService;
    private final BookService bookService;

    public userController(UserService userService, BookService bookService) {
        this.userService = userService;
        this.bookService = bookService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> findByID(@PathVariable Long id) {
        var user = userService.findByID(id);
        return ResponseEntity.ok(user);
    }

    @PostMapping("/{id}")
    public ResponseEntity<User> create(@RequestBody User user) {
        var userCreated = userService.create(user);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(userCreated.getId()).toUri();
        return ResponseEntity.created(location).body(userCreated);
    }

    @GetMapping("/books/{id}")
    public String findBookByID(@PathVariable Long id) {
        var book = bookService.findBookById(id);
        return ResponseEntity.ok(book).toString();
    }

    @PostMapping("/books/{id}")
    public  ResponseEntity<Book> createBook(@RequestBody Book book) {
        var createdBook = bookService.createBook(book);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/books/{id}")
                .buildAndExpand(createdBook.getId()).toUri();
        return ResponseEntity.created(location).body(createdBook);

    }

}
