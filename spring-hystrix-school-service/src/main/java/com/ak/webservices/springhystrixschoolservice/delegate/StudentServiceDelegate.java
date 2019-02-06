package com.ak.webservices.springhystrixschoolservice.delegate;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class StudentServiceDelegate {
	
	@Autowired
	RestTemplate restTemplate;
	
	@HystrixCommand(fallbackMethod = "callStudentServiceAndGetData_Fallback")
	public String callStudentServiceAndGetData(String schoolname) {
		String response = restTemplate.exchange("http://student-service/getStudentDetails/{schoolname}",
				HttpMethod.GET,null, new ParameterizedTypeReference<String>() {}, schoolname).getBody();
		System.out.println("Response received as " + response + " - " + new Date());
		
		return "Normal flow - school name " +schoolname + " :: " + "Student Details " + response + "-" + new Date();
	}
	
	@SuppressWarnings("unused")
	private String callStudentServiceAndGetData_Fallback(String schoolname) {
		System.out.println("Service is Down");
		return "Circuit Breaker Enabled!!! No response from student Service at this moment. " + "Service will be back shortly " + new Date();
	}
	
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

}
