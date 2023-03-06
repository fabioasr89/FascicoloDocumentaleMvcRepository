package com.fabio.fascicolosanitario.web.controller;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorController {
	
	@ExceptionHandler(value = Exception.class)
	public String genericException(Model model) {
		model.addAttribute("err","Si è verificato un errore");
		return "error";
	}
	
	@ExceptionHandler(value=UsernameNotFoundException.class)
	public String autenticationException(Model model) {
		model.addAttribute("err","Si è verificato un errore nella fase di profilazione");
		return "error";
	}
}
