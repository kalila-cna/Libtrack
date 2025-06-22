package com.LibTrack.actions.json;

import java.sql.SQLException;
import java.util.List;

import com.LibTrack.model.DefaulterInfoByUserId;
import com.LibTrack.repository.DefaulterRepositoryImpl;
import com.opensymphony.xwork2.ActionSupport;

public class ViewFinesJson extends ActionSupport{
	
	private static final long serialVersionUID = 1L;
	private int userId;
	private List<DefaulterInfoByUserId> fineDetails;
	
	
	public List<DefaulterInfoByUserId> getFineDetails() {
		return fineDetails;
	}
	public void setFineDetails(List<DefaulterInfoByUserId> fineDetails) {
		this.fineDetails = fineDetails;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	
	
	@Override
	public String execute() {
		DefaulterRepositoryImpl defaulterRepository= new DefaulterRepositoryImpl();
		try {
			this.fineDetails=defaulterRepository.getDefaulterDetailsByUserId(userId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return SUCCESS;
	}
	

}
