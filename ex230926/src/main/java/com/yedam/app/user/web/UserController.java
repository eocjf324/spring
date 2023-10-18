package com.yedam.app.user.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yedam.app.user.service.UserVO;

@CrossOrigin("*")
@Controller
public class UserController {
	
	@GetMapping("getAjax")
	@ResponseBody //페이지말고 데이터 넘겨줌 비동기방식에서 무조건 씀
	public Map<String, Object> insertGetAjax(UserVO userVO){
		Map<String, Object> map = new HashMap<>();
		map.put("result", true);
		map.put("data", userVO);
		
		return map;
	}
	
	@PostMapping("postAjax")
	@ResponseBody
	public Map<String, Object> insertPostAjax(UserVO userVO){
		Map<String, Object> map = new HashMap<>();
		map.put("result", true);
		map.put("data", userVO);
		
		return map;
	}
	
	@PostMapping("jsonAjax")
	@ResponseBody
	public Map<String, Object> insertJsonAjax(@RequestBody List<UserVO> userVO){
		Map<String, Object> map = new HashMap<>();
		map.put("result", true);
		map.put("data", userVO);
		
		return map;
	}
}
