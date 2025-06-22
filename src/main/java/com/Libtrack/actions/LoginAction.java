package com.LibTrack.actions;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.action.SessionAware;
import org.apache.struts2.dispatcher.SessionMap;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.LibTrack.model.User;
import com.LibTrack.repository.LoginRepositoryImpl;
import com.LibTrack.repository.PasswordRepositoryImpl;

public class LoginAction extends ActionSupport implements SessionAware, ModelDriven<User>{
	
	private static final long serialVersionUID = 1L;
	private User user=new User();
	SessionMap sessionmap;
	private int user_id;
	

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	@Override
	public User getModel() {
		return user;
	}
	
	@Override
	public void validate() {
		if (user.getEmailId()== null || user.getEmailId().trim().equals("")) {
			addFieldError("emailId", "Email Id is required");
		} 
		else if (user.getPassword() == null || user.getPassword().trim().equals("")) {
			addFieldError("password", "Password is required");
		} 
		else if ((user.getEmailId() != null || !(user.getEmailId().trim().equals(""))) && (user.getPassword() == null || !(user.getPassword().trim().equals("")))) {
			LoginRepositoryImpl loginrepository =new LoginRepositoryImpl();
			try {
				if (loginrepository.alreadyExists(user.getEmailId()) == false) {
					addFieldError("emailId", "Email Id doesn't exist. Try signing up!");
				} else if (loginrepository.passwordMatch(user.getEmailId(), user.getPassword()) == false) {
					addFieldError("emailId", "Wrong password");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	@Override
	public String execute() {
		LoginRepositoryImpl loginrepository =new LoginRepositoryImpl();
		PasswordRepositoryImpl passwordRepositoryImpl = new PasswordRepositoryImpl();
		String hashedPassword=passwordRepositoryImpl.encodedPassword(user.getPassword());
		user.setPassword(hashedPassword);
		sessionmap.put("userSession", user);
		
		try {
			if(loginrepository.findUserType(user.getEmailId()).equals("admin")) {
				sessionmap.put("userType", "admin");
				return "admin";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			this.user_id=loginrepository.findUserIdByEmail(user.getEmailId());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		sessionmap.put("userType", "student");
		return "student";
	}

	@Override
	public void withSession(Map<String, Object> sessionmap) {
		this.sessionmap=(SessionMap) sessionmap;	
	}


}
