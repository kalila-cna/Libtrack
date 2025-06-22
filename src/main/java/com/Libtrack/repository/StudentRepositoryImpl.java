package com.LibTrack.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.LibTrack.dataBase.DbConnection;
import com.LibTrack.interfaces.repository.IStudentRepository;
import com.LibTrack.model.LoadStudent;

public class StudentRepositoryImpl implements IStudentRepository{

	@Override
	public List<LoadStudent> getAllStudent() throws SQLException {
		
		
		String query = "SELECT * FROM student";
		List<LoadStudent> studentDetails= new ArrayList<>();
		

		try (Connection conn = DbConnection.getConection(); Statement st = conn.createStatement()) {

			try(ResultSet rs = st.executeQuery(query);){
			
			while (rs.next()) {
				LoadStudent model=new LoadStudent();
				model.setStudent_id(rs.getInt(1));
				model.setStudentName(rs.getString(2));
				model.setYear(rs.getInt(3));
				model.setDepartment(rs.getString(4));

				studentDetails.add(model);
			}
			}
		}

		return studentDetails;
	}

	@Override
	public LoadStudent getStudentById(int userId) throws SQLException {
		
		String query = "SELECT * FROM student WHERE user_id=?";
		LoadStudent studentDetails = null;

		try (Connection conn = DbConnection.getConection(); PreparedStatement pst = conn.prepareStatement(query)) {
			
			pst.setInt(1, userId);
			
			try(ResultSet rs = pst.executeQuery();){
			
			while (rs.next()) {
				LoadStudent model=new LoadStudent();
				model.setStudent_id(rs.getInt(1));
				model.setStudentName(rs.getString(2));
				model.setYear(rs.getInt(3));
				model.setDepartment(rs.getString(4));
				studentDetails=model;
			}
			}
		}

		return studentDetails;
	}

}
