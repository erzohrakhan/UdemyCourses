package com.example.demo;

public class SadFortuneService implements FortuneService {

	@Override
	public String getFortune() {
		return "Today is our sad day!";
	}

}
