package com.LibTrack.actions.json;


import java.sql.SQLException;

import com.LibTrack.model.EditBook;
import com.LibTrack.repository.BookRepositoryImpl;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;


public class SaveBookJson extends ActionSupport implements ModelDriven<EditBook>{

	private static final long serialVersionUID = 1L;
	EditBook editBook=new EditBook();
	private boolean saved;
	
	
	public boolean isSaved() {
		return saved;
	}


	public void setSaved(boolean saved) {
		this.saved = saved;
	}


	@Override
	public EditBook getModel() {
		return editBook;
	}
	
	@Override
	public String execute() {
		BookRepositoryImpl bookRepository= new BookRepositoryImpl();
		try {
			this.saved=bookRepository.updateBookById(editBook);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	
	
	

}
