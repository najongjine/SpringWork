package com.biz.pet.controller.simplediag.lung;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.biz.pet.domain.PageDTO;
import com.biz.pet.domain.simplediag.lung.LungDTO;
import com.biz.pet.domain.simplediag.lung.LungExplDTO;
import com.biz.pet.service.simplediag.lung.LungExplService;
import com.biz.pet.service.simplediag.lung.LungService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping(value = "/simplediag/lung")
@Controller
public class LungController {
	@Autowired
	LungService lungService;
	@Autowired
	LungExplService leService;

	@RequestMapping(value = "/list")
	public String lung(Model model,String cat, String search, @RequestParam(value = "currentPageNo", required = false,
			defaultValue = "1") long currentPageNo) {
		List<LungDTO> lungList=lungService.findAllList();
		model.addAttribute("LUNG_LIST", lungList);
		PageDTO pageDTO=lungService.getPage(cat, search, currentPageNo);
		model.addAttribute("PAGE", pageDTO);
		
		return "simplediag/lung/lung";
	}
	
	@RequestMapping(value = "/alter",method=RequestMethod.GET)
	public String alter(@ModelAttribute LungDTO lungDTO, @ModelAttribute LungExplDTO leDTO,
			Model model, String strSeq) {
		long lung_seq=Long.valueOf(strSeq);
		lungDTO=lungService.findBySeq(lung_seq);
		
		List<LungExplDTO> leList=lungDTO.getExplList();
		model.addAttribute("lungDTO",lungDTO);
		model.addAttribute("leList", leList);
		return "simplediag/lung/alter";
	}
	
	@RequestMapping(value = "/alterExpl",method=RequestMethod.POST)
	public String alter(@ModelAttribute LungDTO lungDTO, @ModelAttribute LungExplDTO leDTO,
			String[] currentStrExpl,Model model , String[] newStrExpl,String[] lung_e_code, String[] lung_e_name) {
		//lungecode가 배열인건 그냥 code값 넘길때 어쩔수없이 foreach문에 넣어야해서 여러개 넘어온거임 
		try {
			log.debug("!!! newstr: "+newStrExpl[0]);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		int ret=leService.update(currentStrExpl,lung_e_code[0]);
		 ret=leService.insert(newStrExpl,lung_e_code[0],lung_e_name[0]);
		return "redirect:/simplediag/lung/list";
	}
	
	@RequestMapping(value = "/deleteAll")
	public String delete(@RequestParam("lung_seq") String strSeq) {
		long lung_seq=Long.valueOf(strSeq);
		lungService.delete(lung_seq);
		return "redirect:/simplediag/lung/list";
	}
}
