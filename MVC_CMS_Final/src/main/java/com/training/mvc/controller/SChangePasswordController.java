package com.training.mvc.controller;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.training.mvc.model.Student;





@WebServlet("/SChangePassword")


public class SChangePasswordController extends HttpServlet {

		@Override
		protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			// TODO Auto-generated method stub
			HttpSession session=req.getSession();
			Student s= new Student();
			String sname=(String) session.getAttribute("sname");
			String spassword=req.getParameter("pass");
			String new_pass=req.getParameter("pass1");
			String confirm_pass=req.getParameter("pass2");
			
			
			s.setSpassword(spassword);
			s.setNew_pass(new_pass);
			s.setConfirm_pass(confirm_pass);
		
			
			boolean b=s.changepassword(sname);
			
			if(b==true) {
				resp.sendRedirect("/MVC_CMS_Final/PasswordChangeSuccessful.html");

			}
			else {
				resp.sendRedirect("/MVC_CMS_Final/PasswordChangeFailed.html");
			}
		}}

