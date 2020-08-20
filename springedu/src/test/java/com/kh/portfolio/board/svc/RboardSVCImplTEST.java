package com.kh.portfolio.board.svc;

import javax.inject.Inject;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.kh.portfolio.board.dao.RboardDAOImplXMLTEST;
import com.kh.portfolio.board.vo.RboardVO;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/*.xml"})
public class RboardSVCImplTEST {

	private static final Logger logger = 
			LoggerFactory.getLogger(RboardDAOImplXMLTEST.class);
	
	@Inject
	RboardSVC rboardSVC;
	
	@Test
	@DisplayName("대댓글 작성")
	void reply () {
		
		RboardVO rboardVO = new RboardVO();
		
		rboardVO.setPrnum((long)30);
		rboardVO.setBnum((long)470);
		rboardVO.setRid("test@test.com");
		rboardVO.setRcontent("30번 댓글에 대한 대댓글 작성 테스트" );
		
		rboardSVC.reply(rboardVO);
	}
}

















