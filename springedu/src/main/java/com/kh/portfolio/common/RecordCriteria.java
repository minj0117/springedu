package com.kh.portfolio.common;

import org.springframework.stereotype.Component;

import lombok.Data;

/*
 * 요청 페이지를 입력 받아 시작 레코드, 종료 레코드 구하기
 * 한 페이지에 보여줄 레코드 수 : 10이라 가정
 */
@Component
@Data
public class RecordCriteria {

	private int reqPage;			//요청 페이지
	private int numPerPage;		//한 페이지에 보여줄 레코드 수 
	
	//시작 레코드 = (요청 페이지-1) * 한 페이지에 보여줄 레코드 수 + 1
	public int getStarRec() {
		
		return (reqPage -1) * numPerPage + 1;
	}
	
	
	
	//종료 레코드 = 요청페이지 * 한 페이지에 보여줄 레코드 수 
	public int getEndRec() {
		
		
		return reqPage * numPerPage;
	}
	
	
	
	
}
