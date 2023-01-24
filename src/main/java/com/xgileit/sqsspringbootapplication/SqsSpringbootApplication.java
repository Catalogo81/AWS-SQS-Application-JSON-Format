package com.xgileit.sqsspringbootapplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.aws.autoconfigure.context.ContextStackAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication//(exclude = { ContextStackAutoConfiguration.class })
//@ComponentScan(basePackages = "com.xgileit.*")
public class SqsSpringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(SqsSpringbootApplication.class, args);
	}

}
