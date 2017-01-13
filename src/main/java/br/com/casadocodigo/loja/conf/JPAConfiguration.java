package br.com.casadocodigo.loja.conf;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;

import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
public class JPAConfiguration {
	
	@Bean
	public LocalContainerEntityManagerFactoryBean EntityManagerFactory(){
		LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
		
		JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		factory.setJpaVendorAdapter(vendorAdapter);
		
		DriverManagerDataSource datasource = new DriverManagerDataSource();
		datasource.setUsername("root");
		datasource.setPassword("admin");
		datasource.setUrl("jdbc:mysql://localhost:3306/casadocodigo");
		datasource.setDriverClassName("com.mysql.jdbc.Driver");
		
		factory.setDataSource(datasource);
		
		Properties props = new Properties();
		props.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
		props.setProperty("hibernate.show_sql", "true");
		props.setProperty("hibernate.hbm2ddl.auto", "update");
		
		factory.setJpaProperties(props);
		factory.setPackagesToScan("br.com.casadocodigo.loja.model");
		
		return factory;
	}
	
	@Bean
	public JpaTransactionManager transactionManager(EntityManagerFactory emf){
		return new JpaTransactionManager(emf);
	}
	
}
