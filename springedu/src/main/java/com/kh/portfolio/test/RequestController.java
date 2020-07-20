package com.kh.portfolio.test;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/req")
public class RequestController {

	private static Logger logger=
			LoggerFactory.getLogger(RequestController.class);
	
	//1)HttpRequest 객체 이용
	@GetMapping("/1")
	public void req1(HttpServletRequest req) {
		logger.info("void req1() 호출됨!");
		
		String name = req.getParameter("name");
		String age = req.getParameter("age");
		
		logger.info("name="+name);
		logger.info("age="+Integer.parseInt(age));		
	}
	
	//2) @RequestParam 사용
	@GetMapping("/2")
	public void req2(@RequestParam("name") String rename, @RequestParam("age") int reage) {
		logger.info("void req2() 호출됨!");

		logger.info("name=" + rename);
		logger.info("age=" + reage);		
	}
	
	@GetMapping("/3")
	public void req3(@RequestParam Map<String, String> map) {
		logger.info("void req3() 호출됨!");

		logger.info("name=" + map.get("name"));
		logger.info("age=" + map.get("age"));		
	}
	
	//3) 사용자 정의 클래스에 바인딩
	@GetMapping("/4")
	public void req4(Person person) {
		logger.info("void req4() 호출됨!");

		logger.info("name=" + person.getName());
		logger.info("age=" + person.getAge());		
	}
	
	//4) 복수의 요청 url에 대해 하나의 메소드에서 처리하고자할 때
	@GetMapping(value={"/5", "/6", "/7"})	
	//반환 타입이 void인 경우 view 이름: 요청 URL에서 컨텍스트 루트 다음 경로의 view이름을 찾는다.
	public void req5() { 
		logger.info("void req5() 호출됨!");
	}
	
	//--서버응답 forward, redirect
	
	//1. forward  
	// client 요청 횟수 : 1회
	// request, response 객체 : 공유됨.
	// 사용범위 : 같은 Web Application 내에서만
	//--------------------------------------------
	//2. redirect  
	// client 요청 횟수 : 2회
	// request, response 객체 : 공유가 안 됨.
	// 사용범위 :모든 범위(Web Application이 다르거나, 외부 서버 요청 포함)
	// **중요 : 클라이언트 요청이 서버의 변경을 요청하는 경우 반드시 요청 처리 후 사용해 줄 것!
	@GetMapping("/8")
	public String req6(Model model) {
		
		model.addAttribute("key", "value");
		return "/req/7"; //경로를 포함해 view이름을 지정해줘야 한다.
//		return "forward:/req/7"; //forward 요청 시 '/' 루트 지정해야 한다.
//		return "redirect:/req/7";
//		return "redirect:http://www.naver.com";  허용됨
//		return "forward:http://www.naver.com"; //허용 안 됨.
	}
	
	//컨트롤러 데이터를 리다이렉트 페이지에서 참조하고자 할 때 RedirectAttributes 사용
	@GetMapping("/9")
	public String req7(Model model, RedirectAttributes redirectAttrs) {
		
		//model.addAttribute("key", "value");
		redirectAttrs.addFlashAttribute("key", "value");
		return "redirect:/req/7";
	}	
	
	// url 경로명을 파라미터로 사용하고자 할 때(주로 Restfull 서비스 구현 시 사용)
	@GetMapping("/10/{name}/{age}")
	public String req8(
			@PathVariable("name") String name, 
			@PathVariable("age") String age,
			Model model
			) {
		
		model.addAttribute("name", name);
		model.addAttribute("age", age);
		
		return "test";
	}
	
	//ModelAndView 사용
	@GetMapping("/11/{name}/{age}")
	public ModelAndView req9(
			@PathVariable("name") String name, 
			@PathVariable("age") String age			
			) {
		
		ModelAndView mav = new ModelAndView();
		
		//뷰정보
		mav.setViewName("test");
		//모델정보
		mav.addObject("name", name);
		mav.addObject("age", age);
		
		return mav;
	}
	
}





















