package com.kh.portfolio.board.vo;

import java.sql.Timestamp;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class RboardVO { 
	
	@NotNull
	private long rnum; 					//	RNUM	NUMBER(10,0)	No		1	댓글 번호
	@NotNull
	private long bnum;				  //	BNUM	NUMBER(10,0)	No		2	게시글 번호 / 최초 원글
	@NotNull
	@Email
//	@Pattern(regexp="\\w+@\\w+\\.\\w+(\\.\\w+)?", 
//					 message="이메일 형식으로 입력 바랍니다. ex)test@gmail.com")
	private String rid;					//	RID	VARCHAR2(40 BYTE)	No		3	댓글 작성자 ID
	@NotNull
	@Size(min=2, max=10, message = "별칭은 최대 10자리까지 가능합니다.")
	private String rnickname;		//	RNICKNAME	VARCHAR2(30 BYTE)	Yes		4	댓글 작성자 이름(별칭)
	private Timestamp rcdate;		//	RCDATE	TIMESTAMP(6)	No	"systimestamp 5	작성일
	private Timestamp rudate;		//	RUDATE	TIMESTAMP(6)	Yes	"systimestamp 6	수정일
	@NotNull
	private String rcontent; 		//	RCONTENT	CLOB	No		7	댓글 본문 내용
	
	//선호도
	private int rgood;					//	RGOOD	NUMBER(5,0)	Yes		8	선호
	private int rbad; 					//	RBAD	NUMBER(5,0)	Yes		9	비선호
	
	//댓글 그룹
	private int rgroup;					//	RGROUP	NUMBER(5,0)	Yes		10	댓글 그룹
	private int rstep;					//	RSTEP	NUMBER(5,0)	Yes		11	댓글 단계
	private int rindent;				//	RINDENT	NUMBER(5,0)	Yes		12	댓글 들여쓰기
	
	//부모 댓글 참조
	private long prnum;					//	PRNUM	NUMBER(10,0)	Yes		13	부모 댓글 번호
	private String prid;				//	PRID	VARCHAR2(40 BYTE)	Yes		14	부모 댓글 아이디
  private String prnickname;	//	PRNICKNAME	VARCHAR2(30 BYTE)	Yes		15	부모 댓글 작성자(별칭)
  
  //프로파일 이미지
  private String ftype;				// 파일의 mime 타입, image/png
  private byte[] pic;					// 첨부 이미지 파일의 바이트 배열 
}
