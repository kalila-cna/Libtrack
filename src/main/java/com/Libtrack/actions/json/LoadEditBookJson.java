package com.LibTrack.actions.json;

import java.sql.SQLException;
import java.util.List;

import com.LibTrack.model.EditBook;
import com.LibTrack.repository.BookRepositoryImpl;
import com.opensymphony.xwork2.ActionSupport;

public class LoadEditBookJson extends ActionSupport{
	
	private static final long serialVersionUID = 1L;
	private int id;
	private List<EditBook> bookDetails;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<EditBook> getBookDetails() {
		return bookDetails;
	}

	public void setBookDetails(List<EditBook> bookDetails) {
		this.bookDetails = bookDetails;
	}
	
	@Override
	public String execute() {
		BookRepositoryImpl bookRepository= new BookRepositoryImpl();
		try {
			this.bookDetails=bookRepository.getBookById(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	
	
	
	

}
