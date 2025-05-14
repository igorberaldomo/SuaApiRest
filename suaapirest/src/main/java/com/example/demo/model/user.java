package main.java.com.example.demo.model;

public class user {
    private int id;
    private String name;
    private String email;
    private String password;
    private String penName;
    private book[] catalogue;

    
    public integer getId() {
        return id;
    }

    public void setId(int id) {
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

    public book[] getCatalogue() {
        return catalogue;
    }

    public void setCatalogue(book book) {
        book[] catalogue = this.catalogue;
        int i = 0;
        int newArray[] = new book[ catalogue.length + 1];
        for (i = 0; i < catalogue.length; i++) {
            newArray[i] = catalogue[i];
        }
        newArray[catalogue.length] = book;
        this.catalogue = newArray;
    }
}
