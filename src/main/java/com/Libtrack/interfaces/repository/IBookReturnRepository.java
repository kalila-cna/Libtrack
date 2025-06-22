package com.LibTrack.interfaces.repository;

import java.sql.SQLException;
import java.util.List;

import com.LibTrack.model.ReturnBook;

public interface IBookReturnRepository {
	
	public List<ReturnBook> getAllBooksByUserId(int userId) throws SQLException;
	public boolean returnBook(int bookId, int userId) throws SQLException;
	
	

}
