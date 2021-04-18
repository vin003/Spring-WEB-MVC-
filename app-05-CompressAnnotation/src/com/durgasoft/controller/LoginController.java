package com.durgasoft.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Controller
public class LoginController {
	
	
	/*InternalResourceViewResolver*/
	@RequestMapping("/loginpage")
	public ModelAndView login()
	{
		return new ModelAndView("loginform");
	}
	
	
@RequestMapping("/login")	
 public ModelAndView login(HttpServletRequest req, HttpServletResponse res)
 {
	 String uname = req.getParameter("uname");
	 String upwd = req.getParameter("upwd") ; 
	 
	 if(uname.equals("durga") && upwd.equals("durga"))
	 {
		 return  new ModelAndView("success");	 
	 }
	 else
	 {
		 return  new ModelAndView("failure");
	 }
	 
	
	 
 }

}
