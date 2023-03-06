package com.fabio.fascicolosanitario.web.config;

import java.io.File;

import javax.annotation.PostConstruct;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.configuration.reloading.FileChangedReloadingStrategy;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fabio.fascicolosanitario.web.bean.PropertiesSpringBean;
/***
 * Carico dall'application server le properties esterne
 * */
@Configuration
public class PropertiesConfig {
	
	
	
	@Bean
	@Qualifier("springPropertiesConfiguration")
	public PropertiesConfiguration springPropertiesConfiguration() throws ConfigurationException {
		PropertiesConfiguration properties=new PropertiesConfiguration(
				new File(System.getProperty("jboss.server.config.dir")+"/FASCICOLO-SANITARIO/application.properties"));
		properties.setReloadingStrategy(new FileChangedReloadingStrategy());
		return properties;
	}
	
	@Bean
	@Qualifier("propertiesSpringConfigurationBean")
	public PropertiesSpringBean propertiesSpringConfigurationBean(PropertiesConfiguration springPropertiesConfiguration) {
		PropertiesSpringBean springConfigurationBean=new PropertiesSpringBean();
		springConfigurationBean.setWso2Clientkey(String.valueOf(springPropertiesConfiguration.getProperty("wso2.client.key")));
		springConfigurationBean.setWso2ClientSecret(String.valueOf(springPropertiesConfiguration.getProperty("wso2.client.secret")));
		springConfigurationBean.setWso2RedirectUriHttp(String.valueOf(springPropertiesConfiguration.getProperty("wso2.redirect.uri")));
		springConfigurationBean.setWso2ServerHost(String.valueOf(springPropertiesConfiguration.getProperty("wso2.server.host")));
		return springConfigurationBean;
	}
}
