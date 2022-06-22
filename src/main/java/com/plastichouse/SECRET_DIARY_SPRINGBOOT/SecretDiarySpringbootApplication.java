package com.plastichouse.SECRET_DIARY_SPRINGBOOT;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class SecretDiarySpringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecretDiarySpringbootApplication.class, args);
	}

}
