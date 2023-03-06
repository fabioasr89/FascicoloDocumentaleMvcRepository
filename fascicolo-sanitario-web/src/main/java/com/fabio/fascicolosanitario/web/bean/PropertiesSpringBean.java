package com.fabio.fascicolosanitario.web.bean;

public class PropertiesSpringBean {
	
	private String wso2ServerHost;
	private String wso2RedirectUriHttp;
	private String wso2Clientkey;	
	private String wso2ClientSecret;
	
	
	public PropertiesSpringBean() {}


	public String getWso2ServerHost() {
		return wso2ServerHost;
	}


	public void setWso2ServerHost(String wso2ServerHost) {
		this.wso2ServerHost = wso2ServerHost;
	}


	public String getWso2RedirectUriHttp() {
		return wso2RedirectUriHttp;
	}


	public void setWso2RedirectUriHttp(String wso2RedirectUriHttp) {
		this.wso2RedirectUriHttp = wso2RedirectUriHttp;
	}


	public String getWso2Clientkey() {
		return wso2Clientkey;
	}


	public void setWso2Clientkey(String wso2Clientkey) {
		this.wso2Clientkey = wso2Clientkey;
	}


	public String getWso2ClientSecret() {
		return wso2ClientSecret;
	}


	public void setWso2ClientSecret(String wso2ClientSecret) {
		this.wso2ClientSecret = wso2ClientSecret;
	}
	
	
}
