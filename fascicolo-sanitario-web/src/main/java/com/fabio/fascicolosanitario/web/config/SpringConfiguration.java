package com.fabio.fascicolosanitario.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.tiles3.TilesView;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;

@Configuration
public class SpringConfiguration {
	
	@Bean
	public InternalResourceViewResolver internalResourceViewResolver() {
		InternalResourceViewResolver internalViewResolver=new InternalResourceViewResolver();
		internalViewResolver.setPrefix("/WEB-INF/view/");
		internalViewResolver.setSuffix(".jsp");
		internalViewResolver.setOrder(1);
		return internalViewResolver;
	}
	
	
	@Bean
	public TilesViewResolver tilesViewResolver() {
		TilesViewResolver  urlResourceViewResolver=new  TilesViewResolver();
	
		urlResourceViewResolver.setViewClass(TilesView.class);
		urlResourceViewResolver.setOrder(0);
		return urlResourceViewResolver;
	}
	
	
	
	
}
