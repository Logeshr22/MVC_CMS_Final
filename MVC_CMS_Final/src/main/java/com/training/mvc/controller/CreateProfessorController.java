package com.training.mvc.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.training.mvc.model.Professor;

@WebServlet("/AddProfessor")
public class CreateProfessorController extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession(true);
		Professor p = new Professor();
		p.setPid(Integer.parseInt(req.getParameter("Professor_id")));
		p.setPname(req.getParameter("Professor_name"));
		p.setExp(Integer.parseInt(req.getParameter("Experience")));
		p.setPpassword((req.getParameter("Password")));
		p.setCid(Integer.parseInt(req.getParameter("Course_id")));
		boolean b = p.AddProfessor();
		if (b == true) {
			session.setAttribute("Course_id", p.getCid());
			resp.sendRedirect("/MVC_CMS_Final/AddSuccess.html");
		} else {
			resp.sendRedirect("/MVC_CMS_Final/Addfail.html");
		}
	}
}
