package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
//@ComponentScan("com.example.demo")
public class SportConfig {

	// define bean for sadfortuneservice
	@Bean
	public FortuneService sadFortuneService() {
		return new SadFortuneService();
	}

	// define bean for our Football coach and inject dependency

	@Bean
	public Coach footballCoach() {
		return new FootballCoach(sadFortuneService());
	}

}
