package spring.hibernate.integration;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import spring.hibernate.integration.model.User;
import spring.hibernate.integration.service.UserService;

public class App 
{
    public static void main( String[] args )
    {
       
    	AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
    	ctx.scan("spring.hibernate.integration");
    	ctx.refresh();
    	
    	UserService userService = ctx.getBean("userService",UserService.class);
    	
    	List<User> users = userService.getAll();
    	
    	for(User user : users){
    		System.out.println(user);
    	}
    	
    	
    }
}
