package com.training.mvc.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.training.mvc.model.Course;

@WebServlet("/AddCourse")
public class CreateCourseController extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();

		Course c= new Course();
		
		c.setCid(Integer.parseInt(req.getParameter("Course_id")));
		c.setCname(req.getParameter("Course_name"));
		c.setFees(Integer.parseInt(req.getParameter("Course_fees")));
		c.setDur_months(Integer.parseInt(req.getParameter("Course_duration")));
		
		boolean b = c.AddCourse();
		if (b == true) {

			session.setAttribute("Course_id", c.getCid());
			session.setAttribute("Course_name", c.getCname());
			session.setAttribute("Course_fees", c.getFees());
			session.setAttribute("Course_duration", c.getDur_months());
//			session.setAttribute("professor_password", crsapp.getPpassword());

			resp.sendRedirect("/MVC_CMS_Final/AddSuccess.html");
		} else {
			resp.sendRedirect("/MVC_CMS_Final/AddFail.html");
		}
	}
}
