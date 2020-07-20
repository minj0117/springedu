package com.kh.portfolio.test;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.function.ServerRequest.Headers;

@Controller
@RequestMapping(value = "/test")
public class TestController {
	private static final Logger logger 
		= LoggerFactory.getLogger(TestController.class);

	@GetMapping(value = "/1")
	public String test(Model model) {

		logger.info("public String test() 요청됨!");

		model.addAttribute("name", "홍길동");
		model.addAttribute("age", 30);
		return "test";
	}
	
	@GetMapping(value = "/2")
	public String test2(Model model) {

		logger.info("public String test() 요청됨!");

		model.addAttribute("name", "홍길순");
		model.addAttribute("age", 20);
		return "test";
	}
	
	@GetMapping(value = {"/3", "/4", "/5"})
	public String test3() {
		
		logger.info("public String test3() 요청됨!");
		return "test";
	}
//한번에 두 가지 방식 적용 안 됨	
//	@PostMapping(value="/6")
//	@GetMapping(value="/6")
//두 개를 하나로 
	@RequestMapping(value="/6", method = RequestMethod.GET)
	public String test4() {
		
		logger.info("public String test4() 요청됨!");
		return "test";
	}
	
	@GetMapping("/7")
	public String test5() {
		
		logger.info("public String test5() 요청됨!");
		return "redirect:http://www.naver.com";
	}
	
	@GetMapping("/8")
	public void test6(HttpServletRequest request) {
		logger.info("public String test6() 요청됨!");
		
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		logger.info(name+":"+age);
		
	}
	
	
	//사람 검색 화면
	@GetMapping("/person")
	public String findPerson() {
		
		return "findPersonService";
	}
	
	
	
	
	

}
