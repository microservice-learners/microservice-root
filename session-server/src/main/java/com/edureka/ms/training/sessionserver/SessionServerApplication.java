package com.edureka.ms.training.sessionserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.session.config.annotation.web.http.EnableSpringHttpSession;

@SpringBootApplication
@EnableCaching
@EnableSpringHttpSession
public class SessionServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SessionServerApplication.class, args);
	}

}
