package com.eintern.example.dao;

import com.eintern.example.entity.User;




public interface UserDao {
	

	public void save(User user) ;


	public User getUserByName(String name) ;

	public void deleteById(Long id) ;


	public void delete(User u);
}
