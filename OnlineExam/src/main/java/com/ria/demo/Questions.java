package com.ria.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

 

@Entity
public class Questions {
    
    @Id @GeneratedValue(strategy=GenerationType.AUTO)
    private int questionId;
    private int examId;
    
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int qNumber;
    private String question;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
    private String correctAns;
    private int markForThatQuestion;
    
    public Questions() {
        // TODO Auto-generated constructor stub
    }

 

    public Questions(int questionId, int examId, int qNumber, String question, String option1, String option2,
            String option3, String option4, String correctAns, int markForThatQuestion) {
        super();
        this.questionId = questionId;
        this.examId = examId;
        this.qNumber = qNumber;
        this.question = question;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.option4 = option4;
        this.correctAns = correctAns;
        this.markForThatQuestion = markForThatQuestion;
    }
    
    

 

    public Questions(int examId, String question, String option1, String option2, String option3, String option4,
            String correctAns, int markForThatQuestion) {
        super();
        this.examId = examId;
        this.question = question;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.option4 = option4;
        this.correctAns = correctAns;
        this.markForThatQuestion = markForThatQuestion;
    }

 

    public int getQuestionId() {
        return questionId;
    }

 

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

 

    public int getExamId() {
        return examId;
    }

 

    public void setExamId(int examId) {
        this.examId = examId;
    }

 

    public int getqNumber() {
        return qNumber;
    }

 

    public void setqNumber(int qNumber) {
        this.qNumber = qNumber;
    }

 

    public String getQuestion() {
        return question;
    }

 

    public void setQuestion(String question) {
        this.question = question;
    }

 

    public String getOption1() {
        return option1;
    }

 

    public void setOption1(String option1) {
        this.option1 = option1;
    }

 

    public String getOption2() {
        return option2;
    }

 

    public void setOption2(String option2) {
        this.option2 = option2;
    }

 

    public String getOption3() {
        return option3;
    }

 

    public void setOption3(String option3) {
        this.option3 = option3;
    }

 

    public String getOption4() {
        return option4;
    }

 

    public void setOption4(String option4) {
        this.option4 = option4;
    }

 

    public String getCorrectAns() {
        return correctAns;
    }

 

    public void setCorrectAns(String correctAns) {
        this.correctAns = correctAns;
    }

 

    public int getMarkForThatQuestion() {
        return markForThatQuestion;
    }

 

    public void setMarkForThatQuestion(int markForThatQuestion) {
        this.markForThatQuestion = markForThatQuestion;
    }

 

    @Override
    public String toString() {
        return "Questions [questionId=" + questionId + ", examId=" + examId + ", qNumber=" + qNumber + ", question="
                + question + ", option1=" + option1 + ", option2=" + option2 + ", option3=" + option3 + ", option4="
                + option4 + ", correctAns=" + correctAns + ", markForThatQuestion=" + markForThatQuestion + "]";
    }
    
    

 

}