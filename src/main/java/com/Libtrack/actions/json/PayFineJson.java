package com.LibTrack.actions.json;

import java.sql.SQLException;

import com.LibTrack.repository.FineRepositoryImpl;
import com.opensymphony.xwork2.ActionSupport;

public class PayFineJson extends ActionSupport{
	
	private static final long serialVersionUID = 1L;
	int userId;
	int bookId;
	boolean paid;
	
	public boolean isPaid() {
		return paid;
	}
	public void setPaid(boolean paid) {
		this.paid = paid;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	
	
	@Override
	public String execute() {
		
		FineRepositoryImpl fineRepository= new FineRepositoryImpl();
		try {
			this.paid=fineRepository.payFineByBookId(userId, bookId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return SUCCESS;
	}
	

}
