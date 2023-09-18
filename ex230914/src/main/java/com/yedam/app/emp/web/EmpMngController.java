package com.yedam.app.emp.web;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.yedam.app.emp.service.EmpService;
import com.yedam.app.emp.service.EmpVO;

@Controller
public class EmpMngController {
	
	@Autowired
	EmpService empService;
	
	//조회(데이터, 일반페이지) -> GET
	//등록, 수정, 삭제 -> POST (예외, 단건삭제 - GET)
	
	//전체조회
	@GetMapping("empList")
	public String getEmpAllList(Model model) {
		model.addAttribute("empList", empService.getEmpAll());
		return "emp/empList";
	}
	//단건조회
	@GetMapping("empInfo")
	public String getEmpInfo(EmpVO empVO, Model model) {
		model.addAttribute("empInfo", empService.getEmp(empVO));
		return "emp/empInfo";
	}
	//등록 - Form
	@GetMapping("empInsert")
	public String getInsertForm() {
		return "emp/empInsert";
	}
	//등록 - Process 기능 처리 
	@PostMapping("empInsert")
	public String getInsertProcess(EmpVO empVO, RedirectAttributes attr) { //다시 원래 페이지로 돌아가기 위해 redirect 씀 
		int empId = empService.insertEmp(empVO);
		
		String result = null;
		if(empId == -1) {
			result = "정상적으로 등록되지 않았습니다.";
		}else {
			result = "정상적으로 등록되었습니다.\n 등록된 사원의 사원번호는 " +  empId + "입니다.";
		}
		
		//두가지 방법 어떻게 표시되는지 확인해보기 두개 구분 
		//addAttribute 경로에 데이터가 저장 지속적이나 보안에 취약함
		//addFlashAttribute 세션에 데이터 저장 일회성이라 보안에 좋지만 새로고침하면 사라짐;
		//attr.addAttribute("type", "insert"); //경로에 데이터가 붙음
		//return "redirect:empList";
		attr.addFlashAttribute("result", result); //일회성 새로고침하면 데이터가 사라짐 
		
		//주의 redirect는 jsp파일을 호출하지않는다 컨트롤러 호출
		//전체조회 기능 + 페이지 호출 
		return "redirect:empList?type=insert";
		
		//아래처럼하면 조회기능 없이 페이지만 나옴
		//return "emp/empList";
	}
	//수정 : 1)단건조회 -> 2) 수정
	
	
	//수정 - Form
	@GetMapping("empUpdate")
	public String empUpdateForm(EmpVO empVO, Model model) {
		EmpVO findVO = empService.getEmp(empVO);
		model.addAttribute("empInfo", findVO);
		return "emp/empUpdate";
	}
	//수정 - Process : ajax => 필수어노테이션 : @ResponseBody
	@PostMapping("empUpdate")
	@ResponseBody
	public Map<String,String> empUpdateProcess(@RequestBody EmpVO empVO){
		
		return empService.updateEmp(empVO);
	}
	
	//삭제 - 단건삭제
	
	//삭제 - 선택삭제
}
