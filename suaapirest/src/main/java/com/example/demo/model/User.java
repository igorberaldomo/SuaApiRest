package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String email;
    private String password;
    private String penName;
    private Book[] catalogue;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPenName() {
        return penName;
    }

    public void setPenName(String penName) {
        this.penName = penName;
    }

    public Book[] getCatalogue() {
        return catalogue;
    }

    public void setCatalogue(Book book) {
        Book[] catalogue = this.catalogue;
        int i = 0;
        Book newArray[] = new Book[catalogue.length + 1];
        for (i = 0; i < catalogue.length; i++) {
            newArray[i] = catalogue[i];
        }
        newArray[catalogue.length] = book;
        this.catalogue = newArray;
    }
}
