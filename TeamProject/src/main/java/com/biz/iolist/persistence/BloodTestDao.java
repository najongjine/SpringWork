package com.biz.iolist.persistence;

import com.biz.iolist.domain.BloodTestDTO;

public interface BloodTestDao {
	public int insert(BloodTestDTO bldDTO);

	public int update(BloodTestDTO bldDTO);

}
