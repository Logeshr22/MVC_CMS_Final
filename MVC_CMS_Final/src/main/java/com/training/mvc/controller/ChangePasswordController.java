package com.training.mvc.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.training.mvc.model.Professor;

@WebServlet("/ChangePassword")

public class ChangePasswordController extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = req.getSession();
		Professor p = new Professor();
		String pname = (String) session.getAttribute("P_User_name");
		String ppassword = req.getParameter("pass");
		String new_pass = req.getParameter("pass1");
		String confirm_pass = req.getParameter("pass2");

		p.setPpassword(ppassword);
		p.setNew_pass(new_pass);
		p.setConfirm_pass(confirm_pass);

		boolean b = p.changepassword(pname);

		if (b == true) {
			resp.sendRedirect("/MVC_CMS_Final/PasswordChangeSuccessful.html");

		} else {
			resp.sendRedirect("/MVC_CMS_Final/PasswordChangeFailed.html");
		}
	}
}
