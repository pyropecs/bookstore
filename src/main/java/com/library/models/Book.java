package com.library.models;

public class Book {

private int id;
private String name;
private String author;
private float price;

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
