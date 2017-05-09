package com.travelagency;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TravelAgencyApplication {


	public static void main(String[] args) {
		SpringApplication.run(TravelAgencyApplication.class, args);

	}

	@Bean
	public ModelMapper getModelMapper(){
		return new ModelMapper();
	}
}
