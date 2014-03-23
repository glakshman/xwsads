package com.criticalys.smf.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InsertActionHandler {

	public boolean doAction(HttpServletRequest request,
			HttpServletResponse response) {
		// Code for inserting announcement into DB comes here
		System.out.println(request.getParameter("announcement_id"));
		System.out.println(request.getParameter("notice_identifier"));
		System.out.println(request.getParameter("announcement"));

		// return status for the action
		return true;
	}

}
