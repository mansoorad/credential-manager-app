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

import com.ty.credential_manager.dto.Admin;
import com.ty.credential_manager.dto.User;
import com.ty.credential_manager.service.AdminService;
import com.ty.credential_manager.service.ApplicationService;
import com.ty.credential_manager.service.UserService;

@Controller
public class MainController {

	@Autowired
	UserService userService;
	@Autowired
	AdminService adminService;
	@Autowired
	ApplicationService applicationService;
	
	@RequestMapping("usersignup")
	public ModelAndView getSign() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("usersignup.jsp");
		modelAndView.addObject("user", new User());
		return modelAndView;
	}
	@RequestMapping("saveuser")
	public ModelAndView saveStudent(@ModelAttribute User user) {
		userService.saveUser(user);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("userlogin.jsp");
		modelAndView.addObject("user", new User());
		return modelAndView;
	}
	
//	@RequestMapping("application")
//	public ModelAndView getApplication() {
//		ModelAndView modelAndView = new ModelAndView();
//		modelAndView.setViewName("application.jsp");
//		modelAndView.addObject("application", new Application());
//		return modelAndView;
//	}
	
//	@RequestMapping("saveapplication")
//	public ModelAndView saveApplication(@ModelAttribute Application application) {
//		applicationService.saveApplication(application);
//		ModelAndView modelAndView = new ModelAndView();
//		modelAndView.setViewName("userlogin.jsp");
//		modelAndView.addObject("user", new User() );
//		return modelAndView;
//		
//	}
	
//	@RequestMapping("userview")
//	public ModelAndView getUser(@ModelAttribute User user) {
//		userService.getUserByName(user);
//		ModelAndView modelAndView = new ModelAndView();
//		modelAndView.setViewName("userview.jsp");
//		modelAndView.addObject("user", new User());
//		return modelAndView;
//	}
	//up to userview done
	
	@RequestMapping("userlogin")
	public ModelAndView getIndex() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("userlogin.jsp");
		modelAndView.addObject("user", new User());
		return modelAndView;
	}
	
	@RequestMapping("savelogin")
	public ModelAndView saveLogIn(@ModelAttribute User user) {
		ModelAndView modelAndView = new ModelAndView();
		User user2=userService.getUserByName(user);
		if(user!=null) {
		modelAndView.setViewName("userview");
		}else {
			modelAndView.setViewName("userlogin.jsp");
		}
		return modelAndView;
	}
	
	@RequestMapping("userview")
	public ModelAndView loginStudent() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("ulist",userService.getAllUser());
		modelAndView.setViewName("userview.jsp");
		return modelAndView;
	}
	
	@RequestMapping("view")
	public ModelAndView viewStudent(int id)
	{
		ModelAndView modelAndView = new ModelAndView();
		User user1 = userService.getUserById(id);
		modelAndView.addObject("user1",user1);
		modelAndView.setViewName("view.jsp");
		return modelAndView;
		
	}
	
	@RequestMapping("delete")
	public void deleteUser(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException
	{
		int id=Integer.parseInt(req.getParameter("id"));
		userService.deleteUser(id);
		RequestDispatcher dispatcher=req.getRequestDispatcher("userview");
		dispatcher.forward(req, resp);
    }
	
//	@RequestMapping("userview")
//	public ModelAndView viewStudent() {
//		ModelAndView modelAndView = new ModelAndView();
//		modelAndView.addObject("ulist", userService.getAllUser());
//		modelAndView.setViewName("userview.jsp");
//		return modelAndView;
//	}
//	
//	@RequestMapping("delete")
//	public void deleteUser(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException
//	{
//		int id=Integer.parseInt(req.getParameter("id"));
//		userService.deleteUser(id);
//		RequestDispatcher dispatcher=req.getRequestDispatcher("userview");
//		dispatcher.forward(req, resp);
//		
//	}
//	
	@RequestMapping("edit")
	public ModelAndView editStudent(@RequestParam int id) 
	{
		User user =userService.getUserById(id);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("user", user);
		modelAndView.setViewName("edit.jsp");
		
		return modelAndView;
		
	}
	
	@RequestMapping("updateUser")
	public void deleteStudent(@ModelAttribute User user,HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException
	{
		
		userService.updateUser(user);
		RequestDispatcher dispatcher=req.getRequestDispatcher("userview");
		dispatcher.forward(req, resp);
		
	}
	


}