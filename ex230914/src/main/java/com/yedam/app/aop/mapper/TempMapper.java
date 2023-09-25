package com.yedam.app.aop.mapper;

import org.apache.ibatis.annotations.Insert;

public interface TempMapper {
	
	@Insert("INSERT INTO tbl_tmp VALUES( #{value})")
	public void insert(String value);
}
