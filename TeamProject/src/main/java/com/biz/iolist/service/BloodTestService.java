package com.biz.iolist.service;

import java.util.List;

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
	public void getBldDaoMapper() {
		bldDao=sqlSession.getMapper(BloodTestDao.class);
	}
	public BloodTestDTO findBySeq(long bld_seq) {
		BloodTestDTO bldDTO=bldDao.findBySeq(bld_seq);
		return bldDTO;
	}
	public List<BloodTestDTO> findAll(){
		List<BloodTestDTO> bldList=bldDao.findAll();
		return bldList;
	}
	public List<BloodTestDTO> findByName(String bld_name){
		List<BloodTestDTO> bldList=bldDao.findByName(bld_name);
		return bldList;
	}
	public int insert(BloodTestDTO bldDTO) {
		int ret=bldDao.insert(bldDTO);
		return ret;
	}
	public int update(BloodTestDTO bldDTO) {
		int ret=bldDao.update(bldDTO);
		return ret;
	}
	public int delete(long bld_seq) {
		int ret=bldDao.delete(bld_seq);
		return ret;
	}
}
