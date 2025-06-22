package com.LibTrack.actions.json;

import java.sql.SQLException;
import java.util.List;

import com.LibTrack.model.ReturnBook;
import com.LibTrack.repository.ReturnBookRepositoryImpl;
import com.opensymphony.xwork2.ActionSupport;

public class LoadReturnBookJson extends ActionSupport{
	
	private static final long serialVersionUID = 1L;
	private int userId;
	private List<ReturnBook> returnBookDetails;
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public List<ReturnBook> getReturnBookDetails() {
		return returnBookDetails;
	}
	public void setReturnBookDetails(List<ReturnBook> returnBookDetails) {
		this.returnBookDetails = returnBookDetails;
	}
	
	@Override
	public String execute() {
		
		ReturnBookRepositoryImpl returnBookRepository= new ReturnBookRepositoryImpl();
		try {
			this.returnBookDetails=returnBookRepository.getAllBooksByUserId(userId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	

	
	
	
	
	
	

}
