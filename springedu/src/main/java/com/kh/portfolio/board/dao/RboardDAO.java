package com.kh.portfolio.board.dao;

import java.util.List;

import com.kh.portfolio.board.vo.RboardVO;

public interface RboardDAO {
	
	//댓글 작성
	int write(RboardVO rboardVO);
	
	//댓글 수정
	int modify(RboardVO rboardVO);
	
	//댓글 삭제
	int delete(Long rnum);
	
	//댓글 목록
	List<RboardVO> list();
	
}