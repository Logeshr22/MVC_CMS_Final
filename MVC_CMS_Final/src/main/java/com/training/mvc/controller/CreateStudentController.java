package com.training.mvc.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.training.mvc.model.Student;

@WebServlet("/AddStudent")
public class CreateStudentController extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();

		
		Student s = new Student();
		
		s.setSid(Integer.parseInt(req.getParameter("Student_id")));
		s.setSname(req.getParameter("Student_name"));
		s.setEmail((req.getParameter("Email")));
		s.setUser_name((req.getParameter("User_Name")));
		s.setSpassword((req.getParameter("student_password")));
		s.setCid(Integer.parseInt(req.getParameter("Course_id")));

		boolean b = s.addstudent();
		if (b == true) {

			session.setAttribute("Course_id", s.getCid());
			session.setAttribute("Student_name", s.getSname());
			session.setAttribute("User_Name", s.getUser_name());
			
//			session.setAttribute("professor_password", crsapp.getPpassword());

			resp.sendRedirect("/MVC_CMS_Final/AddSuccess.html");
		} else {
			resp.sendRedirect("/MVC_CMS_Final/AddFail.html");
		}
	}
}
