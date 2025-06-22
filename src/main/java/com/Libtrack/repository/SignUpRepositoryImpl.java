package com.LibTrack.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.LibTrack.dataBase.DbConnection;
import com.LibTrack.interfaces.repository.ISignUpRepository;
import com.LibTrack.model.Student;

public class SignUpRepositoryImpl implements ISignUpRepository{

	@Override
	public void addStudent(Student student) throws SQLException {
		
		String query = "INSERT INTO student (name, year, department, user_id) values(?,?,?,?);";
		
		try (
		        Connection connection = DbConnection.getConection();
		        PreparedStatement pst = connection.prepareStatement(query)
		    ) {
		        pst.setString(1, student.getFullName());
		        pst.setInt(2, student.getYear());
		        pst.setString(3, student.getDepartment());
		        pst.setInt(4, getUserId(student));

		        pst.executeUpdate();
		    }

		
	}

	@Override
	public int getUserId(Student student) throws SQLException {
		
		String query = "INSERT INTO login (email_id, password, user_type) values(?,?,?);";
		PasswordRepositoryImpl passwordRepository = new PasswordRepositoryImpl();
	    int userId = 0;

	    try (
	        Connection connection = DbConnection.getConection();
	        PreparedStatement pst = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)
	    ) {
	        pst.setString(1, student.getEmailId().toLowerCase());
	        pst.setString(2, passwordRepository.encodedPassword(student.getPassword()));
	        pst.setString(3, "user");

	        int rows = pst.executeUpdate();

	        if (rows > 0) {
	            try (ResultSet rs = pst.getGeneratedKeys()) {
	                if (rs.next()) {
	                    userId = rs.getInt(1);
	                }
	            }
	        }
	    }
		return userId;
	}

}
