package com.moolight;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.moolight.controller.RestApiController;
import com.moolight.model.User;
import com.moolight.repository.UserRepository;

@SpringBootApplication
@RestController
public class SpringBoot13 {
	public static void main(String[] args) {
		SpringApplication.run(SpringBoot13.class, args);
	}

}
