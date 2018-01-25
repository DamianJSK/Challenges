package com.djsk.Challenges;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@EnableJpaRepositories("com.djsk.Challenges.persistence.dao")
//@EntityScan("com.djsk.Challenges.persistence.entity")
@SpringBootApplication
public class ChallengesApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChallengesApplication.class, args);
	}
}
