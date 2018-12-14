package app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.daos.UserMapper;
import app.models.User;

@Service
public class UsersService {
	
	@Autowired
	UserMapper userMapper;

	public User getUserById(Integer id) {
		return userMapper.selectByPrimaryKey(id);
	}

	public List<User> getUsers() {
		return userMapper.selectByExample(null);
	}

	public Integer createUser(User user) {
		return userMapper.insert(user);
	}

	public Integer updateUser(User user) {
		return userMapper.updateByPrimaryKey(user);
	}

	public void deleteById(Integer id) {
		userMapper.deleteByPrimaryKey(id);
	}

	public User getUserByEmail(String principal) {
		return userMapper.selectByEmail(principal);
	}

	public User insert(User user) {
		userMapper.insert(user);
		return user;
	}

	public User insertSelective(User user) {
		userMapper.insertSelective(user);
		return user;
	}

}
