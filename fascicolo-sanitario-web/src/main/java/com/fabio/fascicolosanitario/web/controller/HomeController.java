package com.fabio.fascicolosanitario.web.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping(value="/fascicolo")
public class HomeController {
	
	
	@RequestMapping(value="/home",method=RequestMethod.GET)
	public String home(@AuthenticationPrincipal OidcUser user) {
		if(user!=null) {
			System.out.println("IdToken:"+user.getIdToken());
		}
	
		return "home";
	}
}
