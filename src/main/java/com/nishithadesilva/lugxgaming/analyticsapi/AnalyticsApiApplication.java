package com.nishithadesilva.lugxgaming.analyticsapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication (exclude = DataSourceAutoConfiguration.class)
public class AnalyticsApiApplication {

	public static void main(String[] args) {
		System.out.printf("**************RUNNING LOG WITH VERSION *********** : " + 8);
		SpringApplication.run(AnalyticsApiApplication.class, args);
	}
}
