package com.LibTrack.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.LibTrack.dataBase.DbConnection;
import com.LibTrack.interfaces.repository.IFineRepository;

public class FineRepositoryImpl implements IFineRepository{

	@Override
	public boolean payFineByBookId(int userId, int bookId) throws SQLException {
		
		String query = "UPDATE defaulter SET fine_status = 'paid'"
				+ " WHERE book_id = ?"
				+ " AND student_id= (SELECT id FROM student WHERE user_id= ?);";
		
		try (Connection conn = DbConnection.getConection(); PreparedStatement pst = conn.prepareStatement(query)) {

			pst.setInt(1, bookId);
			pst.setInt(2, userId);
			
			int rows= pst.executeUpdate();
			
			if(rows > 0) {
				ReturnBookRepositoryImpl returnBookRepository= new ReturnBookRepositoryImpl();
				returnBookRepository.returnBook(bookId, userId);
				return true;
			}
			
		}
		return false;
	}

}
