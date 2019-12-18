package com.biz.pet.service.simplediag.lung;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biz.pet.domain.PageDTO;
import com.biz.pet.domain.simplediag.lung.LungDTO;
import com.biz.pet.domain.simplediag.lung.LungExplDTO;
import com.biz.pet.persistence.simplediag.lung.LungDao;
import com.biz.pet.persistence.simplediag.lung.LungExplDao;
import com.biz.pet.service.PageService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class LungService {
	long maxListSize=0;
	@Autowired
	SqlSession SqlSession;
	@Autowired
	PageService pService;
	
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
	public PageDTO getPage(String cat, String search, long currentPageNo) {
		long totalCount=maxListSize;
		if(totalCount>maxListSize) totalCount=maxListSize;
		PageDTO pageDTO=pService.makePageNation(totalCount, currentPageNo);
		log.debug("전체갯수: "+totalCount);
		
		return pageDTO;
	}
	public List<LungDTO> findAllList() {
		// TODO Auto-generated method stub
		List<LungDTO> lungList=lungDao.findAll();
		maxListSize=lungList.size();
		
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
	public int delete(long lung_seq) {
		return lungDao.delete(lung_seq);
	}
}
