package ua.com.maverick;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class Main 
{
    public static void main( String[] args )
    {
    	ApplicationContext context = new ClassPathXmlApplicationContext("SpringBean.xml");
    	iCar taxi = (iCar) context.getBean("taxist");
    	taxi.driverInfo();
    	taxi.drive();
    }
}
