package com.LibTrack.actions.signup;

import java.sql.SQLException;

import com.LibTrack.model.Student;
import com.LibTrack.model.dropdown.Department;
import com.LibTrack.model.dropdown.Year;
import com.LibTrack.repository.LoginRepositoryImpl;
import com.LibTrack.repository.SignUpRepositoryImpl;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class SignUpAction extends ActionSupport implements ModelDriven<Student> {

	private static final long serialVersionUID = 1L;

	Student student = new Student();
	private Year yearModel;
	private Department departmentModel;

	@Override
	public Student getModel() {
		return student;
	}

	public SignUpAction() {
		yearModel = new Year();
		departmentModel = new Department();
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
	public void validate() {
		LoginRepositoryImpl loginRepository = new LoginRepositoryImpl();
		try {
			if (student.getEmailId() == null || student.getEmailId().trim().equals("")) {
				addFieldError("emailId", "Email Id is required");
			} else if (student.getPassword() == null || student.getPassword().trim().equals("")) {
				addFieldError("password", "Password is required");
			} else if (student.getDepartment() == null || student.getDepartment().trim().equals("")) {
				addFieldError("department", "Select Department");
			} else if (!(student.getPassword().trim().equals(student.getConfirmPassword().trim()))) {
				addFieldError("emailId", "ReCheck your Password");
			} else if (loginRepository.alreadyExists(student.getEmailId())) {
				addFieldError("emailId", "Email Id already exists. Try Logging In");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public String execute() {
		SignUpRepositoryImpl signUp = new SignUpRepositoryImpl();
		try {
			signUp.addStudent(student);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		addActionMessage("Successfully Signed Up. Happy Reading");
		return SUCCESS;
	}

}
