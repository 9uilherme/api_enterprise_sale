package br.com.enterprise.apiEnterprise.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

	@RequestMapping(
			value="/")
	public String index() {
		return "index";
	}

	@GetMapping(
			value="/error")
	public String error() {
		return "index";
	}
	
}

