package com.criticalys.smf;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UploadExcelHandler {

	public boolean doAction(HttpServletRequest request,
			HttpServletResponse response) {
		
		String excelTitle = request.getParameter("excelTitle");
		String excelDescription = request.getParameter("excelDescription");
		String test = request.getParameter("test");
		System.out.println(excelTitle);
		System.out.println(excelDescription);
		System.out.println(test);
		
		
		// Code for Storing the excel sheet comes here
		
		return true;
	}

}
