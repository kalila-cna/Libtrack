package com.LibTrack.interfaces.repository;

import java.sql.SQLException;
import java.util.List;

import com.LibTrack.model.Defaulter;
import com.LibTrack.model.DefaulterInfoByUserId;

public interface IDefaulterRepository {
	
	public List<Defaulter> getAllDefaulters() throws SQLException;
	public List<DefaulterInfoByUserId> getDefaulterDetailsByUserId(int userId) throws SQLException;

}
