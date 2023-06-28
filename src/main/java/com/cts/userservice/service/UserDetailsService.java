package com.cts.userservice.service;

import java.util.Optional;

import com.cts.userservice.model.UserDetails;

public interface UserDetailsService {

	public Optional<UserDetails> getUserById(Long userid);

	public UserDetails saveUserDetails(UserDetails newUser);

	public boolean deleteUser(Long id);

	public UserDetails updateUser(Long id, UserDetails newUser);
}
