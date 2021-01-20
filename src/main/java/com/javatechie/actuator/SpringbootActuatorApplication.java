package com.javatechie.actuator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpringbootActuatorApplication {
	@Autowired
	private EkartDataBase dataBase;

	@GetMapping("/customer/{email}")
	public Customer getCustomerByEmail(@PathVariable String email){
		return dataBase.getAll().stream()
				.filter(customer -> customer.getEmail().equals(email))
				.findAny().orElseThrow(
						()->new IllegalArgumentException("Customer not found with email : "+email)
				);
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringbootActuatorApplication.class, args);
	}

}
