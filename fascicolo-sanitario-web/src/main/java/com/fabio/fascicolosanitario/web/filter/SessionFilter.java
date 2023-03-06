package com.fabio.fascicolosanitario.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.fabio.fascicolosanitario.web.services.impl.ServiceDetailsCustom;


@Component
@Qualifier(value = "sessionFilter")
public class SessionFilter implements Filter{
	
	
	@Autowired
	@Qualifier(value="servicesDetailsCustom")
	private ServiceDetailsCustom servicesDetailCustom;
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest servletRequest=(HttpServletRequest)request;
		HttpServletResponse servletResponse=(HttpServletResponse)response;
		
	
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
		
		
	}
	
}
