package com.cts.userservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.userservice.model.UserDetails;

public interface UserRepository extends JpaRepository<UserDetails,Long>{

}
