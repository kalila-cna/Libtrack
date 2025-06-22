package com.LibTrack.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.LibTrack.dataBase.DbConnection;
import com.LibTrack.interfaces.repository.IBookAvailRepository;

public class BookAvailRepositoryImpl implements IBookAvailRepository {

	@Override
	public boolean availBook(int userId, int bookId) throws SQLException {

		String query = "INSERT INTO book_transactions (book_id, student_id, issue_date, return_date, status)"
				+ " SELECT ?, s.id, CURDATE(), DATE_ADD(CURDATE(),INTERVAL 7 DAY),'issued'"
				+ " FROM student AS s WHERE s.user_id = ?;";

		try (Connection conn = DbConnection.getConection(); PreparedStatement pst = conn.prepareStatement(query)) {

			pst.setInt(1, bookId);
			pst.setInt(2, userId);

			int rows = pst.executeUpdate();

			if (rows > 0)
				return true;
			
			return false;
		}

	}

	@Override
	public boolean alreadyAvailed(int userId, int bookId) throws SQLException {
		String query = "SELECT * FROM book_transactions"
				+ " WHERE book_id= ?"
				+ " AND student_id= (SELECT id FROM student WHERE user_id=?)"
				+ " AND status != 'returned';";

		try (Connection conn = DbConnection.getConection(); PreparedStatement pst = conn.prepareStatement(query)) {

			pst.setInt(1, bookId);
			pst.setInt(2, userId);
			
			try(ResultSet rs = pst.executeQuery();){
			
			if (rs.next())
				return true;
			}
			
			return false;
		}
	}

}
