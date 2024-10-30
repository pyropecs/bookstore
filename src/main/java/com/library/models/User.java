package com.library.models;

public class User {
 private int id;
 private String username;
 private String department;
 private String designation;
 
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
}
