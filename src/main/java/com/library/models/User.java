package com.library.models;
import java.util.List;

public class User {
 private int id;
 private String username;
 private String department;
 private String designation;
 private List<Book> books;
 public int getId() {
     return id;
 }
 public String getDesignation() {
     return designation;
 }
 public String getDepartment() {
     return department;
 }
 public String getUsername() {
     return username;
 }

 public List<Book> getBooks() {
         return books;
 }
 public void setId(int id) {
     this.id = id;
 }
 public void setDepartment(String department) {
     this.department = department;
 }
 public void setDesignation(String designation) {
     this.designation = designation;
 }
 public void setUsername(String username) {
     this.username = username;
 }
 public void setBooks(List<Book> books) {
         this.books = books;
 }
}
