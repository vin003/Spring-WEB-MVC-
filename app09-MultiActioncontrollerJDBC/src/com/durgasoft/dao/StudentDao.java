package com.durgasoft.dao;

import com.durgasoft.dto.Student;

public interface StudentDao {
	public String addStudent(Student std) ;
	
	public Student searchStudent(String sid) ; 
	public String updateStudent(Student std) ; 
	
	public String deleteStudent(String sid) ; 
	

}
