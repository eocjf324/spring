package com.yedam.exam;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class SlipServiceImpl implements SlipService{

	@Autowired	SlipDAO dao;
	
	@Override
	public List<String> insertSlip(List<Slip> slip) {
		List<String> errList = new ArrayList<String>();
		
		//테이블 입력
		for(Slip item : slip) {
			if(item.getSlipAmount() < 20000) {
				item.setSlipAmount(20000);
				errList.add(item.getCustomer().split("_")[0]);
			}
			dao.insertSlip(item);
		}
		return errList;  // 처리 건수 리턴;
	}
}
