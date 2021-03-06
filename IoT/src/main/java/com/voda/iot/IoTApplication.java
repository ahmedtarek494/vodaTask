package com.voda.iot;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@SpringBootApplication
@ComponentScan(basePackages = { "com.voda.*", "com.voda.iot.*" })
@EntityScan("com.voda.iot.entities")
@EnableJpaRepositories("com.voda.iot.Repos")
public class IoTApplication {

	public static void main(String[] args) {
		SpringApplication.run(IoTApplication.class, args);
	}


	@Autowired
	private Environment env;
	@Bean
	public DataSource dataSource() {
		
		System.out.println("--------------------------------------" + env);
		// System.out.println("-----------------" + url);
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(env.getRequiredProperty("jdbc.driverClassName"));
		dataSource.setUrl(env.getRequiredProperty("jdbc.url"));
		dataSource.setUsername(env.getRequiredProperty("jdbc.username"));
		dataSource.setPassword(env.getRequiredProperty("jdbc.password"));
		return dataSource;

	}
	
}
