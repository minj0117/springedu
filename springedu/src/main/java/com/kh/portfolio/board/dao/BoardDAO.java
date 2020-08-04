package com.kh.portfolio.board.dao;

import java.util.List;

import com.kh.portfolio.board.vo.BoardFileVO;
import com.kh.portfolio.board.vo.BoardVO;

public interface BoardDAO {
	
	//게시글 작성
	int write(BoardVO boardVO);
	
	//게시글 수정
	int modify(BoardVO boardVO);
	
	//게시글 삭제
	int delete(String bnum);
	
	//게시글 보기
	BoardVO view(String bnum);
	
	//게시글 목록
	List<BoardVO> list();

	//파일 첨부
	int addFile(BoardFileVO boardFileVO);

	//첨부파일 조회
	List<BoardFileVO> getFiles(String bnum);

	//첨부파일 조회수+ 1증가
	void updateBhit(String bnum);
	
}
