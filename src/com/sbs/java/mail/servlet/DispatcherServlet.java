package com.sbs.java.mail.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sbs.java.mail.service.MailService;

public class DispatcherServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");

		String gmailId = getServletConfig().getInitParameter("gmailId");
		String gmailPw = getServletConfig().getInitParameter("gmailPw");

		MailService mailService = new MailService(gmailId, gmailPw, gmailId, "관리자");
		boolean sendMailDone = mailService.send("rladlfrn22@gmail.com", "안녕하세요.", "반갑습니다.!!") == 1;

		response.getWriter().append(String.format("발송성공 : %b", sendMailDone));
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
