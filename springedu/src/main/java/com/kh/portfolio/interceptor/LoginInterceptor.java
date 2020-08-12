package com.kh.portfolio.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.kh.portfolio.member.vo.MemberVO;

public class LoginInterceptor implements HandlerInterceptor {
	
	private static final Logger logger
		= LoggerFactory.getLogger(LoginInterceptor.class);
	
	//컨트롤러 수행 전
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		logger.info("LoginInterceptor.preHandle");
		//요청 URL 분석
		String uri         = request.getRequestURI();
		String contextPath = request.getContextPath();
		String reqURI      = uri.substring(contextPath.length());
		
		logger.info("요청 uri="+reqURI);
		MemberVO memberVO = (MemberVO)request.getSession().getAttribute("member");
		if(memberVO == null || memberVO.getId().isEmpty()) {
			logger.info("권한 없는 자의 접근 시도가 있음." + request.getRemoteAddr());
			response.sendRedirect(request.getContextPath()+"/loginForm?reqURI="+reqURI);
			return false;
		}		
		return true;
	}
	
	@Override
		public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
				ModelAndView modelAndView) throws Exception {
		logger.info("LoginInterceptor.postHandle");
			HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
		}
	
	@Override
		public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
				throws Exception {
		logger.info("LoginInterceptor.afterCompletion");
			HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
		}
}
