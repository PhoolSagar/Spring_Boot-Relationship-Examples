package in.scalive.runner;

import java.util.Optional;

import javax.print.ServiceUI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import in.scalive.model.Profile;
import in.scalive.model.User;

import in.scalive.service.UserService;

@Component
public class MyCommandlineRunner implements CommandLineRunner {
	
	@Autowired
	private UserService userServ;
	
	

	@Override
	public void run(String... args) throws Exception {
		
	boolean result = userServ.updateUserNameAndProfileBio(1, "Phoolsagar", "FullStackDev.");
	if(result) {
		Optional<User> user = userServ.findUserById(1);
		User userDetail =  user.get();
		System.out.println("UserId : "+ userDetail.getId());
		System.out.println("UserName : "+ userDetail.getName());
		System.out.println("ProfileBio : "+ userDetail.getProfile().getBio());
	}else {
		System.out.println("Record not updated");
	}
	 
	}

}
