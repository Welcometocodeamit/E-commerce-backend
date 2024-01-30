package com.ecom.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecom.models.User;
import com.ecom.services.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired UserService userService;
	
//	get user by id
	@GetMapping("/{id}")
	public ResponseEntity<?> getUserById(@PathVariable int id){
		return  userService.getUserById(id);
	}
	
//	Add user
	@PostMapping("")
	public ResponseEntity<?> saveUser(@RequestBody User user){
		return userService.addUser(user);
	}
	
//	Delete user by id
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteUserById(@PathVariable int id){
		return userService.deleteUserById(id);
	}

}
