package in.scalive.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.scalive.model.Profile;
import in.scalive.model.User;
import in.scalive.repository.UserRepository;

@Service
public class UserService  {
	private UserRepository repo;

	@Autowired
	public UserService(UserRepository repo) {
		this.repo = repo;
	}
	
	public User findStudentWithProfile(String name, String bio){
		User user = new User(name);
		Profile profile = new Profile(bio);
		user.setProfile(profile);
		return repo.save(user);
	}
	
	public Optional<User> findUserById(Integer id){
		return repo.findById(id);
	}
	
	

	public boolean updateUserNameAndProfileBio(int userId, String userName, String profileBio) {
		Optional<User> result = repo.findById(userId);
		if(!result.isPresent()) {
			return false;
		}
		User user = result.get();
		user.setName(userName);
		user.getProfile().setBio(profileBio);
		repo.save(user);
		return true;
	}
	
	

}
