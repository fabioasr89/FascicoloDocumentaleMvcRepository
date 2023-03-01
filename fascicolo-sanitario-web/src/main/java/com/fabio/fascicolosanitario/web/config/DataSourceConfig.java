package com.fabio.fascicolosanitario.web.config;

import javax.naming.NamingException;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jndi.JndiTemplate;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
//@EnableJpaRepositories(basePackages = "com.fabio.fascicolosanitario.web.repository")
@EnableTransactionManagement
public class DataSourceConfig {
	


	@Bean
	public JpaTransactionManager jpaTransactionManager(EntityManagerFactory entityManagerFactory) {
		JpaTransactionManager jpaTransaction=new JpaTransactionManager();
		jpaTransaction.setEntityManagerFactory(entityManagerFactory);
	
		return jpaTransaction;
	}
	
	@Bean
	public DataSource dataSource() throws NamingException {
		
		return (DataSource)new JndiTemplate().lookup("java:/FascicoloDS");
	}
	
	@Bean(name="entityManagerFactory")
	public LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean() throws NamingException {
		LocalContainerEntityManagerFactoryBean em 
        = new LocalContainerEntityManagerFactoryBean();
      em.setDataSource(dataSource());
      em.setPackagesToScan("com.fabio.fascicolosanitario.web.entity");
      em.setPersistenceUnitName("fascicoloSanitarioPersistence");
      //em.setJpaVendorAdapter(jpaVendorAdapter());
      return em;
	}
	
	
	
}
