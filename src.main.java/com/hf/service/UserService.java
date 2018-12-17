package com.hf.service;
 
import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hf.dao.UserMapper;
import com.hf.entity.User;

@Service//需要添加注解，否则无法找到UserService.java类
public class UserService {
	@Autowired
	private UserMapper userMapper;
	
	public List<User> findAll(){
		return userMapper.findAll();
	}
	
	public User findById(int id) {
		return userMapper.findById(id);
	}
	
	public int insert(String name) {
		return userMapper.insert(name);
	}
	
	public int update(User user) {
		return userMapper.update(user);
	}
	
	public int delete(int id) {
		return userMapper.delete(id);
	}
}
