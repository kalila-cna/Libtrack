package com.LibTrack.actions.json;

import java.sql.SQLException;

import com.LibTrack.repository.BookRepositoryImpl;
import com.opensymphony.xwork2.ActionSupport;

public class DeleteBookJson extends ActionSupport{

	private static final long serialVersionUID = 1L;
	
	private int book_id;
	private boolean deleted;
	
	public int getBook_id() {
		return book_id;
	}


	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}


	public boolean isDeleted() {
		return deleted;
	}


	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}
	
	@Override
	public String execute() {
		BookRepositoryImpl bookRepository= new BookRepositoryImpl();
		try {
			this.deleted=bookRepository.deleteBookById(book_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	

}
