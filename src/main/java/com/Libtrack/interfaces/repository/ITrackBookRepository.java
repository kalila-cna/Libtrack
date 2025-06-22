package com.LibTrack.interfaces.repository;

import java.sql.SQLException;
import java.util.List;

import com.LibTrack.model.TrackBook;

public interface ITrackBookRepository {
	
	public List<TrackBook> trackBooksByUserId(int userId) throws SQLException;

}
