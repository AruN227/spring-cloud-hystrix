package com.ak.webservices.springhystrixstudentservice.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ak.webservices.springhystrixstudentservice.bean.Student;



@RestController
public class StudentServiceController {

private static Map<String, List<Student>> schoolData = new HashMap<String, List<Student>>(); 
	
	static {
		schoolData = new HashMap<String, List<Student>>();
		
		List<Student> list1 = new ArrayList<Student>();
		Student stu1 = new Student("Arun", "Computer");
		list1.add(stu1);
		stu1 = new Student("Karthik", "Biology");
		list1.add(stu1);
		stu1 = new Student("Selva", "Biology");
		list1.add(stu1);
		
		schoolData.put("boysschool", list1);
		
		list1 = new ArrayList<Student>();
		stu1 = new Student("Jessi", "Computer");
		list1.add(stu1);
		stu1 = new Student("Maya", "Computer");
		list1.add(stu1);
		stu1 = new Student("Nithya", "Biology");
		list1.add(stu1);
		
		schoolData.put("girlsschool", list1);
		
		
	}
	
	@RequestMapping(value = "/getStudentDetails/{schoolname}", method=RequestMethod.GET)
	public List<Student> getStudents(@PathVariable String schoolname) {
	
		System.out.println("Student Details for " +schoolname);
		
		List<Student> detail = schoolData.get(schoolname);
		
		if(detail == null) {
			detail = new ArrayList<Student>();
			Student stu = new Student("Not Found", "N/A");
			detail.add(stu);
			
		}
		return detail;
	}

	
}
