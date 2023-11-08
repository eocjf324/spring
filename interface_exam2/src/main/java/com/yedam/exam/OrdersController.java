package com.yedam.exam;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Handles requests for the application home page.
 */
@Controller
public class OrdersController {

	private static final Logger logger = LoggerFactory.getLogger(OrdersController.class);

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);

		return "home";
	}

	// 주문처리 핸들러 작성

	/*
	 * @RequestMapping("/insertGood")
	 * 
	 * @ResponseBody public Orders insertGood() { Orders orders = new Orders();
	 * orders.setCustomer("홍길똥"); orders.setOrd_no(100); return orders; }
	 */

	@RequestMapping("/insertGood")
	@ResponseBody
	public List<Orders> insertGood(@RequestBody List<Orders> orders) {
		System.out.println(orders);
		return orders;
	}
	
	@RequestMapping("/insertGood2")
	public ResponseEntity<Orders> insertGood2(){
		
		Orders orders = new Orders();
		orders.setCustomer("홍길똥");
		orders.setOrd_no(100);
		return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(orders);
	}

}
