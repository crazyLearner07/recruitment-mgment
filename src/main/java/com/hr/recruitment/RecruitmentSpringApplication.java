package com.hr.recruitment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableAutoConfiguration
@EnableSwagger2
@EnableJpaRepositories(basePackages = "com.hr.recruitment.api.repositories")
@EntityScan(basePackages = "com.hr.recruitment.api.entity")
@Import({springfox.documentation.spring.data.rest.configuration.SpringDataRestConfiguration.class})
public class RecruitmentSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(RecruitmentSpringApplication.class, args);
	}
	
}
