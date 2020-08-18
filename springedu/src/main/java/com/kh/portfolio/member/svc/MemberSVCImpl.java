package com.kh.portfolio.member.svc;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.kh.portfolio.member.dao.MemberDAO;
import com.kh.portfolio.member.vo.MemberVO;

@Service
public class MemberSVCImpl implements MemberSVC {
	

	private static final Logger logger = 
			LoggerFactory.getLogger(MemberSVCImpl.class);
	
	@Inject
	@Qualifier("memberDAOImplXML")
	MemberDAO memberDAO;

	//회원 등록
	@Override
	public int joinMember(MemberVO memberVO) {
		int result = 0;
		result = memberDAO.joinMember(memberVO);
		return result;
	}

	//회원 수정
	@Override
	public int modifyMember(MemberVO memberVO) {
		int result = 0;
		
		//첨부파일 존재할 시(회원 프로파일 사진) multipartfile에서 첨부파일 관련 정보 추출
		if(memberVO.getFile().getSize() > 0) {
			try {
				//파일 사이즈
				memberVO.setFsize(String.valueOf(memberVO.getFile().getSize()));
							
				//파일 유형
				memberVO.setFtype(memberVO.getFile().getContentType());
				
				//파일명
				memberVO.setFname(memberVO.getFile().getName());
				
				//첨부파일
					memberVO.setPic(memberVO.getFile().getBytes());
			} catch (IOException e) {
				e.printStackTrace();
			}			
		}
		
		result = memberDAO.modifyMember(memberVO);
		
		
		return result;
	}

	//회원 전체 조회
	@Override
	public List<MemberVO> listAllMember() {

		return null;
	}

	//회원 조회 (개인)
	@Override
	public MemberVO listOneMember(String id) {
		MemberVO memberVO = null;
		
		memberVO = memberDAO.listOneMember(id);
		
		return memberVO;
	}

	//회원 탈퇴
	@Override
	public int outMember(String id, String pw) {
		int result = 0;
		
		result = memberDAO.outMember(id, pw);
		
		return result;
	}

	//로그인
	@Override
	public MemberVO login(String id, String pw) {

		return null;
	}
	
	//아이디 찾기
	@Override
	public String findID(String tel, Date birth) {
		String id = null;
		id = memberDAO.findID(tel, birth);
		return id;
	}

	//비밀번호 찾기
	@Override
	public String findPW(String id, String tel, Date birth) {
		String pw = null;
		pw = memberDAO.findPW(id, tel, birth);
		return pw;
	}

	//비밀번호 변경
	@Override
	public int changePW(String id, String prepw, String postpw) {
		int result = 0;
		result = memberDAO.changePW(id, prepw, postpw);
		return result;
	}

	//프로파일 이미지 조회
	@Override
	public byte[] findProfileImg(String id) {
		
		return null;
	}
	
	
}
