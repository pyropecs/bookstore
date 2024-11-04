package com.library.models;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;


public class User {
 private int id;
 private String username;
 private String department;
 private String designation;
 @JsonBackReference
 private Set<Book> books;
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

 public Set<Book> getBooks() {
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
 public void setBooks(Set<Book> books) {
         this.books = books;
 }
}
