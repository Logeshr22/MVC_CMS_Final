package com.training.mvc.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.training.mvc.model.Student;

@WebServlet("/DeleteStudent")
public class DeleteStudentController extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		Student s= new Student();
		//crsapp.setSid(Integer.parseInt(req.getParameter("stud_id")));
		boolean b = s.DeleteStudent(Integer.parseInt(req.getParameter("stud_id")));
		if (b == true) {

			// session.setAttribute("admin_password",crsapp.getApassword());

			resp.sendRedirect("/MVC_CMS_Final/StudentDeleteSuccess.html");
		} else {
			resp.sendRedirect("/MVC_CMS_Final/Deletion Failed.html");
		}
	}
}
