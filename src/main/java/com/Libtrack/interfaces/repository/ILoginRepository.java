package com.LibTrack.interfaces.repository;

import java.sql.SQLException;

public interface ILoginRepository {
	
	public String findUserType(String emailId) throws SQLException;
	public boolean passwordMatch(String emailId, String password) throws SQLException;
	public boolean alreadyExists(String emailId) throws SQLException;
	public int findUserIdByEmail(String emailId) throws SQLException;
	
	
	

}
