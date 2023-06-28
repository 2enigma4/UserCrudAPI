package com.cts.userservice.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.userservice.model.UserDetails;
import com.cts.userservice.service.UserDetailsServiceImpl;

@RestController
@RequestMapping("/api")
public class UserController {

	@Autowired
	UserDetailsServiceImpl service;
	

	@GetMapping(value = "/getuser/{userid}")
	public ResponseEntity<UserDetails> getUserData(@PathVariable ("userid") Long userid) {
		UserDetails user = service.getUserById(userid).get();
		return new ResponseEntity<>(user,HttpStatus.OK);
		
	}
	
	@PostMapping(value = "/adduser")
	public ResponseEntity<UserDetails> postUserData(@RequestBody UserDetails newUser) {
	    UserDetails user = service.saveUserDetails(newUser);
	    return new ResponseEntity<>(user, HttpStatus.CREATED);  
	}
	
	@DeleteMapping(value = "/deleteuser/{userid}")
	public ResponseEntity<String> deleteUserData(@PathVariable ("userid") Long userid){
		boolean result = service.deleteUser(userid);
		if(result)
			return new ResponseEntity<>("Deleted",HttpStatus.OK);
		else
			return new ResponseEntity<>("User not present with this id", HttpStatus.NOT_FOUND);
	}
	
	@PutMapping(value = "/updateuser/{userid}")
	public ResponseEntity<UserDetails> updateUserData(@PathVariable ("userid") Long userid,@RequestBody UserDetails newUser ){
		UserDetails updatedUser = service.updateUser(userid, newUser);
		return new ResponseEntity<>(updatedUser,HttpStatus.OK);
	}
}
