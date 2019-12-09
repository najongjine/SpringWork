package com.biz.pet.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.biz.pet.domain.TestDTO;

@RequestMapping(value = "/test")
@Controller
public class Test {
	@RequestMapping(value = "/test1")
	public String test1(Model model) {
		return "test/test";
	}
	@RequestMapping(value = "/test1",method=RequestMethod.POST)
	public String test1(@ModelAttribute TestDTO testDTO,Model model) {
		model.addAttribute("testDTO", testDTO);
		return "test/test";
	}
}
