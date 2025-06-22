package com.LibTrack.actions;

import java.util.Map;

import org.apache.struts2.action.SessionAware;
import org.apache.struts2.dispatcher.SessionMap;

import com.opensymphony.xwork2.ActionSupport;

public class LogoutAction extends ActionSupport implements SessionAware {
	private static final long serialVersionUID = 1L;
	SessionMap sessionmap;

	@Override
	public String execute() {
		if (sessionmap != null) {
			sessionmap.clear();
		}

		addActionMessage("You have successfully logged out.");
		return SUCCESS;
	}

	@Override
	public void withSession(Map<String, Object> sessionmap) {
		this.sessionmap = (SessionMap) sessionmap;
	}

}
