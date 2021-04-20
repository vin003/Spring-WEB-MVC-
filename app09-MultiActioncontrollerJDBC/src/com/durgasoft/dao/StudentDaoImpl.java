package com.durgasoft.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.durgasoft.dto.Student;

public class StudentDaoImpl implements StudentDao {

	 private JdbcTemplate jdbcTemplate; 
	 
	 
	 public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	 
	@Override
	public String addStudent(Student std) {
		String status="";
		
		String query="select * from student where SID='"+std.getSid()+"'";
		List<Student> list =jdbcTemplate.query(query, (rs, index) -> {
			Student std1 = new Student() ;
			std1.setSid(rs.getString("SID"));
			std1.setSname(rs.getString("SNAME"));
			std1.setSaddr(rs.getString("SADDR"));
			
			return std1 ; 
		} ) ;
		
		if (list.isEmpty())
		{
			String query2="insert into student values('"+std.getSid()+"','"+std.getSname()+"','"+std.getSaddr()+"' )"  ;
			int rowCount= jdbcTemplate.update(query2);
			if (rowCount == 1)
			{
				status="success";
			}
		
			else
			{
				status="failure";
			}
			
		}
		else
		{
			status ="existed";
		}
		
		
		return status;
	}

	@Override
	public Student searchStudent(String sid) {
		
		return null;
	}

	@Override
	public String updateStudent(Student std) {
		
		return null;
	}

	@Override
	public String deleteStudent(String sid) {
		
		return null;
	}

}
