package com.cts.userservice.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cts.userservice.model.UserDetails;
import com.cts.userservice.repository.UserRepository;

@Repository
public class UserDetailsServiceImpl implements UserDetailsService{

	@Autowired
	private UserRepository userRepo;
	
	public Optional<UserDetails> getUserById(Long userid){
		UserDetails user = null;
		if(userRepo.existsById(userid)) {
			user = userRepo.findById(userid).get();
		}
		return Optional.ofNullable(user);
	}
	
	
	public UserDetails saveUserDetails(UserDetails newUser){
		UserDetails user = userRepo.save(newUser);
		return user;
	}
	
	
	public boolean deleteUser(Long id) {
		Optional<UserDetails> user = getUserById(id);
		if(user.isPresent()) {
			userRepo.delete(user.get());
			return true;
		}
		else {
			return false;
		}
	}
	
	public UserDetails updateUser(Long id, UserDetails newUser) {
		Optional<UserDetails> oldUser = getUserById(id);
		if(oldUser.isPresent()) {
			oldUser.get().setFirstName(newUser.getFirstName());
			oldUser.get().setLastName(newUser.getLastName());
			oldUser.get().setCity(newUser.getCity());
			oldUser.get().setContact(newUser.getContact());
			
			userRepo.save(oldUser.get());
		}
		return oldUser.get();
	}
}
