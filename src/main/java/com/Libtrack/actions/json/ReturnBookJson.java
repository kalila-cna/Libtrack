package com.LibTrack.actions.json;

import java.sql.SQLException;

import com.LibTrack.repository.BookRepositoryImpl;
import com.LibTrack.repository.ReturnBookRepositoryImpl;
import com.opensymphony.xwork2.ActionSupport;

public class ReturnBookJson extends ActionSupport{
	
	private static final long serialVersionUID = 1L;
	int userId;
	int bookId;
	boolean returned;
	
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
	public boolean isReturned() {
		return returned;
	}
	public void setReturned(boolean returned) {
		this.returned = returned;
	}
	
	@Override
	public String execute() {
		ReturnBookRepositoryImpl returnBookRepository = new ReturnBookRepositoryImpl();
		BookRepositoryImpl bookRepository= new BookRepositoryImpl();
		try {
			this.returned=returnBookRepository.returnBook(bookId, userId);
			bookRepository.increaseQuantity(bookId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return SUCCESS;
	}
	
	
	
	
	

}
