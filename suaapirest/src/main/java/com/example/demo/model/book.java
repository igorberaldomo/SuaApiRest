package main.java.com.example.demo.model;

import javax.annotation.processing.Generated;

@Entity(name = "book")
public class book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int bookId;

    private int authorId;
    
    private String name;
    private String description;
    private String author;

    public void setId(int bookId) {
        this.bookId = bookId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
    public int getId() {
        return bookId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getAuthor() {
        return author;
    }
    
}
