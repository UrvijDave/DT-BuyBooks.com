package com.urvij.buybooks.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan("com.urvij.buybooks")
@EnableTransactionManagement
public class ApplicationContextConfig {

	
	@Bean(name="dataSource")
	public DriverManagerDataSource getH2DataSource()
	{
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setUrl("jdbc:h2:~/test");
		dataSource.setDriverClassName("org.h2.Driver");
	
	dataSource.setUsername("sa");
	dataSource.setPassword("sa");
	
	return dataSource;
	}
}
