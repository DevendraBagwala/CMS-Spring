package com.divergent.clinicmanagement;


import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@ComponentScan(basePackages ={"com.divergent.clinicmanagement","com.divergent.clinicmanagement.crud"})
//@Profile("development")
@PropertySource("classpath:/app.properties")
@EnableAspectJAutoProxy
public class JavaConfig {

	@Value("${db.url}")
	public String databaseURL;
	@Value("${db.username}")
	public String databaseUsername;
	@Value("${db.password}")
	public String databasePassword;

	@Bean
	public DataSource mysqlDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl(databaseURL);
		dataSource.setUsername(databaseUsername);
		dataSource.setPassword(databasePassword);
		return dataSource;
	}

	@Bean
	public JdbcTemplate jdbcTemplate() {
		return new JdbcTemplate(mysqlDataSource());
	}

	
}
