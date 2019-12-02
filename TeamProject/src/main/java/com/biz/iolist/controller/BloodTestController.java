package com.biz.iolist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.biz.iolist.domain.BloodTestDTO;
import com.biz.iolist.service.BloodTestService;

@RequestMapping(value = "/bloodtest")
@Controller
public class BloodTestController {
	@Autowired
	BloodTestService bldService;
	
	@RequestMapping(value = "/bloodtest")
	public String bloodTest() {
		return "bloodtest";
	}
	
	@RequestMapping(value = "/insert", method = RequestMethod.GET)
	public String insert(Model model) {
		
		return "bloodtest/insert";
	}
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String insert(BloodTestDTO bldDTO,Model model) {
		bldService.insert(bldDTO);
		return "bloodtest/insert";
	}
	
	@RequestMapping(value = "/update")
	public String update(BloodTestDTO bldDTO,Model model) {
		bldService.update(bldDTO);
		return null;
	}
}
