package com.nobroker;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class NobrokerApplication {

	public static void main(String[] args) {

		SpringApplication.run(NobrokerApplication.class, args);
	}
	 @Bean//informing ioc what object to create and then inject
	public ModelMapper modelMapper(){

		return new ModelMapper();
	 }
}
