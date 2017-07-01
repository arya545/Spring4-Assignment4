package com.acad.spring4Assignment4;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	
	public static void main(String[] args)
	{
		ApplicationContext context=new ClassPathXmlApplicationContext("Spring-Employee.xml");
		EmployeeDao edao=(EmployeeDao) context.getBean("empdao");
		List<Employee> employees=edao.getAllEmployees();
		//employees=edao.getAllEmployees();
		for (Employee e : employees)
		{
			System.out.println(e);
		}
		
	}

}
