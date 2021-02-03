package com.l2c.springsecurity.demo.config;

import java.beans.PropertyVetoException;
import java.util.logging.Logger;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages= {"com.l2c.springsecurity.demo","com.l2c.springsecurity.demo.customer.*"})
@PropertySource("classpath:persistence-mysql.properties")
public class DemoAppConfig {
	
	@Autowired
	private Environment env;
	
	//set up logger for diagnostics
	private Logger logger = Logger.getLogger(getClass().getName());
	
	@Bean
	public ViewResolver viewResolver() {
		
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/view/");
		viewResolver.setSuffix(".jsp");
																																																																																																																																		
		return viewResolver;
	}
	
	
	//  define a bean for our security dataSource 
	@Bean
	public DataSource securityDataSource1() {
		
		// create the connection pool
		ComboPooledDataSource securityDataSource =
								new ComboPooledDataSource();
		
		// set the JDBC driver class
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			securityDataSource.setDriverClass(env.getProperty("jdbc.Driver"));
		} catch (PropertyVetoException exc) {
			throw new RuntimeException(exc);
		}
		
		// log the connection properties
		// just for sanity sake. we are logging this info
		logger.info(">>> jdbc.url="+env.getProperty("jdbc.url"));
		logger.info(">>> jdbc.user="+env.getProperty("jdbc.user"));
		
		// set the database connection properties
		securityDataSource.setJdbcUrl(env.getProperty("jdbc.url"));
		securityDataSource.setUser(env.getProperty("jdbc.user"));
		securityDataSource.setPassword(env.getProperty("jdbc.password"));
		
		// set connection pool properties
		securityDataSource.setInitialPoolSize(
						getIntProperty("connection.pool.initialPoolSize"));
		
		securityDataSource.setMinPoolSize(
				getIntProperty("connection.pool.minPoolSize"));
		
		securityDataSource.setMaxPoolSize(
				getIntProperty("connection.pool.maxPoolSize"));
		
		securityDataSource.setMaxIdleTime(
				getIntProperty("connection.pool.maxIdleTime"));
		
		return securityDataSource;
	}
	
	private int getIntProperty(String propName) {
		
		String propValue = env.getProperty(propName);
		int intPropValue = Integer.parseInt(propValue);
		
		return intPropValue;
		}
	
}
