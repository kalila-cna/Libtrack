package com.LibTrack.actions.signup;

import com.LibTrack.model.dropdown.Department;
import com.LibTrack.model.dropdown.Year;
import com.opensymphony.xwork2.ActionSupport;

public class SignUpLoad extends ActionSupport{
	private static final long serialVersionUID = 1L;
	private Year yearModel;
	private Department departmentModel;
	
	public SignUpLoad() {
		yearModel=new Year();
		departmentModel=new Department();
	}
	
	
	public Year getYearModel() {
		return yearModel;
	}

	public void setYearModel(Year yearModel) {
		this.yearModel = yearModel;
	}

	public Department getDepartmentModel() {
		return departmentModel;
	}

	public void setDepartmentModel(Department departmentModel) {
		this.departmentModel = departmentModel;
	}
	
	@Override
	public String execute() {
		return SUCCESS;
	}

}
