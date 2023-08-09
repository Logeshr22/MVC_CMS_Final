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
import com.training.mvc.model.Users;

@WebServlet("/AdLogin")
public class AdminController extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = req.getSession(true);
		Users u = new Users();
		Professor p = new Professor();
		Student s = new Student();
		u.setUser_name(req.getParameter("user_name"));
		u.setPassword(req.getParameter("password"));
		boolean b = u.login();
		if (b == true) {

			session.setAttribute("user_name", u.getUser_name());
			session.setAttribute("password", u.getPassword());
			session.setAttribute("pname",p.getPname());
			session.setAttribute("pid", p.getPid());
			session.setAttribute("ppassword",p.getPpassword());
			session.setAttribute("exp",p.getExp());
			session.setAttribute("cid",p.getCid());
			session.setAttribute("suser",s.getUser_name());
			session.setAttribute("spass",s.getSpassword());
			session.setAttribute("sname",s.getSname());
			session.setAttribute("email",s.getEmail());
			session.setAttribute("cid",s.getCid());
			session.setAttribute("mark",s.getMark());
			session.setAttribute("grade",s.getGrade());			
			session.setAttribute("sid",s.getSid());

			resp.sendRedirect("/MVC_CMS_Final/AdminServices.html");
		} else {
			resp.sendRedirect("/MVC_CMS_Final/AdminLoginFail.html");
		}
	}
}