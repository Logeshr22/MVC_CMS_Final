package com.training.mvc.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.training.mvc.model.Professor;
import com.training.mvc.model.Student;
@WebServlet("/StudentLogin")

public class StudentController extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=req.getSession(true);
		Student s=new Student();
	
		s.setUser_name(req.getParameter("user_name"));
		s.setSpassword(req.getParameter("password"));
		
		boolean b=s.login();
		
		if(b==true) {
			session.setAttribute("suser",s.getUser_name());
			session.setAttribute("spass",s.getSpassword());
			session.setAttribute("sname",s.getSname());
			session.setAttribute("email",s.getEmail());
			session.setAttribute("cid",s.getCid());
			session.setAttribute("mark",s.getMark());
			session.setAttribute("grade",s.getGrade());			
			session.setAttribute("sid",s.getSid());
			resp.sendRedirect("/MVC_CMS_Final/StudentPage.html");
		}
		else {
			resp.sendRedirect("/MVC_CMS_Final/StudentLoginFail.html");
		}
	}

}
