package com.project.withus.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.withus.model.UserDto;
import com.project.withus.model.mapper.UserMapper;

@Service
public class UserServiceImpl implements UserService {

	
	@Autowired
	private UserMapper userMapper;
	
	@Override
	public boolean insertUser(UserDto userDto) throws Exception{
		return userMapper.insertUser(userDto) == 1;
	}

	@Override
	public UserDto login(UserDto userDto) throws Exception {
		return userMapper.login(userDto);
	}

	@Override
	public UserDto getUserInfo(String userId) {
		return userMapper.getUserInfo(userId);
	};
	
	@Override
	@Transactional
	public boolean modifyUser(UserDto userDto) throws Exception {
		return userMapper.updateUser(userDto);
	}
}
