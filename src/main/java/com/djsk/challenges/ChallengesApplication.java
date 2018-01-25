package com.djsk.challenges;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@EnableJpaRepositories("com.djsk.challenges.persistence.dao")
//@EntityScan("com.djsk.challenges.persistence.entity")
@SpringBootApplication
public class ChallengesApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChallengesApplication.class, args);
	}
}
