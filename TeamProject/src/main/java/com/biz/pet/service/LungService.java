package com.biz.pet.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biz.pet.domain.LungDTO;
import com.biz.pet.domain.LungExplDTO;
import com.biz.pet.persistence.LungDao;
import com.biz.pet.persistence.LungExplDao;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class LungService {
	@Autowired
	SqlSession SqlSession;
	
	LungDao lungDao;
	LungExplDao leDao;
	@Autowired
	public void makeLungDao() {
		lungDao=SqlSession.getMapper(LungDao.class);
	}
	@Autowired
	public void makeLungExplDao() {
		leDao=SqlSession.getMapper(LungExplDao.class);
	}
	public List<LungDTO> findAllList() {
		// TODO Auto-generated method stub
		List<LungDTO> lungList=lungDao.findAll();
		
		for(LungDTO lungDTO: lungList) {
			String lung_e_code=lungDTO.getLung_explcode();
			List<LungExplDTO> leList=leDao.findByLECODE(lung_e_code);
			for(LungExplDTO leDTO: leList) {
				lungDTO.getExplList().add(leDTO);
			}
		}
		return lungList;
	}
	public LungDTO findBySeq(long lung_seq) {
		LungDTO lungDTO=lungDao.findBySeq(lung_seq);
		String lung_e_code=lungDTO.getLung_explcode();
		List<LungExplDTO> leList=leDao.findByLECODE(lung_e_code);
		for(LungExplDTO leDTO: leList) {
			lungDTO.getExplList().add(leDTO);
		}
		log.debug("!!!service: "+lungDTO);
		return lungDTO;
	}
}
