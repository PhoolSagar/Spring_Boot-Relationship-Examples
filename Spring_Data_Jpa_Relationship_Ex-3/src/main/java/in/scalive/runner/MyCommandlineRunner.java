package in.scalive.runner;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import in.scalive.model.Profile;
import in.scalive.model.User;
import in.scalive.service.ProfileService;
import in.scalive.service.UserService;
@Component
public class MyCommandlineRunner implements CommandLineRunner {
	
	@Autowired
	private UserService userServ;
	
	@Autowired
	private ProfileService profileServ;

	@Override
	public void run(String... args) throws Exception {
		
	Optional<User> userResult= userServ.findUserById(1);
	if(userResult.isPresent()) {
		User user = userResult.get();
		System.out.println("userName : "+user.getName());
		System.out.println("userId : "+user.getId());
		System.out.println("profileBio : "+user.getProfile().getBio());
	}
	
	Optional<Profile> profileResult= profileServ.getprofileById(1);
	if(profileResult.isPresent()) {
		Profile profile = profileResult.get();
		System.out.println("Bio : "+profile.getBio());
		System.out.println("profileId : "+profile.getId());
		System.out.println("UserName : "+ profile.getUser().getName());
	}
	 
	}

}
