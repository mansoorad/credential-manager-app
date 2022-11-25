package com.ty.credential_manager.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ty.credential_manager.dto.User;
import com.ty.credential_manager.service.UserService;





@Controller
public class MainController {

	@Autowired
	UserService serive;
	
	@RequestMapping("login")
	public ModelAndView getIndex() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("login.jsp");
		modelAndView.addObject("user", new User());
		return modelAndView;
	}

	@RequestMapping("signup")
	public ModelAndView getSign() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("signup.jsp");
		modelAndView.addObject("user", new User());
		return modelAndView;
	}
	
//	@RequestMapping("saveuser")
//	public ModelAndView saveStudent(@ModelAttribute User user) {
//
//		service.saveUser(user);
//		ModelAndView modelAndView = new ModelAndView();
//		modelAndView.addObject("user", new User());
//		modelAndView.setViewName("login.jsp");
//		return modelAndView;
//
//	}
//	
//
//	@RequestMapping("loginuser")
//	public ModelAndView loginStudent(@ModelAttribute User user) {
//
//		ModelAndView modelAndView = new ModelAndView();
//		User user2=service.getUserByEmail(user);
//	
//		if (user2!=null) {
//			modelAndView.addObject("name",user2.getName());
//			modelAndView.addObject("slist",service.getAllUser());
//			modelAndView.setViewName("view.jsp");
//
//		} else {
//
//			modelAndView.setViewName("login.jsp");
//		}
//		return modelAndView;
//	}
//	
//	@RequestMapping("view")
//	public ModelAndView viewStudent()
//	{
//		ModelAndView modelAndView = new ModelAndView();
//		modelAndView.addObject("ulist",service.getAllUser());
//		modelAndView.setViewName("view.jsp");
//		return modelAndView;
//		
//	}
//	
//	@RequestMapping("delete")
//	public void deleteUser(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException
//	{
//		int id=Integer.parseInt(req.getParameter("id"));
//		service.deleteStudent(id);
//		RequestDispatcher dispatcher=req.getRequestDispatcher("view");
//		dispatcher.forward(req, resp);
//		
//	}
//	
//	@RequestMapping("edit")
//	public ModelAndView editStudent(@RequestParam int id) 
//	{
//		User user =service.getStudentById(id);
//		ModelAndView modelAndView = new ModelAndView();
//		modelAndView.addObject("user", user);
//		modelAndView.setViewName("edit.jsp");
//		
//		return modelAndView;
//		
//	}
//	
//	@RequestMapping("updatestudent")
//	public void deleteStudent(@ModelAttribute User user,HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException
//	{
//		
//		service.updadteUser(user);
//		RequestDispatcher dispatcher=req.getRequestDispatcher("view");
//		dispatcher.forward(req, resp);
//		
//	}
	


}