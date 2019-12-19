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
import org.springframework.web.multipart.MultipartFile;

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
		long lung_seq=-1;
		List<LungExplDTO> leList=null;
		log.debug("!!!alter get strseq: "+strSeq);
		try {
			lung_seq=Long.valueOf(strSeq);
			log.debug("!!!alter get lung seq: "+lung_seq);
			lungDTO=lungService.findBySeq(lung_seq);
			leList=lungDTO.getExplList();
		} catch (Exception e) {
			lung_seq=-1;
		}
		
		
		model.addAttribute("lungDTO",lungDTO);
		model.addAttribute("leList", leList);
		return "simplediag/lung/alter";
	}
	
	@RequestMapping(value = "/alter",method=RequestMethod.POST)
	public String alter(@ModelAttribute("lungDTO") LungDTO lungDTO,// , @ModelAttribute LungExplDTO leDTO,
			String[] currentStrExpl,Model model , String[] newStrExpl,String lung_e_code,
			String lung_e_name, @RequestParam(value="u_file", required = false) MultipartFile u_file) {
		
		int ret=0;
		
		log.debug("!!! alter post lungseq: "+lungDTO.toString());
		log.debug("!!! alter post lungseq: "+lungDTO.getLung_seq());
		if(lungService.findBySeq(lungDTO.getLung_seq())==null) {
			log.debug("!!! lung insert called: "+lungDTO.toString());
			ret=lungService.insert(lungDTO);
		}
		
		if(lungService.findBySeq(lungDTO.getLung_seq())!=null) {
			log.debug("!!! lung update called: "+lungDTO.toString());
			ret=lungService.update(lungDTO);
		}
		ret=leService.update(currentStrExpl,lung_e_code);
		 ret=leService.insert(newStrExpl,lung_e_code,lung_e_name);
		return "redirect:/simplediag/lung/list";
	}
	
	@RequestMapping(value = "/deleteAll")
	public String delete(@RequestParam("lung_seq") String strSeq) {
		long lung_seq=Long.valueOf(strSeq);
		lungService.delete(lung_seq);
		return "redirect:/simplediag/lung/list";
	}
}
