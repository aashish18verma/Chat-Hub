package com.niit.collaboration.config;

import java.util.Properties;


import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.niit.collaboration.model.*;



@Configuration
@ComponentScan("com.niit.collaboration.config")
@EnableTransactionManagement

public class ApplicationContextConfig
{
    	@Bean(name = "dataSource")
	    public static DataSource getDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		dataSource.setUrl("jdbc:oracle:thin:@localhost:1521/XE");
		dataSource.setUsername("hr");
		dataSource.setPassword("hr");
		return dataSource;
	   }

    	private static Properties getHibernateProperties()
    	{
    		Properties properties = new Properties();
    		properties.put("hibernate.show_sql", "true");
    		properties.put("hibernate.hbm2ddl.auto", "update");
    		properties.put("hibernate.dialect", "org.hibernate.dialect.OracleDialect");
			return properties;
	}

	@Autowired
	@Bean(name = "sessionFactory")
	public static SessionFactory getSessionFactory(DataSource dataSource)
	{
		LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
		sessionBuilder.addProperties(getHibernateProperties());
		sessionBuilder.addAnnotatedClasses(User.class);
		sessionBuilder.addAnnotatedClasses(Blog.class);
		sessionBuilder.addAnnotatedClasses(Chat.class);
		sessionBuilder.addAnnotatedClasses(ChatForum.class);
		sessionBuilder.addAnnotatedClasses(ChatForumComment.class);
		sessionBuilder.addAnnotatedClasses(Event.class);
		sessionBuilder.addAnnotatedClasses(Friend.class);
		sessionBuilder.addAnnotatedClasses(Job.class);
		sessionBuilder.addAnnotatedClasses(JobApplication.class);
		
		
		sessionBuilder.addAnnotatedClasses(ChatData.class);
		sessionBuilder.addAnnotatedClasses(UserMultimedia.class);
		
		
		
		return sessionBuilder.buildSessionFactory();
	}

	@Autowired
	@Bean(name = "transactionManager")
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) 
	{
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
		return transactionManager;
	}

	
	@Bean(name = "multipartResolver")
	public CommonsMultipartResolver getCommonsMultipartResolver() {
	    CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
	    multipartResolver.setMaxUploadSize(20971520);   // 20MB
	    multipartResolver.setMaxInMemorySize(1048576);  // 1MB
	    return multipartResolver;
	}
	
}
