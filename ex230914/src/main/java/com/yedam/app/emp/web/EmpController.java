package com.yedam.app.emp.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.yedam.app.emp.mapper.EmpMapper;
import com.yedam.app.emp.service.EmpVO;

@Controller
public class EmpController {

	@Autowired
	EmpMapper empMapper;

	// get : 조회, 빈페이지 요청
	// 그외(post,delete, put) : 등록, 수정, 삭제

	// value = path
	// @RequestMapping(value="empForm", method=RequestMethod.GET)
	@GetMapping("empForm")
	public void getEmpInfoForm() {
	}

	@GetMapping("getEmp")
	public String getEmpData(EmpVO empVO, Model model) {
		EmpVO findVO = empMapper.selectEmpInfo(empVO);
		model.addAttribute("empInfo", findVO);

		return "empForm";
	}

	// Param을 쓸때 값이 없을떄 무조건 오류떠서 조심히 써야함
	@GetMapping("getEmpData")
	public String getEmpData(@RequestParam(defaultValue = "100", name = "eId", required = true) Integer employeeId, Model model) {
		EmpVO empVO = new EmpVO();
		empVO.setEmployeeId(employeeId);

		EmpVO findVO = empMapper.selectEmpInfo(empVO);
		model.addAttribute("empInfo",findVO);
		
		return "empForm";
	}

	@GetMapping("/emp/{id}")
	public String getEmpData2(@PathVariable(name = "id") Integer employeeId, Model model) {
		EmpVO empVO = new EmpVO();
		empVO.setEmployeeId(employeeId);

		EmpVO findVO = empMapper.selectEmpInfo(empVO);
		model.addAttribute("empInfo",findVO);
	
		return "empForm";
		
	}
	












}
