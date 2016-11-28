package sy.serviceImpl;

import java.util.List;

import sy.dao.UserMapper;
import sy.model.User;
import sy.service.UserServiceI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserServiceI{

	private UserMapper userMapper;
	
	public UserMapper getUserMapper() {
		return userMapper;
	}

	@Autowired
	public void setUserMapper(UserMapper userMapper) {
		this.userMapper = userMapper;
	}


	@Override
	public void insertUser(User user) {
		// TODO Auto-generated method stub
		userMapper.insert(user);
	}

	@Override
	public User getUser(String id) {
		// TODO Auto-generated method stub
		User u = userMapper.selectByPrimaryKey(id);
		return u;
	}

	@Override
	public List<User> getAll() {
		// TODO Auto-generated method stub
		List<User> userList = userMapper.getAll();
		return userList;
	}

}
