package com.kristin.jpa.springJpa.resource;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kristin.jpa.springJpa.model.Users;
import com.kristin.jpa.springJpa.model.UsersLog;
import com.kristin.jpa.springJpa.repository.UsersLogRepository;

@RestController
@RequestMapping("/rest/users/log")
public class UsersLogResource {
	
	private UsersLogRepository usersLogRepository;
	
	
	public UsersLogResource(UsersLogRepository usersLogRepository) {

		this.usersLogRepository = usersLogRepository;
	}


	@GetMapping("/all")
	public List<UsersLog> getAll() {
		return usersLogRepository.findAll();
	}
	
	@GetMapping(value ="/update/{name}")
	public List<UsersLog> update(@PathVariable final String name) {
		
		Users users = new Users();
		
		users.setName(name)
			.setSalary(20000)
			.setTeamName("Operations");
		
		UsersLog usersLog1 = new UsersLog();
		usersLog1.setUsers(users);
		
		usersLogRepository.save(usersLog1);
		
		UsersLog usersLog2 = new UsersLog();
		usersLog2.setUsers(users);
		
		usersLog1.setLog("Hi YouTube");
		usersLog2.setLog("Hi Viewers");
		usersLogRepository.save(usersLog2);
		
		return usersLogRepository.findAll();
		
	}

	
}
