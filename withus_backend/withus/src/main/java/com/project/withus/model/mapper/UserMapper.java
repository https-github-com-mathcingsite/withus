package com.project.withus.model.mapper;

import java.sql.SQLException;

import com.project.withus.model.UserDto;

public interface UserMapper {
	public int insertUser(UserDto userDto) throws SQLException;
	public UserDto login(UserDto userDto) throws SQLException;
	public UserDto getUserInfo(String userId);
	public boolean updateUser(UserDto user) throws SQLException;
	public UserDto getOneUser(String userId) throws SQLException;
}

