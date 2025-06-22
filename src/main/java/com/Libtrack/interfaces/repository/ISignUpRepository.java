package com.LibTrack.interfaces.repository;

import java.sql.SQLException;

import com.LibTrack.model.Student;

public interface ISignUpRepository {
	
	public void addStudent(Student student) throws SQLException;
	public int getUserId(Student student) throws SQLException;
}
