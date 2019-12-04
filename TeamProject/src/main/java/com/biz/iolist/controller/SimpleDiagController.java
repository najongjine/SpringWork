package com.biz.iolist.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.biz.iolist.domain.LungDTO;
import com.biz.iolist.persistence.LungDao;
import com.biz.iolist.service.LungService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping(value = "/simplediag")
@SessionAttributes("LungDTO")
@Controller
public class SimpleDiagController {
	@Autowired
	LungService lungService;

	@ModelAttribute("LungDTO")
	public LungDTO makeLungDTO() {
		LungDTO lungDTO=new LungDTO();
		return lungDTO;
	}
	
	@RequestMapping(value = "/main")
	public String simplediagMain(Model model) {
		return "simplediag/main";
	}
	
	@RequestMapping(value = "/lung")
	public String lung(Model model) {
		List<LungDTO> lungList=lungService.findAllList();
		model.addAttribute("LUNG_LIST", lungList);
		return "simplediag/lung/lung";
	}
}
