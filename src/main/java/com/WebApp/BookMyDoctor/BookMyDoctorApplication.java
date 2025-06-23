package com.WebApp.BookMyDoctor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class BookMyDoctorApplication {

	public static void main(String[] args) {

		SpringApplication.run(BookMyDoctorApplication.class, args);
		System.out.println("Application started.....");
	}

}
