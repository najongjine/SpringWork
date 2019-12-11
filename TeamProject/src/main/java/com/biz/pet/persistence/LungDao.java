package com.biz.pet.persistence;

import java.util.List;

import com.biz.pet.domain.LungDTO;

import lombok.Getter;

public interface LungDao {

	public List<LungDTO> findAll();

	public LungDTO findBySeq(long lung_seq);
	
}
