package com.nishithadesilva.lugxgaming.analyticsapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AnalyticsApiApplication {

	public static void main(String[] args) {
		System.out.printf("**************RUNNING LOG WITH VERSION *********** : " + 5);
		SpringApplication.run(AnalyticsApiApplication.class, args);
	}

}
