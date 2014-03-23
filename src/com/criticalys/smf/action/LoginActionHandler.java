package com.criticalys.smf.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginActionHandler {

	public boolean doAction(HttpServletRequest request,
			HttpServletResponse response) {
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println(username + " and "+ password);
		
		
		request.setAttribute("user", "Lakshman");
		return true;
	}

}
