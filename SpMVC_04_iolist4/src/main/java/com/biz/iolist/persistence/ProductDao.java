package com.biz.iolist.persistence;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.biz.iolist.domain.ProductDTO;

public interface ProductDao {
	public List<ProductDTO> selectAll();
	public List<ProductDTO> findAll();
	public int insert(ProductDTO prodDTO);
	public String getPCode();
	public ProductDTO findByPCode(String p_code);
	public int delete(String p_code);
	public int update(ProductDTO prodDTO);
	public List<ProductDTO> findByName(@Param("p_name") String strText);
	
}
