package com.kh.portfolio.board.vo;

import javax.persistence.Entity;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Data
public class VoteVO {
	
	@NotNull
	private long rnum; 				//	RNUM	NUMBER(10,0)	No		1	댓글 번호
	@NotNull
	private long bnum;				//	BNUM	NUMBER(10,0)	No		2	게시글 번호(최초 원글)
//	@NotNull
	@Email
	private String rid; 			//	RID	VARCHAR2(40 BYTE)	No	3	댓글 아이디
	@NotNull
	private Vote vote;				//	VOTE	CHAR(1 BYTE)	No		4	'1':호감, '2':비호감

}
