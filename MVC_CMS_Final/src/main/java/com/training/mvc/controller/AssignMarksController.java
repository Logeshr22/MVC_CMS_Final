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

@WebServlet("/AssignMarks")
public class AssignMarksController extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=req.getSession();
		Student s=new Student();
		s.setSid(Integer.parseInt(req.getParameter("sid")));
		s.setGrade(req.getParameter("grade"));
		s.setMark(Integer.parseInt(req.getParameter("mark")));
		
		boolean b=s.givemarks();
		
		if(b==true) {
			session.setAttribute("suser",s.getUser_name());
			session.setAttribute("spass",s.getSpassword());
			session.setAttribute("sname",s.getSname());
			session.setAttribute("email",s.getEmail());
			session.setAttribute("cid",s.getCid());
			session.setAttribute("mark",s.getMark());
			session.setAttribute("sid",s.getSid());
			
			resp.sendRedirect("/MVC_CMS_Final/MarkAssignSuccess.html");
			
		}
		else {
			resp.sendRedirect("/MVC_CMS_Final/MarksAssignFailed.html");
		}
	}

}
