package com.sam.servlet;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.service.email.EmailDetails;
import com.service.email.EmailService;

public class GenerateOTPForEmailLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String otp = request.getParameter("otp");
		String email = request.getParameter("email");
		EmailService emailService = new EmailService();
		// Please set the properties from the following path
		String filePath = "D:\\eclipse-oxygen-workspace\\sam\\src\\email.properties";
		emailService.load(new File(filePath));
		EmailDetails emailDetails = new EmailDetails();
		emailDetails.setBody("Your OTP for SAM is " + otp);
		emailDetails.setTo(email);
		// emailService.sendEmail(emailDetails);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
