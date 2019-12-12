package com.biz.pet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.biz.pet.domain.GoPetVO;
import com.biz.pet.domain.SearchVO;
import com.biz.pet.service.PetService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class PetController {
	@Autowired
	PetService pService;
	
	@RequestMapping(value = "pet",method=RequestMethod.GET)
	public String pet(@RequestParam( value="s_text",required=false, defaultValue = "") String s_text,
			@RequestParam(value = "s_cat", defaultValue = "") String s_cat,Model model) {
		List<GoPetVO> petList=pService.getRestVoList(s_cat, s_text);
		model.addAttribute("H_LIST",petList);
		SearchVO searchVO= SearchVO.builder().s_cat(s_cat).s_text(s_text).build();
		model.addAttribute("searchVO", searchVO);
		return "home";
	}//end
}
