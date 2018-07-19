package com.configuration;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.spring.bean.UploadFile;
import com.spring.bean.User;
import com.spring.constants.HibernateConstants;
import com.spring.repositories.Repositry;
import com.spring.repositories.SpringRepositry;
import com.spring.services.ServiceImpl;

@EnableWebMvc
@EnableTransactionManagement
@ComponentScan({ "com.spring.controller" })
@Configuration
public class SpringConfiguration extends WebMvcConfigurerAdapter {
	Logger logger = Logger.getLogger(SpringConfiguration.class.getName());

	@Bean
	public DataSource addDataSource() {
		logger.info("Came inside the addDataSource and adding the Connection Properties");
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(HibernateConstants.Driver_class_Name);
		dataSource.setUrl(HibernateConstants.URL);
		dataSource.setUsername(HibernateConstants.user_name);
		dataSource.setPassword(HibernateConstants.password);
		logger.info("returning the datasource object");
		return dataSource;
	}

	@Bean
	public SessionFactory addSessionFactory(DataSource dataSource) {
		logger.info("Sessionfactory Object is Created adding the Hibernate properties and Mapping files");
		LocalSessionFactoryBuilder builder = new LocalSessionFactoryBuilder(dataSource);
		Properties prop = new Properties();
		prop.put("hibernate.dialect", HibernateConstants.hibernate_dialect);
		prop.put("hibernate.hbm2ddl.auto", HibernateConstants.hibernate_hbm2ddl_auto);
		prop.put("hibernate.show_sql", HibernateConstants.hibernate_show_sql);

		builder.addProperties(prop);
		builder.addAnnotatedClasses(User.class,UploadFile.class);
		logger.info("returning the sessionFactory");
		return builder.buildSessionFactory();

	}

	@Bean
	public HibernateTransactionManager add_transaction_manger(SessionFactory factory) {

		HibernateTransactionManager manager = new HibernateTransactionManager(factory);
		return manager;
	}

	@Bean
	public ServiceImpl addservice() {
		ServiceImpl s = new ServiceImpl();
		return s;
	}

	@Bean
	public Repositry addrepo() {
		SpringRepositry repo = new SpringRepositry();
		logger.info("returning the Respositry");
		return repo;
	}

	@Bean
	public InternalResourceViewResolver viewresolvere() {

		InternalResourceViewResolver irv = new InternalResourceViewResolver();
		irv.setPrefix("/WEB-INF/jsp/");
		irv.setSuffix(".jsp");

		return irv;
	}

	@Bean
	public CommonsMultipartResolver addMultipartResolver() {
		CommonsMultipartResolver resolver = new CommonsMultipartResolver();
		resolver.setMaxUploadSize(100000);

		return resolver;
	}

}