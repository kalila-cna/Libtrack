package com.LibTrack.interceptor;

import java.util.Map;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class SessionValidationInterceptor implements Interceptor {

	private static final long serialVersionUID = 1L;

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void init() {
		// TODO Auto-generated method stub

	}

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		Map<String, Object> session = invocation.getInvocationContext().getSession();

		Object user = session.get("userSession");
		Object userType = session.get("userType");
		String actionName = invocation.getProxy().getActionName();

		if (user == null || userType == null) {
			return "login";
		}
		
		if ("admin".equals(userType)) {
			if (!isAdminAction(actionName)) {
				return "accessDenied";
			}
		} else if ("student".equals(userType)) {
			if (!isStudentAction(actionName)) {
				return "accessDenied";
			}
		}

		return invocation.invoke();
	}

	private boolean isAdminAction(String actionName) {
		return actionName.equals("adminDashboard") || actionName.equals("adminSettings")
				|| actionName.equals("addbookbtn") || actionName.equals("editbookbtn")
				|| actionName.equals("viewstudentsbtn") || actionName.equals("back") 
				|| actionName.equals("viewDefaulterbtn");
	}

	private boolean isStudentAction(String actionName) {
		return actionName.equals("studentDashboard") || actionName.equals("studentProfile")
				|| actionName.equals("backToStudentDashboard") || actionName.equals("availbooksbtn")
				|| actionName.equals("returnbookbtn") || actionName.equals("trackbookbtn")
				|| actionName.equals("viewFinebtn");
	}

}
