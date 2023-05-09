package com.mywallet.financialmanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class FinancialManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(FinancialManagerApplication.class, args);
	}

}
