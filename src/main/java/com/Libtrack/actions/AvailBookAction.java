package com.LibTrack.actions;

import com.opensymphony.xwork2.ActionSupport;

public class AvailBookAction extends ActionSupport{

	private static final long serialVersionUID = 1L;
	private int userId;
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	@Override
	public String execute() {
		return SUCCESS;
	}
}
