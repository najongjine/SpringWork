package com.biz.iolist.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biz.iolist.domain.LungDTO;
import com.biz.iolist.persistence.LungDao;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class LungService {
	@Autowired
	SqlSession SqlSession;
	
	LungDao lungDao;
	@Autowired
	public void getSimpleDiagDao() {
		lungDao=SqlSession.getMapper(LungDao.class);
	}
	public List<LungDTO> findAllList() {
		// TODO Auto-generated method stub
		List<LungDTO> lungList=lungDao.findAll();
		return lungList;
	}
}
