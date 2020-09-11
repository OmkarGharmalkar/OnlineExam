package com.ria.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Marks {
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private int markId;
	
	private int rollno;
	private int examId;
	private int marks;
	private String status;
	
	
	public Marks(int markId, int rollno, int examId, int marks, String status) {
		super();
		this.markId = markId;
		this.rollno = rollno;
		this.examId = examId;
		this.marks = marks;
		this.status = status;
	}

	public Marks(int rollno, int examId, int marks, String status) {
		super();
		this.rollno = rollno;
		this.examId = examId;
		this.marks = marks;
		this.status = status;
	}

	public Marks() {
		super();
	}

	public int getMarkId() {
		return markId;
	}

	public void setMarkId(int markId) {
		this.markId = markId;
	}

	public int getRollno() {
		return rollno;
	}

	public void setRollno(int rollno) {
		this.rollno = rollno;
	}

	public int getExamId() {
		return examId;
	}

	public void setExamId(int examId) {
		this.examId = examId;
	}

	public int getMarks() {
		return marks;
	}

	public void setMarks(int marks) {
		this.marks = marks;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Marks [markId=" + markId + ", rollno=" + rollno + ", examId=" + examId + ", marks=" + marks
				+ ", status=" + status + "]";
	}
	
	

}
