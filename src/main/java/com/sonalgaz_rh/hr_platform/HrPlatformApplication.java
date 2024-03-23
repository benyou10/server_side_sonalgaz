package com.sonalgaz_rh.hr_platform;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class HrPlatformApplication {

	public static void main(String[] args) {
		SpringApplication.run(HrPlatformApplication.class, args);
	}
	@GetMapping
public String Hello(){
		return "hello the best worl world";
}
}
