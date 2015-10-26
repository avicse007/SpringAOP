package com.avinash.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.avinash.service.ShapeService;

public class AOpMain {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
		//this getBean method automatically cast the returned Object 
		ShapeService shapeService = ctx.getBean("shapeService",ShapeService.class);
		shapeService.getCircle().setName("Avinash Circle");
		System.out.println(shapeService.getCircle().getName());
		//System.out.println(shapeService.getTriangle().getName());
	}

}
