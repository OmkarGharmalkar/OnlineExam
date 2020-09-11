package com.ria.demo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

 

@Entity
public class Student {
     
    @Id 
    private int rollno;
    private String username;
    private String password;
    private boolean status;
    @OneToMany(cascade=CascadeType.ALL)
   
  private List<Marks> marks = new ArrayList<>();
    
    public Student() {
        // TODO Auto-generated constructor stub
    }

 

    public Student(int rollno, String username, String password, List<Marks> marks) {
        super();
        this.rollno = rollno;
        this.username = username;
        this.password = password;
        this.status = false;
        this.marks = marks;
    }

 

    public Student(int rollno, String username, String password) {
        super();
        this.rollno = rollno;
        this.username = username;
        this.password = password;
        this.status = false;
    }

 

    public int getrollno() {
        return rollno;
    }

 

    public void setrollno(int rollno) {
        this.rollno = rollno;
    }

 

    public String getUsername() {
        return username;
    }

 

    public void setUsername(String username) {
        this.username = username;
    }

 

    public String getPassword() {
        return password;
    }

 

    public void setPassword(String password) {
        this.password = password;
    }

 

    public boolean isStatus() {
        return status;
    }

 

    public void setStatus(boolean status) {
        this.status = status;
    }

 

    public List<Marks> getMarks() {
        return marks;
    }

 

    public void setMarks(List<Marks> marks) {
        this.marks = marks;
    }

 

    @Override
    @JsonIgnore
    public String toString() {
        return "Student [rollno=" + rollno + ", username=" + username + ", password=" + password + ", status="
                + status + ", marks=" + marks + "]";
    }
    
    

 

}