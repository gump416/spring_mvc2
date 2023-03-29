package ezen.springmvc.basic.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ezen.springmvc.basic.dto.Member;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class RequestParamController {
	
	// 파라미터 조건 매핑
	@RequestMapping(value="/param-condition", method=RequestMethod.GET, params="admin=bangry")
	public String paramCondition(){
	    return "ok";
	}

	@RequestMapping("/request-param")
	public String requestParam(@RequestParam(required = true) String username,
			                   @RequestParam(required = false, defaultValue = "10") int age,
			                   @RequestParam(required = false, defaultValue = "1")  int page) {
		log.info("username={}, age={}, page={}", username, age, page);
		return "ok";
	}
	
	@RequestMapping("/model-attribute1")
	public String modelAttributeV1(@ModelAttribute Member member) {
		log.info("name={}, age={}", member.getName(), member.getAge());
		return "ok";
	}
	
	/**
	 * @ModelAttribute 생략 가능
	 * @RequestParam 도 생략할 수 있으니 혼란이 발생할 수 있다.
	 * 스프링은 해당 생략시 다음과 같은 규칙을 적용한다.
	 * String , int , Integer 같은 단순 타입 = @RequestParam 적용
	 * 나머지 = @ModelAttribute 적용
	 */
	@RequestMapping("/model-attribute2")
	public String modelAttributeV2(@ModelAttribute Member member) {
		log.info("name={}, age={}", member.getName(), member.getAge());
		return "ok";
	}
}