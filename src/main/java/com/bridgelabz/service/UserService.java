package com.bridgelabz.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.bridgelabz.Model.User;


public interface UserService {
	public User register(User u);

	public List<User> getUsers();

	public ResponseEntity<User> updateUser(User u,long id);
	
	public boolean deleteUser(long id);

}
