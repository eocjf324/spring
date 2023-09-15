package com.yedam.app.emp.mapper;

import java.util.List;

// mybatise annotation @param 
import org.apache.ibatis.annotations.Param;

import com.yedam.app.emp.service.EmpVO;

public interface EmpMapper {
	//전체조회
	public List<EmpVO> seleletEmplAllList(EmpVO empVO);
	
	//단건조회
	public EmpVO selectEmpInfo(EmpVO empVO);
	//등록
	public int insertEmpInfo(EmpVO empVO);
	//수정  - 급여를 정해진 비율로 인상
	//매개변수가 2개이상일때 param 써야함 
	public int updateEmpSal(@Param("empId") int employeeId, @Param("raise") int raise);
	//수정  - 사원 정보 수정 
	public int updateEmpInfo(EmpVO empVO);
	//삭제
	public int deleteEmpInfo(int employeeId);
}
