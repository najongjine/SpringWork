package com.biz.iolist.persistence;

import java.util.List;

import com.biz.iolist.domain.BloodTestDTO;

public interface BloodTestDao {
	public BloodTestDTO findBySeq(long bld_seq);
	public List<BloodTestDTO> findAll();
	public List<BloodTestDTO> findByName(String bld_name);
	public int insert(BloodTestDTO bldDTO);
	public int update(BloodTestDTO bldDTO);
	public int delete(long bld_seq);
}
