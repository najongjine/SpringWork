package com.biz.iolist.persistence;

import java.util.List;

import com.biz.iolist.domain.LungDTO;

import lombok.Getter;

public interface LungDao {

	public List<LungDTO> findAll();
	
}
