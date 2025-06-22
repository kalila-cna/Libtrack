package com.LibTrack.actions.json;

import java.sql.SQLException;
import java.util.List;

import com.LibTrack.model.EditBook;
import com.LibTrack.repository.BookRepositoryImpl;
import com.opensymphony.xwork2.ActionSupport;

public class BookJson extends ActionSupport{
	
	private static final long serialVersionUID = 1L;
	private List<EditBook> bookDetails;

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
			this.bookDetails=bookRepository.getAllBooks();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	
	
}
