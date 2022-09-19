package com.ali.ark.fundmanager;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages= {"com.ali.ark"})
@ComponentScan(basePackages= {"com.ali.ark.repository"})
public class FundManagerApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(FundManagerApplication.class, args);
	}
	@Override
	public void run(String... arg0) throws Exception {
		System.out.println("Command Line Runner Instantiated");
	}
}
