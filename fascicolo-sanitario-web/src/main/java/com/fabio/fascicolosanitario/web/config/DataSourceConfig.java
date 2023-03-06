package com.fabio.fascicolosanitario.web.config;

import java.util.Properties;

import javax.naming.NamingException;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jndi.JndiTemplate;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories(basePackages = {"com.fabio.fascicolosanitario.web.repository"})
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
		em.setPackagesToScan(new String[] {"com.fabio.fascicolosanitario.web.entity"});
		//em.setPersistenceUnitName("fascicoloSanitarioPersistence");
		em.setJpaVendorAdapter(jpaVendorAdapter());
		em.setJpaProperties(jpaPropertiesCustom());
		return em;
	}
	
	
	@Bean
	public Properties jpaPropertiesCustom() {
		final Properties properties=new Properties();
		//properties.put("hibernate.dialect","org.hibernate.dialect.PostgreSQLDialect");
		properties.put("hibernate.hbm2ddl.auto", "update");
		return properties;
	}


	@Bean
	public JpaVendorAdapter jpaVendorAdapter() {
		HibernateJpaVendorAdapter ans = new HibernateJpaVendorAdapter();
		ans.setShowSql(true);
		ans.setGenerateDdl(true);
		return ans;
	}


}
