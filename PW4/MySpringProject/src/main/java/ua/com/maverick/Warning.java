package ua.com.maverick;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class Warning {

	@Pointcut("execution(* ua.com.maverick.iCar.driverInfo(..))")
	public void driverInfo(){}
	@Pointcut("execution(* ua.com.maverick.Red.drawCar(..))")
	public void drawCar(){}
	
	
	@After("driverInfo()")
	public void warn(){
		System.out.println("Attention! Slippery road!");
	}
	
	@After("drawCar()")
	public void warnAgain(){
		System.out.println("Attention! Slippery road!");
	}
}
