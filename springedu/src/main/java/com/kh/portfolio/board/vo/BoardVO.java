package com.kh.portfolio.board.vo;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class BoardVO {

	private long bnum;													//	BNUM	NUMBER(10,0)	No		1	게시글 번호 
	private BoardCategoryVO boardCategoryVO; 		//	BCATEGORY	NUMBER(10,0)	Yes		2	분류 카테고리
	private String btitle;											//	BTITLE	VARCHAR2(150 BYTE)	Yes		3	제목
  private String bid;													//	BID	VARCHAR2(40 BYTE)	Yes		4	작성자ID
  private String bnickname;										//	BNICKNAME	VARCHAR2(30 BYTE)	Yes		5	별칭
  private Timestamp bcdate;										//	BCDATE	TIMESTAMP(6)	Yes	"systimestamp"6	작성일
  private Timestamp budate;										//	BUDATE	TIMESTAMP(6)	Yes	"systimestamp"	7	수정일
  private	int bhit;														//	BHIT	NUMBER(5,0)	Yes	"0"	8	조회수
	private String bcontent;										//	BCONTENT	CLOB	Yes		9	본문 내용
	private int bgroup;													//	BGROUP	NUMBER(5,0)	Yes		10	답글 그룹
	private int step; 													//	BSTEP	NUMBER(5,0)	Yes		11	답변글의 단계
	private int bindent;												//	BINDENT	NUMBER(5,0)	Yes		12	답변글의 들여쓰기
	
	//첨부파일
	private List<MultipartFile> files;
	
	
	
}
