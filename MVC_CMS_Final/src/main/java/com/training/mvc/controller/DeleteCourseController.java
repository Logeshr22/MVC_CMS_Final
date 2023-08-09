package com.training.mvc.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.training.mvc.model.Course;

@WebServlet("/DeleteCourse")
public class DeleteCourseController extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		
		Course c= new Course();
		c.setCid(Integer.parseInt(req.getParameter("course_id")));
		boolean b = c.DeleteCourse();
		if (b == true) {

			// session.setAttribute("admin_password",crsapp.getApassword());

			resp.sendRedirect("/MVC_CMS_Final/CourseDeleteSuccess.html");
		} else {
			resp.sendRedirect("/MVC_CMS_Final/DeletionFailed.html");
		}
	}
}
