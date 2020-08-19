package com.kh.portfolio.board.svc;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.kh.portfolio.board.dao.RboardDAO;
import com.kh.portfolio.board.dao.RboardDAOImplXML;
import com.kh.portfolio.board.vo.RboardVO;

@Service
public class RboardSVCImpl implements RboardSVC {
	
	private static final Logger logger =
			LoggerFactory.getLogger(RboardDAOImplXML.class);
	
	@Inject
	RboardDAO rboardDAO;

	
	//댓글 작성
	@Override
	public int write(RboardVO rboardVO) {

		return 0;
	}

	//댓글 수정
	@Override
	public int modify(RboardVO rboardVO) {
	
		return 0;
	}

	
	//댓글 삭제
	@Override
	public int delete(Long rnum) {

		return 0;
	}

	
	//댓글 목록
	@Override
	public List<RboardVO> list() {

		return null;
	}

}
