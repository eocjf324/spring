package com.yedam.app.board;

import java.util.Date;

import lombok.Data;

@Data
public class BoardVO {
	
	private String bno;
	private String title;
	private String contents;
	private String writer;
	private Date   regdate;
	private Date   updateDate;
	private Date   updatedate;
	private String image;

}
