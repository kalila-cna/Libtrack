package com.LibTrack.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.LibTrack.dataBase.DbConnection;
import com.LibTrack.interfaces.repository.IDefaulterRepository;
import com.LibTrack.model.Defaulter;
import com.LibTrack.model.DefaulterInfoByUserId;

public class DefaulterRepositoryImpl implements IDefaulterRepository{

	@Override
	public List<Defaulter> getAllDefaulters() throws SQLException {
		String query = "SELECT d.defaulter_id, d.student_id, s.name, s.year, s.department, d.book_id, b.book_name, d.overdue_days, d.fine_amount, d.fine_status"
				+ " FROM defaulter d"
				+ " JOIN student s ON d.student_id = s.id"
				+ " JOIN book b ON d.book_id = b.book_id;";
		
		List<Defaulter> defaulterDetails = new ArrayList<>();

		try (Connection conn = DbConnection.getConection(); Statement st = conn.createStatement()) {

			try(ResultSet rs = st.executeQuery(query)){

			while (rs.next()) {
				Defaulter model = new Defaulter();
				model.setDefaulterId(rs.getInt(1));
				model.setStudentId(rs.getInt(2));
				model.setStudentName(rs.getString(3));
				model.setYear(rs.getInt(4));
				model.setDepartment(rs.getString(5));
				model.setBookId(rs.getInt(6));
				model.setBookName(rs.getString(7));
				model.setOverDueDays(rs.getInt(8));
				model.setFineAmount(rs.getDouble(9));
				model.setFineStatus(rs.getString(10));
				
				defaulterDetails.add(model);
			}
			}
		}

		return defaulterDetails;
	}

	@Override
	public List<DefaulterInfoByUserId> getDefaulterDetailsByUserId(int userId) throws SQLException {
		String query = "SELECT d.book_id, b.book_name, d.overdue_days, d.fine_amount"
				+ " FROM defaulter d"
				+ " JOIN student s ON d.student_id = s.id"
				+ " JOIN book b ON d.book_id = b.book_id"
				+ " WHERE s.user_id=? AND d.fine_status = 'unpaid';";
		
		List<DefaulterInfoByUserId> fineDetails = new ArrayList<>();

		try (Connection conn = DbConnection.getConection(); PreparedStatement pst = conn.prepareStatement(query)) {
			
			pst.setInt(1, userId);

			try(ResultSet rs = pst.executeQuery()){

			while (rs.next()) {
				DefaulterInfoByUserId model = new DefaulterInfoByUserId();
				model.setBookId(rs.getInt(1));
				model.setBookName(rs.getString(2));
				model.setOverDueDays(rs.getInt(3));
				model.setFineAmount(rs.getDouble(4));
				
				fineDetails.add(model);
			}
			}
		}

		return fineDetails;
		
	}

}
