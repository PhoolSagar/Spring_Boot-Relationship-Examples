package in.scalive.runner;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.util.SystemPropertyUtils;

import in.scalive.model.User;
import in.scalive.service.UserService;
@Component
public class MyCommandlineRunner implements CommandLineRunner {
	
	@Autowired
	private UserService serv;

	@Override
	public void run(String... args) throws Exception {
		
	 User user = serv.findStudentWithProfile("Sagar", "SDE-1");
	 System.out.println("User created with ID : " +user.getId());
	 
	 Optional<User> result = serv.findUserById(user.getId());
	 if(result.isPresent()) {
		 User retrivedUser = result.get();
		 System.out.println("User name : "+ retrivedUser.getName());
		 System.out.println("User profile : "+retrivedUser.getProfile().getBio());
	 }else {
		 System.out.println("User not found");
	 }
	 
	 
	 
	}

}
