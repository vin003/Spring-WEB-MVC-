package com.durgasoft.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.durgasoft.dao.StudentDao;
import com.durgasoft.dto.Student;



public class CustomerController extends MultiActionController {
/*BeanNameUrlHandlerMapping*/
	/*ParameterizableViewController*/
	private StudentDao stdDao ; 
			
			public void setStdDao(StudentDao stdDao) {
				this.stdDao = stdDao;
			}
	
	
	public ModelAndView add(HttpServletRequest req, HttpServletResponse res) throws Exception
	{		ModelAndView mav = null ; 
			String sid  = req.getParameter("sid");
			String sname = req.getParameter("sname");
			String saddr= req.getParameter("saddr");
	
			Student std2 = new Student();
			
			std2.setSid(sid);
			std2.setSaddr(saddr);
			std2.setSname(sname);
			
			String status = stdDao.addStudent(std2);
		
			
		if (status.equals("success"))
		{
			mav = new ModelAndView("status", "message","Student Inserted successfullly") ; 
		}
		else if ( status.equals("failure"))
		{
			mav=  new ModelAndView("status", "message","Student Insertion failure") ;
		}
		else if ( status.equals("existed"))
		{
			mav=  new ModelAndView("status", "message","Student Existed Already") ;
		}
		
		return mav ; 
	}
	
	
	public ModelAndView search(HttpServletRequest req, HttpServletResponse res) throws Exception
	{
			
		return null ; 
	}
	
	
	public ModelAndView edit(HttpServletRequest req, HttpServletResponse res) throws Exception
	{
		return null ; 
	}
	
	
	public ModelAndView update(HttpServletRequest req, HttpServletResponse res) throws Exception
	{
		return null ; 
	}
	public ModelAndView delete(HttpServletRequest req, HttpServletResponse res) throws Exception
	{
		return null ; 
	}
	
	
}
