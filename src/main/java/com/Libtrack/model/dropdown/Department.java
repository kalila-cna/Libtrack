package com.LibTrack.model.dropdown;

import java.util.ArrayList;
import java.util.List;

public class Department {
	
	private List<String> departments;
	
	public Department() {
		departments=new ArrayList<>();
		departments.add("");
		departments.add("Computer Science");
		departments.add("Information Technology");
		departments.add("Electronics and Communication");
		departments.add("Mechanical");
		departments.add("Civil");
	}

	public List<String> getDepartments() {
		return departments;
	}


	public void setDepartments(List<String> departments) {
		this.departments = departments;
	}

}
