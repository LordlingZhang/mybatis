package sy.service;

import java.util.List;

import sy.model.User;

public interface UserServiceI {

	void insertUser(User user);
	
	User getUser(String id);
	
	List<User> getAll();
}
