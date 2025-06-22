package com.LibTrack.actions.addbook;

import java.sql.SQLException;

import com.LibTrack.model.Book;
import com.LibTrack.model.dropdown.Category;
import com.LibTrack.repository.BookRepositoryImpl;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class AddBookAction extends ActionSupport implements ModelDriven<Book>{
	
	
	private static final long serialVersionUID = 1L;
	Book book =new Book();
	Category categoryModel;
	
	
	public AddBookAction(){
		categoryModel=new Category();
	}
	
	public Category getCategoryModel() {
		return categoryModel;
	}

	public void setCategoryModel(Category categoryModel) {
		this.categoryModel = categoryModel;
	}

	@Override
	public Book getModel() {
		return book;
	}
	
	@Override
	public String execute() {
		BookRepositoryImpl addBookRepository=new BookRepositoryImpl();
		try {
			addBookRepository.addBook(book);
			addActionMessage("Book added successfully!");
		} catch (SQLException e) {
			addActionError("Failed to add book: " + e.getMessage()); 
		}
		return SUCCESS;
	}

}
