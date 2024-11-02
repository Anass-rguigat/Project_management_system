package com.example.demo.services;

import com.example.demo.model.User;

public interface UserService {

	User findUerProfileByJwt(String jwt)throws Exception;
	
	User findUserByEmail(String email)throws Exception;
	
	User findUserById(Long userId)throws Exception;
	
	User updateUsersProjectSize(User user,int number);
	
	
}
