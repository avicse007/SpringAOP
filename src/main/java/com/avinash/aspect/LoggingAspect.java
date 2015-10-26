package com.avinash.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LoggingAspect {
	
	
	
	@Pointcut("execution(public * get*())")
	public void allGetters(){}
	
	
	/**@Before("execution(public String getName())")
	 * Now this annptation tells the spring that this aspect method is to 
	 * be executed before the execution of the getName() method ,no matters to 
	 * which class this methods belong
	 * 
	*/
	
	/**To specify the particular class we have following signature 
	@Before("execution(public String com.avinash.model.Circle.getName())")
	*/
	/**To make this Advice execution more generic we can use wild entries.
	*For example we wish to execute this method for every method that 
	*starts with get and return any value. We have following signature.
	*@Before("execution(public * get*())")
	*/
	//Now in case you have defined a PointCut you can use that
	//@Before("allGetters()")
	//You can use two point cuts together by using and operator
	@Before("allGetters() && loggingCircleAdvicePointcut()")
	public void loggingAdvice(){
		System.out.println("Advice is called .Getmethod is called. ");
		
	}
	//@Before("execution(public * get*())")
	@Before("allGetters()")
	//you can use JointPoints to get info of the message that has triggered 
	//the Aspects
	
	public void loggingAdvice2(JoinPoint joinPoint){
		System.out.println("Second LoggingAdvice is exected .Getmethod is called. ");
		System.out.println("This aspect has been triggerd by "+joinPoint.getTarget());
	}
	@Before("loggingCircleAdvicePointcut()")
	public void loggingCircleAdvice(){
		System.out.println("Advice for circle methods");
	}
	
	//@Pointcut("execution(* *com.avinash.model.Circle.*(..))")
	//Another way to do the same
	@Pointcut("within(com.avinash.model.Circle)")
	public void loggingCircleAdvicePointcut(){}
	
	//You can have an aspect that runs or do some pre processing on the method call
	//that have an specific type of arguments.We will see one of that type here
	@Before("args(name)")
	public void loggingAdviceWithArgument(String name){
		System.out.println("Advice for methods called with argument of type String and have value :"+name);
	}
	
	

}
