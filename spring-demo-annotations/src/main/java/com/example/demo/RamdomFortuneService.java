package com.example.demo;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class RamdomFortuneService implements FortuneService {

	private String[] data = { "Today is very bad day!", "Today is lucky day", "Beware! dofg acn bit u!" };
	
	//create a random number
	private Random random = new Random();

	@Override
	public String getFortune() {
		int index = random.nextInt(data.length);
		System.out.println(data[index]);
		return data[index];
	}

}
