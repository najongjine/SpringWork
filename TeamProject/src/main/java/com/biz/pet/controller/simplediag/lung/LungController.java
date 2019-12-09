package com.biz.pet.controller.simplediag.lung;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.biz.pet.domain.LungDTO;
import com.biz.pet.domain.LungExplDTO;
import com.biz.pet.persistence.LungDao;
import com.biz.pet.persistence.LungExplDao;
import com.biz.pet.service.LungService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping(value = "/simplediag/lung")
@Controller
public class LungController {
	@Autowired
	LungService lungService;

	@ModelAttribute("LungDTO")
	public LungDTO makeLungDTO() {
		LungDTO lungDTO=new LungDTO();
		return lungDTO;
	}

	@RequestMapping(value = "/list")
	public String lung(Model model) {
		List<LungDTO> lungList=lungService.findAllList();
		model.addAttribute("LUNG_LIST", lungList);
		return "simplediag/lung/lung";
	}
}
