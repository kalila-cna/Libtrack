package com.LibTrack.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.LibTrack.dataBase.DbConnection;
import com.LibTrack.interfaces.repository.ITrackBookRepository;
import com.LibTrack.model.TrackBook;

public class TrackBookRepositoryImpl implements ITrackBookRepository{

	@Override
	public List<TrackBook> trackBooksByUserId(int userId) throws SQLException {
		String query = "SELECT bt.book_id, b.book_name, bt.issue_date, bt.return_date, bt.actual_return_date, bt.status"
				+ " FROM book_transactions bt"
				+ " JOIN book b ON"
				+ " bt.book_id = b.book_id"
				+ " WHERE bt.student_id = (SELECT id FROM student WHERE user_id=?) ;";
		
		List<TrackBook> trackBookDetails = new ArrayList<>();
		
		try (Connection conn = DbConnection.getConection(); PreparedStatement pst = conn.prepareStatement(query)) {

			pst.setInt(1, userId);
			try(ResultSet rs = pst.executeQuery();){
			

			while (rs.next()) {
				TrackBook model = new TrackBook();
				model.setBookId(rs.getInt(1));
				model.setBookName(rs.getString(2));
				model.setIssueDate(rs.getString(3));
				model.setDueDate(rs.getString(4));
				if(rs.getString(5) != null) {
				model.setReturnDate(rs.getString(5));
				}
				else {
					model.setReturnDate("---");
				}
				model.setStatus(rs.getString(6));
			
				
				trackBookDetails.add(model);
			}
			}
		}
		return trackBookDetails;
	}

}
