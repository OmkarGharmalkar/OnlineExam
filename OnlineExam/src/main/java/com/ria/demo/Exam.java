package com.ria.demo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

 

@Entity
public class Exam {
	
    
    @Id @GeneratedValue(strategy=GenerationType.AUTO)
    private int examId;
    private String examName;
    private int totalMarks;
    private int passingMarks;
    
    @OneToMany(cascade=CascadeType.ALL)
       private List<Questions> questions = new ArrayList<>();
    
    public Exam() {
        // TODO Auto-generated constructor stub
    }

 

    public Exam(int examId, String examName, int totalMarks, int passingMarks, List<Questions> questions) {
        super();
        this.examId = examId;
        this.examName = examName;
        this.totalMarks = totalMarks;
        this.passingMarks = passingMarks;
        this.questions = questions;
    }
    
    
    
    
    
    public Exam(String examName, int totalMarks, int passingMarks, List<Questions> questions) {
        super();
        this.examName = examName;
        this.totalMarks = totalMarks;
        this.passingMarks = passingMarks;
        this.questions = questions;
    }
    

 

    public int getExamId() {
        return examId;
    }

 

    public void setExamId(int examId) {
        this.examId = examId;
    }

 

    public String getExamName() {
        return examName;
    }

 

    public void setExamName(String examName) {
        this.examName = examName;
    }

 

    public int getTotalMarks() {
        return totalMarks;
    }

 

    public void setTotalMarks(int totalMarks) {
        this.totalMarks = totalMarks;
    }

 

    public int getPassingMarks() {
        return passingMarks;
    }

 

    public void setPassingMarks(int passingMarks) {
        this.passingMarks = passingMarks;
    }

 

    public List<Questions> getQuestions() {
        return questions;
    }

 

    public void setQuestions(List<Questions> questions) {
        this.questions = questions;
    }

 

    @Override
    public String toString() {
        return "Exam [examId=" + examId + ", examName=" + examName + ", totalMarks=" + totalMarks + ", passingMarks="
                + passingMarks + ", questions=" + questions + "]";
    }
    
    
    
}