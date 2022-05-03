package com.webService.webServices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Random;

@SpringBootApplication
public class WebServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebServicesApplication.class, args);

//		System.out.print("Making a random number between 1 and 10...  ");
//		// Random number generator
//		Random rand = new Random();
//		// this makes one from 0 to 9
//		int randomInt = rand.nextInt(10);
//		int correctInt = randomInt + 1;
//		System.out.println(correctInt);
//
//		System.out.println("Making 25 random ints between 1 and 100");
//		for (int i = 0; i < 25; i++) {
//			System.out.print((rand.nextInt(100) + 1) + " " );
//		}
//		System.out.println("\nDone");
	}

}
