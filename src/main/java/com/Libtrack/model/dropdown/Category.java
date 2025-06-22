package com.LibTrack.model.dropdown;

import java.util.ArrayList;
import java.util.List;

public class Category {

	private List<String> categories;
	
	public Category() {
		categories = new ArrayList<>();
		categories.add("");
		categories.add("Educational");
		categories.add("Religious & Spiritual");
		categories.add("Business & Finance");
		categories.add("Non Fiction");
		categories.add("Fiction");
	}

	public List<String> getCategories() {
		return categories;
	}

	public void setCategories(List<String> categories) {
		this.categories = categories;
	}
}
