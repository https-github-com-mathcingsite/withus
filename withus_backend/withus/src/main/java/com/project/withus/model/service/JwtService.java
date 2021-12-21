package com.project.withus.model.service;

import java.util.Map;

public interface JwtService {

	<T> String create(String key, T data, String subject);
	boolean isUsable(String jwt);
	Map<String, Object> get(String key);
	String getUserId();

}