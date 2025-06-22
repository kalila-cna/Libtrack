package com.LibTrack.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.LibTrack.dataBase.DbConnection;
import com.LibTrack.interfaces.repository.IBookReturnRepository;
import com.LibTrack.model.ReturnBook;

public class ReturnBookRepositoryImpl implements IBookReturnRepository {

	@Override
	public List<ReturnBook> getAllBooksByUserId(int userId) throws SQLException {
		String query = "SELECT  bt.book_id, b.book_name, bt.issue_date, bt.return_date, bt.status  FROM book_transactions bt"
				+ " JOIN book b ON bt.book_id = b.book_id"
				+ " WHERE bt.student_id = (SELECT id FROM student WHERE user_id=?)"
				+ " AND bt.status = 'issued';";
		
		List<ReturnBook> returnBookDetails = new ArrayList<>();
		
		try (Connection conn = DbConnection.getConection(); PreparedStatement pst = conn.prepareStatement(query)) {

			pst.setInt(1, userId);
			try(ResultSet rs = pst.executeQuery();){
			
			while (rs.next()) {
				ReturnBook model = new ReturnBook();
				model.setBookId(rs.getInt(1));
				model.setBookName(rs.getString(2));
				model.setIssueDate(rs.getString(3));
				model.setDueDate(rs.getString(4));
				model.setStatus(rs.getString(5));
				
				returnBookDetails.add(model);
			}
			}
		}
		
		
		return returnBookDetails;
		
	}

	@Override
	public boolean returnBook(int bookId, int userId) throws SQLException {
		
		String query = "UPDATE book_transactions"
				+ " SET status = 'returned', actual_return_date = CURDATE()"
				+ " WHERE book_id = ?"
				+ " AND student_id = (SELECT id FROM student WHERE user_id = ?);";
		
		try (Connection conn = DbConnection.getConection(); PreparedStatement pst = conn.prepareStatement(query)) {

			pst.setInt(1, bookId);
			pst.setInt(2, userId);
			
			int rows= pst.executeUpdate();
			
			if(rows > 0) return true;
			
		}
		
		
		return false;
		
	}

}
