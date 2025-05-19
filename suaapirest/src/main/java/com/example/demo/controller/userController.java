package com.example.demo.controller;

import com.example.demo.service.UserService;
import com.example.demo.service.BookService;
import com.example.demo.model.User;
import com.example.demo.model.Book;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping("/users")
public class userController {

    private final UserService userService;
    private final BookService bookService;

    public userController(UserService userService, BookService bookService) {
        this.userService = userService;
        this.bookService = bookService;
    }

    @GetMapping("/test")
    public String test() {
        return "api is working";
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

    @PutMapping("/{id}")
    public User UpdateUser(@PathVariable String id, @RequestBody User entity) {
        System.out.println(id);
        System.out.println(entity);

        var user = userService.findByID(Long.parseLong(id));
        if (user == null) {
            return null;
        } else {
            user.setName(entity.getName());
            user.setId(entity.getId());
            user.setEmail(entity.getEmail());
            user.setPassword(id);
            user.setCatalogue(entity.getCatalogue());
            userService.UpdateUser(user);
            return user;
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable String id) {
        var user = userService.findByID(Long.parseLong(id));
        if (user == null) {
            return null;
        } else {
            userService.DeleteUser(Long.parseLong(id));
            return ResponseEntity.noContent().build();
        }
    }

    @GetMapping("/books/{id}")
    public String findBookByID(@PathVariable Long id) {
        var book = bookService.findBookById(id);
        return ResponseEntity.ok(book).toString();
    }

    @PostMapping("/books/{id}")
    public ResponseEntity<Book> createBook(@RequestBody Book book) {
        var createdBook = bookService.createBook(book);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/books/{id}")
                .buildAndExpand(createdBook.getId()).toUri();
        return ResponseEntity.created(location).body(createdBook);

    }

    @PutMapping("books/{id}")
    public Book updateBook(@PathVariable String id, @RequestBody Book entity) {

        entity.setId(Long.parseLong(id));
        bookService.updateBook(entity);

        return entity;
    }

    @DeleteMapping("/books/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable String id) {
        var book = bookService.findBookById(Long.parseLong(id));
        if (book == null) {
            return null;
        } else {
            bookService.deleteBook(Long.parseLong(id));
        }
        return ResponseEntity.noContent().build();
    }

}
