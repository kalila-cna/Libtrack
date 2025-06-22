package com.LibTrack.interfaces.repository;

import java.sql.SQLException;
import java.util.List;

import com.LibTrack.model.LoadStudent;

public interface IStudentRepository {
	
	public List<LoadStudent> getAllStudent() throws SQLException;
	public LoadStudent getStudentById(int userId) throws SQLException;

}
