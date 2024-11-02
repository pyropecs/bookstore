package com.library.models;

import java.util.List;
public class Book {

private int id;
private String name;
private String author;
private float price;
private List<User> users;

public int getId() {
        return id;
}
public String getAuthor() {
        return author;
}
public String getName() {
        return name;
}
public float getPrice() {
        return price;
}
public List<User> getUsers() {
        return users;
}
public void setUsers(List<User> users) {
        this.users = users;
}
public void setAuthor(String author) {
        this.author = author;
}
public void setId(int id) {
        this.id = id;
}
public void setPrice(float price) {
        this.price = price;
}
public void setName(String name) {
        this.name = name;
}


}
