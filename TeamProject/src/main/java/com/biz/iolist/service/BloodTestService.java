package com.biz.iolist.service;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biz.iolist.domain.BloodTestDTO;
import com.biz.iolist.persistence.BloodTestDao;

@Service
public class BloodTestService {
	@Autowired
	SqlSession sqlSession;
	
	BloodTestDao bldDao;
	@Autowired
	public void getBldMapper() {
		bldDao=sqlSession.getMapper(BloodTestDao.class);
	}
	
	public void insert(BloodTestDTO bldDTO) {
		int ret=bldDao.insert(bldDTO);
	}

	public void update(BloodTestDTO bldDTO) {
		int ret=bldDao.update(bldDTO);
		
	}
}
