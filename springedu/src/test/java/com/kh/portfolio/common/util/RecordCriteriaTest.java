package com.kh.portfolio.common.util;

import javax.inject.Inject;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.kh.portfolio.common.page.RecordCriteria;
import com.kh.portfolio.member.dao.MemberDAOImplJDBCTest;

import lombok.Data;

/*
 * 
 *  
 */
@Data
public class RecordCriteriaTest {

	private static final Logger logger = 
			LoggerFactory.getLogger(MemberDAOImplJDBCTest.class);
	

	
	@Inject
	RecordCriteria recordCriteria;
	
	@Test
	void test() {
		recordCriteria.setReqPage(3);
		recordCriteria.setRecNumPerPage(10);

		logger.info("시작 레코드: " + recordCriteria.getStartRec());
		logger.info("종료 레코드: " + recordCriteria.getEndRec());
	}
}
