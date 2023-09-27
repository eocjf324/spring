package com.yedam.app.emp.service;

import java.util.List;

public interface EmpService {

	public List<EmpVO> getEmpList();

	public EmpVO getEmpInfo(EmpVO empVO);

	public int insertEmpInfo(EmpVO empVO);
}
