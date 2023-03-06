package com.fabio.fascicolosanitario.web.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.registration.InMemoryClientRegistrationRepository;
import org.springframework.security.oauth2.core.AuthorizationGrantType;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.fabio.fascicolosanitario.web.bean.PropertiesSpringBean;
import com.fabio.fascicolosanitario.web.exceptions.AuthenticationException;
import com.fabio.fascicolosanitario.web.filter.SecurityFilter;
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private SecurityFilter securityFilter;
	
	@Autowired
	@Qualifier("propertiesSpringConfigurationBean")
	private PropertiesSpringBean propertiesSpringConfigurationBean;
	@Override
	public void configure(HttpSecurity httpSecurity) throws Exception {
		System.out.println("REDIRECT URI:"+propertiesSpringConfigurationBean.getWso2RedirectUriHttp());
		httpSecurity.exceptionHandling().
		authenticationEntryPoint(accessException())
		.and().requestMatchers().antMatchers("/fascicolo/**")
		.and().authorizeRequests().antMatchers("/fascicolo/**")
		.fullyAuthenticated().antMatchers("/fascicolo/amministrazione/**")
		.hasAnyRole("AMMINISTRATIVO_W","AMMINISTRATIVO_R").antMatchers("/fascicolo/sanitario/**").hasAnyRole("SANITARIO_W","SANITARIO_R")
		.antMatchers("fascicolo/home/**").hasAnyRole("SANITARIO_R","SANITARIO_W","AMMINISTRATIVO_W","AMMINISTRATIVO_R")
		.and().authorizeRequests().antMatchers("/login").permitAll()
		.and().oauth2Login().loginPage("/login")
		.and().addFilterBefore(securityFilter, UsernamePasswordAuthenticationFilter.class);
		
		
	}
	
	@Bean
	@Qualifier("clientRegistrationRepository")
	public ClientRegistrationRepository clientRegistrationRepository() {
		 ClientRegistration registration=ClientRegistration.withRegistrationId("wso2")
				.clientId(propertiesSpringConfigurationBean.getWso2Clientkey())
				.clientSecret(propertiesSpringConfigurationBean.getWso2ClientSecret())
				.scope("openid", "profile")
				.userInfoUri(String.format("%s/oauth2/authorize",propertiesSpringConfigurationBean.getWso2ServerHost()))
				.authorizationUri(String.format("%s/oauth2/authorize",propertiesSpringConfigurationBean.getWso2ServerHost()))
				.tokenUri(String.format("%s/oauth2/token",propertiesSpringConfigurationBean.getWso2ServerHost()))
				.authorizationGrantType(new AuthorizationGrantType("authorization_code"))
				.redirectUriTemplate(propertiesSpringConfigurationBean.getWso2RedirectUriHttp())
				.build();
				return new InMemoryClientRegistrationRepository(registration);
	}
	
	
	
	
	@Bean
	@Qualifier(value="accessException")
	public AuthenticationEntryPoint accessException() {
		return new AuthenticationException();
	}
}
