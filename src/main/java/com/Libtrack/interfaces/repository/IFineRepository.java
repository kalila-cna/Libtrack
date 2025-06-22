package com.LibTrack.interfaces.repository;

import java.sql.SQLException;

public interface IFineRepository {
	
	public boolean payFineByBookId(int userId, int bookId) throws SQLException;

}
