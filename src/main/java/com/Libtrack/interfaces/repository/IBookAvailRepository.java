package com.LibTrack.interfaces.repository;

import java.sql.SQLException;

public interface IBookAvailRepository {
	
	public boolean availBook(int userId, int bookId) throws SQLException;
	public boolean alreadyAvailed(int userId, int bookId) throws SQLException;

}
