package com.biz.iolist.persistence;

import java.util.List;

import com.biz.iolist.domain.LungExplDTO;

public interface LungExplDao {
	public List<LungExplDTO> findAll();

	public List<LungExplDTO> findByLECODE(String lung_e_code);
}
