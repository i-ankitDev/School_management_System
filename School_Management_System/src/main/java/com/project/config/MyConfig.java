package com.project.config;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.project")
public class MyConfig {
	@Bean
	public EntityManager getEntityManagerObject() {
		return Persistence.createEntityManagerFactory("student").createEntityManager();
	}
}
