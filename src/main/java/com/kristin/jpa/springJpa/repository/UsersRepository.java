package com.kristin.jpa.springJpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.kristin.jpa.springJpa.model.Users;


public interface UsersRepository extends JpaRepository<Users, Integer> {
	
	List<Users> findByName(String name);
	

}
