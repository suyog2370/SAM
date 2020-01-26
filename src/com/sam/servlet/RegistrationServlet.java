package com.sam.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sam.service.SamService;
import com.sam.tables.User;

public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger LOG = LoggerFactory.getLogger(RegistrationServlet.class);

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		SamService samService = new SamService();
		PrintWriter out = response.getWriter();
		try {
			User user = new User();
			user.setName(request.getParameter("name"));
			user.setEmail(request.getParameter("email"));
			user.setMobileNo(Long.parseLong(request.getParameter("mobileNo")));
			if (samService.checkUserExist(user)) {
				samService.register(user);
				response.sendRedirect(request.getContextPath() + "/login-options.html");
			} else {
				response.setContentType("text/html");
				out.println("<center><h2 style=color:red> Mobile No or Email already exist in System !!</h2></center>");
				out.println("<center><a href=registration.html>Click here to go to Registration page.</a></center>");
			}
		} catch (Exception e) {
			LOG.error("Exception {}", e);
		}
	}
}