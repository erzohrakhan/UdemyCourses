package com.example.demo;

public class FootballCoach implements Coach {
	private FortuneService fortuneService;

	public FootballCoach(FortuneService fortuneService) {
		super();
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "Practice for 2 hours daily!";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}
