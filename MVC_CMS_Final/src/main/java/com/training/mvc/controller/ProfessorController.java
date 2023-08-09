package com.training.mvc.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.training.mvc.model.Professor;
@WebServlet("/ProfessorLogin")

public class ProfessorController extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=req.getSession(true);
		Professor p=new Professor();
		
		p.setPname(req.getParameter("user_name"));
		p.setPpassword(req.getParameter("password"));
		
		boolean b=p.login();
		
		if(b==true) {
			session.setAttribute("pname",p.getPname());
			session.setAttribute("pid", p.getPid());
			session.setAttribute("ppassword",p.getPpassword());
			session.setAttribute("exp",p.getExp());
			session.setAttribute("cid",p.getCid());
			resp.sendRedirect("/MVC_CMS_Final/ProfessorServices.html");	
		}
		else {
			resp.sendRedirect("/MVC_CMS_Final/ProfessorLoginFail.html");
		}
	}

}
