package com.criticalys.smf;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.startup.HomesUserDatabase;
import org.json.simple.JSONObject;

import com.criticalys.smf.action.InsertActionHandler;
import com.criticalys.smf.action.LoginActionHandler;

/**
 * Servlet implementation class Main
 */
public class Main extends HttpServlet {
	// private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Main() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// Initialization comes here like db connections
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// Ojbects cleanup comes here
	}

	/**
	 * This method checks for any "action" parameter in the request Based on the
	 * parameter delegates the control to appropriate action handler which can
	 * return the jsp page If no action parameter is specified home.jsp is
	 * dispatched if jsp is specified that jsp page is dispatched
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String action = request.getParameter("action");
		boolean status = false;
		try {

			if (action == null) {

				// If session exists dispatch home page, otherwise dispatch
				// login page ..

				HttpSession session = request.getSession(false);
				if (session == null) {
					request.getRequestDispatcher("jsp/index.jsp").forward(
							request, response);
				} else {
					request.getRequestDispatcher("jsp/home.jsp").forward(
							request, response);
				}

			} else if ("login".equals(action)) {
				LoginActionHandler handler = new LoginActionHandler();

				status = handler.doAction(request, response);
				if (status == true) {
					dispatchJSP(request, response, "jsp/home.jsp");
				}
			} else if ("uploadExcel".equals(action)) {
				// Invoke Action handler for inserting announcements into db
				System.out.println(request.getParameterNames());
				UploadExcelHandler handler = new UploadExcelHandler();
				status = handler.doAction(request, response);
				// Code for dispatching to some other jsp page based on status

				if (status == true) {
					dispatchJSP(request, response, "jsp/home.jsp");
				} else { // dispatch error page
					dispatchJSP(request, response, "jsp/error.jsp");
				}

				// Code for sending response to ajax requests
				// we will send response or dispatch some jsp page , only one
				// thing per a request
				// JSONObject data = new JSONObject();
				// data.put("name", "Lakshman");
				// System.out.println(data.toJSONString());
				// response.setContentType("application/json");
				// response.getWriter().println(data.toJSONString());
			}
		} catch (Exception e) {
			e.printStackTrace();
			response.getWriter().println("Server side exception " + e);
			response.getWriter().println("Pls check server logs ");
		}
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	private void dispatchJSP(HttpServletRequest request,
			HttpServletResponse response, String page) throws ServletException,
			IOException {
		request.getRequestDispatcher(page).forward(request, response);
	}

}
