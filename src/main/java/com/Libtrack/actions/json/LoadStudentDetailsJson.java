package com.LibTrack.actions.json;

import java.sql.SQLException;
import java.util.List;

import com.LibTrack.model.LoadStudent;
import com.LibTrack.repository.StudentRepositoryImpl;
import com.opensymphony.xwork2.ActionSupport;

public class LoadStudentDetailsJson extends ActionSupport{
	
	private static final long serialVersionUID = 1L;
	private List<LoadStudent> studentDetails;

	
	
	public List<LoadStudent> getStudentDetails() {
		return studentDetails;
	}



	public void setStudentDetails(List<LoadStudent> studentDetails) {
		this.studentDetails = studentDetails;
	}



	@Override
	public String execute() {
		StudentRepositoryImpl studentRepository = new StudentRepositoryImpl();
		try {
			this.studentDetails=studentRepository.getAllStudent();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return SUCCESS;
	}
	
	
	
}