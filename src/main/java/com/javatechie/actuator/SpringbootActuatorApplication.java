package com.javatechie.actuator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
@RestController
public class SpringbootActuatorApplication {

	@Autowired
	private UserDatabase dataBase;

	@GetMapping("/users")
	public List<User> getUserByEmail(){
		return dataBase.getAll();
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringbootActuatorApplication.class, args);
	}

}
