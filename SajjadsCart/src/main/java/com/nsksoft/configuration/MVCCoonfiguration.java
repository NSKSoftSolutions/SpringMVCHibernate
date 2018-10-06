package com.nsksoft.configuration;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.nsksoft.bean.Brand;
import com.nsksoft.bean.Category;
import com.nsksoft.bean.Item;
import com.nsksoft.repositry.NSKRespositry;

@EnableTransactionManagement
@EnableWebMvc
@ComponentScan("com.nsksoft.control")
@Component
public class MVCCoonfiguration extends WebMvcConfigurerAdapter 
{

	@Bean
	public InternalResourceViewResolver viewresolver()
	{
		
		InternalResourceViewResolver irv=new InternalResourceViewResolver();
		irv.setPrefix("/WEB-INF/jsp/");
		irv.setSuffix(".jsp");
		
		return irv;
	}
	
	@Bean
	public DataSource getDataSource()
	{
		DriverManagerDataSource dmds=new DriverManagerDataSource();
		dmds.setDriverClassName("com.mysql.jdbc.Driver");
		dmds.setUrl("jdbc:mysql://localhost:3306/myspring");
		dmds.setUsername("root");
		dmds.setPassword("root");
		
		return dmds;
		
	}
	
	
	@Bean
	public SessionFactory getSessionFactory(DataSource dataSource)
	{
		LocalSessionFactoryBuilder builder=new LocalSessionFactoryBuilder(dataSource);
		//creating the Object Of Properties
		Properties p=new Properties();
		p.put("hibernate.dialect","org.hibernate.dialect.MySQL5Dialect");
		p.put("hibernate.show_sql","true");
		p.put("hibernate.hbm2ddl.auto","update");
		
		builder.addProperties(p);
		
		builder.addAnnotatedClasses(Brand.class,Item.class,Category.class);
		return builder.buildSessionFactory();
		
	}
	
	@Bean
	public HibernateTransactionManager getmanagerAllTx(SessionFactory factory)
	{
		HibernateTransactionManager manager=new HibernateTransactionManager(factory);
		return manager;
		
	}
	
	
	@Bean	
	public NSKRespositry getrepo()
	{
		NSKRespositry nsk=new NSKRespositry();
	    return nsk;
		
	}
	
	
	
}
