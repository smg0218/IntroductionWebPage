package com.spring;

import com.spring.entity.User;
import com.spring.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.UUID;

@SpringBootApplication
public class Main {

	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
	}

	// 서버 실행 시 User 데이터베이스에 admin이 없다면 admin을 생성하는 빈
	@Bean
	public CommandLineRunner adminInitializers(UserRepository userRepository) {
		return args -> {
			if (!userRepository.existsById("admin")) {
				User admin = new User();
				admin.setUserId("admin");
				admin.setUserPassword(String.valueOf(UUID.randomUUID()));
				userRepository.save(admin);
			}
		};
	}

}
