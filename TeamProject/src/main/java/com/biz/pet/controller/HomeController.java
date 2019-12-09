package com.biz.pet.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	/*
	 * localhost~/ 접근을 하면 path 방향을 /iolist/list로 다시 접근하도록 실행
	 */
	@RequestMapping(value = "/")
	public String home() {
		return "redirect:/bloodtest/allList";
		//return "redirect:/iolist/list";
	}
	
}
