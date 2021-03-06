package com.project.withus.model.service;

import com.project.withus.model.UserDto;

public interface UserService {

	boolean insertUser(UserDto userDto) throws Exception;
	public UserDto login(UserDto userDto) throws Exception;
	UserDto getUserInfo(String userId);
	public boolean modifyUser(UserDto userDto) throws Exception;
	public UserDto getUser(String userId) throws Exception;
}