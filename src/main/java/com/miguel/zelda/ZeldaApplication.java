package com.miguel.zelda;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ZeldaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZeldaApplication.class, args);
	}

}
