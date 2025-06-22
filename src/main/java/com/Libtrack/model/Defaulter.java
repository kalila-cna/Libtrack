package com.LibTrack.model;

public class Defaulter {
	
	int defaulterId;
	int studentId;
	String studentName;
	int year;
	String department;
	int bookId;
	String bookName;
	int overDueDays;
	double fineAmount;
	String fineStatus;
	
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	
	public int getDefaulterId() {
		return defaulterId;
	}
	public void setDefaulterId(int defaulterId) {
		this.defaulterId = defaulterId;
	}
	
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public int getOverDueDays() {
		return overDueDays;
	}
	public void setOverDueDays(int overDueDays) {
		this.overDueDays = overDueDays;
	}
	public double getFineAmount() {
		return fineAmount;
	}
	public void setFineAmount(double fineAmount) {
		this.fineAmount = fineAmount;
	}
	public String getFineStatus() {
		return fineStatus;
	}
	public void setFineStatus(String fineStatus) {
		this.fineStatus = fineStatus;
	}
	
}
