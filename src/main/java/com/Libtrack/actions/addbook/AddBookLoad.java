package com.LibTrack.actions.addbook;

import com.LibTrack.model.dropdown.Category;
import com.opensymphony.xwork2.ActionSupport;

public class AddBookLoad extends ActionSupport{

	private static final long serialVersionUID = 1L;
	private Category categoryModel;
	
	public AddBookLoad() {
		categoryModel=new Category();
	}
	
	public Category getCategoryModel() {
		return categoryModel;
	}

	public void setCategoryModel(Category categoryModel) {
		this.categoryModel = categoryModel;
	}
	
	@Override
	public String execute() {
		return SUCCESS;
	}
	
}
