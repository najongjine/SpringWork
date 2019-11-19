package com.biz.student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.biz.student.service.StudentService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class StudentController {
	@Autowired
	StudentService sService;
	
	/*
	 * controller method의 매개변수
	 * controller가 어떤일을 수행하는데 필요한 정보를 spring, tomcat, dispatcher 등에게 요청하는것
	 */
	@RequestMapping(value="/student/list",method = RequestMethod.GET)
	public String list(Model model) {
		/*
		 * model: dispatcher에게 .jsp파일에 데이터를 보내서 rendering을 한텐데
		 * rendering할 데이터를 담을 바구니를 요청하는것
		 */
		log.debug("학생리스트를 보여주는 코드");
		List<String> strList=sService.getList();
		/*
		 * StudentService의 getList() 호출해서 가져온 strList를 view로 전달
		 */
		model.addAttribute("STD_LIST",strList);
		return null;
	}
	
	@RequestMapping(value = "/student/search",method = RequestMethod.GET)
	public String search() {
		log.debug("학생정보를 검색하는 코드");
		return null;
	}
}
