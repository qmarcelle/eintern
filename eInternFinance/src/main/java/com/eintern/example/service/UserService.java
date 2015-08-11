package com.eintern.example.service;

import com.eintern.example.entity.User;

public interface UserService {

	
	public User save(User user) ;


	public User getUserByName(String name) ;

	public void deleteById(Long id) ;


	public void delete(User u);
}
