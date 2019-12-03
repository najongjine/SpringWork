package com.biz.iolist.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.xml.ws.RequestWrapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.biz.iolist.domain.BloodTestDTO;
import com.biz.iolist.service.BloodTestService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping(value = "/bloodtest")
@Controller
public class BloodTestController {
	@Autowired
	BloodTestService bldService;

	@RequestMapping(value = "/allList")
	public String allList(Model model) {
		List<BloodTestDTO> bldList = bldService.findAll();
		model.addAttribute("BLDLIST", bldList);
		return "bloodtest/allList";
	}
	
	@RequestMapping(value = "/view")
	public String view(String id,Model model) {
		log.debug("view get called!!!");
		BloodTestDTO bldDTO;
		try {
			long bld_seq=Long.valueOf(id);
			bldDTO=bldService.findBySeq(bld_seq);
			
			model.addAttribute("bldDTO", bldDTO);
		} catch (Exception e) {
			log.debug("exception occured!!!");
		}
		log.debug("!!! trying to open view page");
		return "bloodtest/view";
	}

	@RequestMapping(value = "/insert",method=RequestMethod.GET)
	public String insert(Model model) {
		log.debug("insert get proceeded!!!");
		return "bloodtest/insert";
	}
	
	@RequestMapping(value = "/insert",method=RequestMethod.POST)
	public String insert(BloodTestDTO bldDTO, Model model) {
		log.debug("insert post proceeded!!!");
		int ret=bldService.insert(bldDTO);
		log.debug("insert to DB proceeded!!!");
		return "redirect:/bloodtest/allList";
	}

	@RequestMapping(value = "/update")
	public String update(BloodTestDTO bldDTO, Model model) {
		int ret=bldService.update(bldDTO);
		return "bloodtest/update";
	}

	@RequestMapping(value = "/delete")
	public String delete(BloodTestDTO bldDTO, Model model, String strSeq) {
		long bld_seq=0;
		try {
			bld_seq = Long.valueOf(strSeq);
		} catch (Exception e) {
			// TODO: handle exception
		}
		bldService.delete(bld_seq);
		return "bloodtest/allList";
	}

}
