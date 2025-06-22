package com.LibTrack.actions.json;

import java.sql.SQLException;

import com.LibTrack.repository.BookAvailRepositoryImpl;
import com.LibTrack.repository.BookRepositoryImpl;
import com.opensymphony.xwork2.ActionSupport;

public class AvailBookJson extends ActionSupport{

	private static final long serialVersionUID = 1L;
	
	private int bookId;
	private int userId;
	private boolean availed;
	private int quantity;
	private boolean alreadyAvailed;
	
	
	public boolean isAlreadyAvailed() {
		return alreadyAvailed;
	}
	public void setAlreadyAvailed(boolean alreadyAvailed) {
		this.alreadyAvailed = alreadyAvailed;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public boolean isAvailed() {
		return availed;
	}
	public void setAvailed(boolean availed) {
		this.availed = availed;
	}
	
	@Override
	public void validate() {
		if(quantity <= 0) addActionError("Book currently not Available");
		BookAvailRepositoryImpl bookAvail= new BookAvailRepositoryImpl();
		
		try {
			this.alreadyAvailed=bookAvail.alreadyAvailed(userId, bookId);
			if(alreadyAvailed) {
			addActionError("You have availed this book Already");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public String execute() {
		BookAvailRepositoryImpl bookAvail= new BookAvailRepositoryImpl();
		BookRepositoryImpl bookRepository=new BookRepositoryImpl();
		try {
			bookAvail.availBook(userId, bookId);
			bookRepository.reduceQuantity(bookId);
			this.availed=true;
		} catch (SQLException e) {
			e.printStackTrace();
			this.availed=false;
		}
		
		return SUCCESS;
	}
	
	
	
	

}
