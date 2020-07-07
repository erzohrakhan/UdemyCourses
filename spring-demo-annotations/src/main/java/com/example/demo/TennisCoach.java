package com.example.demo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

//If we don't specify id then default id will be 'tennisCoach'(First letter is lower-case and the name remains same
//or we can name it as @component("thatsillyid")
@Component
public class TennisCoach implements Coach {
	@Autowired
	@Qualifier("ramdomFortuneService")
	private FortuneService fortuneService;

	// define a default constructor
	public TennisCoach() {
		System.out.println("TennisCoach Constructor");
	}

//	// setter injection
//	// Configure the dependency injection with Autowire annotation
//	//Any method name can be used with Autowired 
//	@Autowired
//	public void setFortuneService1(FortuneService fortuneService) {
//		System.out.println("TennisCoach setFortuneService setter");
//		this.fortuneService = fortuneService;
//	}

	@Override
	public String getDailyWorkout() {
		return "Practice your backhand volley";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

	// define my init method
	@PostConstruct
	public void doAtStartup() {
		System.out.println("Tennis Coash @postConstruct func");
	}

	// define destroy method

	@PreDestroy
	public void doAtDestroy() {
		System.out.println("Inside doAtDestroy()");
	}

}
