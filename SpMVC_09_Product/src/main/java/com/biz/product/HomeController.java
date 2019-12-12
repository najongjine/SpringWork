package com.biz.product;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class HomeController {
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		
		return "home";
	}
	
	@ResponseBody
	@RequestMapping(value = "nation",method=RequestMethod.GET,produces = "text/html;charset=UTF-8")
	public String getNation(String str) {
		log.debug("req 변수 str:"+str);
		
		String strNation="rebdfged";
		strNation=str;
		return strNation;
	}
}
