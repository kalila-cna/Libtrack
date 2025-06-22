package com.LibTrack.actions;

import java.sql.SQLException;

import com.LibTrack.model.LoadStudent;
import com.LibTrack.repository.StudentRepositoryImpl;
import com.opensymphony.xwork2.ActionSupport;

public class StudentDashboardAction extends ActionSupport{
	
	private static final long serialVersionUID = 1L;
	private int userId;
	private LoadStudent studentDetails;

	public LoadStudent getStudentDetails() {
		return studentDetails;
	}

	public void setStudentDetails(LoadStudent studentDetails) {
		this.studentDetails = studentDetails;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	@Override
	public String execute() {
		StudentRepositoryImpl studentRepository= new StudentRepositoryImpl();
		try {
			this.studentDetails=studentRepository.getStudentById(userId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}

}
