package com.LibTrack.actions.json;

import java.sql.SQLException;
import java.util.List;

import com.LibTrack.model.Defaulter;
import com.LibTrack.repository.DefaulterRepositoryImpl;
import com.opensymphony.xwork2.ActionSupport;

public class DefaulterJson extends ActionSupport{

	private static final long serialVersionUID = 1L;
	
	private List<Defaulter> defaulterDetails;

	public List<Defaulter> getDefaulterDetails() {
		return defaulterDetails;
	}

	public void setDefaulterDetails(List<Defaulter> defaulterDetails) {
		this.defaulterDetails = defaulterDetails;
	}
	
	@Override
	public String execute() {
		DefaulterRepositoryImpl defaulterRepository= new DefaulterRepositoryImpl();
		try {
			this.defaulterDetails=defaulterRepository.getAllDefaulters();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}

}
