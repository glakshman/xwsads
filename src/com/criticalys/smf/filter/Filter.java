package com.criticalys.smf.filter;

import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class Filter
 */
public class Filter implements javax.servlet.Filter {

	/**
	 * Default constructor.
	 */
	public Filter() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {

		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;
		String reqURI = request.getRequestURI();

		System.out.println("req URI in the filter " + reqURI);
		if (reqURI.equals("/smf/")) {
			// check for session , if session does not exist redirect to login
			// page
			HttpSession session = request.getSession(false);
			if (session == null) {
				request.getRequestDispatcher("jsp/index.jsp").forward(request,
						response);
				System.out.println("session in null");
			} else {
				System.out.println("Session already exists");
				request.getRequestDispatcher("jsp/home.jsp").forward(request,
						response);
			}	
		} else if (reqURI.endsWith(".jsp")) {
			String jspPage = null;
			int index = reqURI.lastIndexOf("/");
			String uri = "jsp/" + reqURI.substring(index + 1);
			request.getRequestDispatcher(uri).forward(request, response);
		} else
			chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}
}
