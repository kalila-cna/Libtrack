package com.LibTrack.actions.json;

import java.sql.SQLException;
import java.util.List;

import com.LibTrack.model.TrackBook;
import com.LibTrack.repository.TrackBookRepositoryImpl;
import com.opensymphony.xwork2.ActionSupport;

public class TrackBookJson extends ActionSupport{
	
	private static final long serialVersionUID = 1L;
	int userId;
	List<TrackBook> trackBookDetails;
	
	
	public List<TrackBook> getTrackBookDetails() {
		return trackBookDetails;
	}
	public void setTrackBookDetails(List<TrackBook> trackBookDetails) {
		this.trackBookDetails = trackBookDetails;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	@Override
	public String execute() {
		TrackBookRepositoryImpl trackBookRepositoryImpl= new TrackBookRepositoryImpl();
		try {
			this.trackBookDetails=trackBookRepositoryImpl.trackBooksByUserId(userId);
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		return SUCCESS;
	}

}
