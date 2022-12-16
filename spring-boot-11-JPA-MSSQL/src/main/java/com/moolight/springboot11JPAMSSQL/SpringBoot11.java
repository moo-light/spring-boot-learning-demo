package com.moolight.springboot11JPAMSSQL;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.moolight.model.User;
import com.moolight.model.UserRepository;

@SpringBootApplication
@RestController
@EntityScan("com.moolight.model")
@EnableJpaRepositories(basePackageClasses = UserRepository.class)
public class SpringBoot11 {


	private final UserRepository userRepository;
	public SpringBoot11(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringBoot11.class, args);
	}

	@GetMapping("/")
	public List<User> hello() {
        System.out.println("Tìm User với def = 49");
        List<User> userlist = userRepository.findUserByDefQuery(49,1000);
        System.out.println("User: " + userlist);
		return userlist;
	}
}
