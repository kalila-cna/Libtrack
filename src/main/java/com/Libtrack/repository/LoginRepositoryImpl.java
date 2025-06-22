package com.LibTrack.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.LibTrack.dataBase.DbConnection;
import com.LibTrack.interfaces.repository.ILoginRepository;

public class LoginRepositoryImpl implements ILoginRepository {

	@Override
	public String findUserType(String emailId) throws SQLException {
		String userType = null;
		String query = "SELECT * FROM login WHERE email_id = ?";

		try (Connection connection = DbConnection.getConection();
				PreparedStatement pst = connection.prepareStatement(query)) {
			pst.setString(1, emailId.toLowerCase());

			try (ResultSet rs = pst.executeQuery()) {
				if (rs.next()) {
					userType = rs.getString(4);
				}
			}
		}
		return userType;
	}

	@Override
	public boolean passwordMatch(String emailId, String password) throws SQLException {
		String query = "SELECT * FROM login WHERE email_id=?";

		try (Connection connection = DbConnection.getConection();
				PreparedStatement pst = connection.prepareStatement(query)) {
			pst.setString(1, emailId.toLowerCase());

			try (ResultSet rs = pst.executeQuery()) {
				while (rs.next()) {
					PasswordRepositoryImpl passwordRepositoryImpl = new PasswordRepositoryImpl();
					if (passwordRepositoryImpl.checkPassword(rs.getString(3), password)) {
						return true;
					}
				}
			}
		}
		return false;
	}

	@Override
	public boolean alreadyExists(String emailId) throws SQLException {
		String query = "SELECT * FROM login WHERE email_id=?";

		try (Connection connection = DbConnection.getConection();
				PreparedStatement pst = connection.prepareStatement(query);) {
			pst.setString(1, emailId.toLowerCase());

			try (ResultSet rs = pst.executeQuery()) {
				while (rs.next()) {
					if (rs.getString(1) != null) {
						return true;
					}
				}
			}
		}

		return false;
	}

	@Override
	public int findUserIdByEmail(String emailId) throws SQLException {

		String query = "SELECT * FROM login WHERE email_id=?";
		int user_id = 0;

		try (Connection conn = DbConnection.getConection(); PreparedStatement pst = conn.prepareStatement(query)) {

			pst.setString(1, emailId.toLowerCase());

			try (ResultSet rs = pst.executeQuery();) {

				while (rs.next()) {
					user_id = rs.getInt(1);
				}
			}

			return user_id;
		}
	}

}
