package ezen.springmvc.basic.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.slf4j.Slf4j;

@RestController
// 응답메시지 바디에 바로 출력(API 서비스시 사용)
// Postman 요청 테스트
@Slf4j 
public class RequestMappingController {

	/**
	 * 다중 매핑 가능 HTTP 모든 요청방식 허용 (GET, HEAD, POST, PUT, PATCH, DELETE) Postman으로 테스트
	 */
	@RequestMapping(value = { "/hello-basic", "/hello-go" })
	public String helloBasic() {
		log.info("helloBasic");
		// @RestController는 반환 값으로 뷰를 찾는 것이 아니라, HTTP 응답 메시지 바디에 바로 출력한다.
		// "ok" 출력
		return "ok";
	}

	/**
	 * 특정 요청방식만 허용 GET, HEAD, POST, PUT, PATCH, DELETE
	 */
	@RequestMapping(value = "/mapping-get", method = RequestMethod.GET)
	public String mappingGet() {
		log.info("mappingGet");
		return "ok";
	}

	/**
	 * 편리한 축약 애노테이션
	 * @GetMapping
	 * @PostMapping
	 * @PutMapping
	 * @DeleteMapping
	 * @PatchMapping
	 */
	@PostMapping("/mapping-post")
	// @RequestMapping과 method 속성을 지정해서 사용하는 것을 확인할 수 있다.
	public String mappingPost() {
		log.info("mapping-post");
		return "ok";
	}

	/**
	 * PathVariable 사용 
	 * 변수명이 같으면 생략 가능
	 * @PathVariable("userId") String userId -> @PathVariable userId
	 */
	@GetMapping("/mapping/{userId}")
	// public String mappingPath(@PathVariable("userId") String id) {
	public String mappingPath(@PathVariable String userId) {
		log.info("mappingPath userId={}", userId);
		return "ok";
	}
	
	/**
	 * PathVariable 사용 다중 매핑 가능
	 */
	@GetMapping("/mapping/users/{userId}/orders/{orderId}")
	public String mappingPath(@PathVariable String userId, @PathVariable int orderId) {
		log.info("mappingPath userId={}, orderId={}", userId, orderId);
		return "ok";
	}
	
	/**
	 * 특정 파라미터 조건 매핑
	 * params="mode",
	 * params="!mode"
	 * params="mode=debug"
	 * params="mode!=debug" (! = )
	 * params = {"mode=debug","data=good"}
	 */
	@GetMapping(value = "/mapping-param", params = "mode=debug")
	public String mappingParam() {
		log.info("mappingParam");
		return "ok";
	}
	
	/**
	 * 특정 헤더 조건 매핑
	 * headers="mode",
	 * headers="!mode"
	 * headers="mode=debug"
	 * headers="mode!=debug" (! = )
	 */
	@GetMapping(value = "/mapping-header", headers = "mode=debug")
	public String mappingHeader() {
	 log.info("mappingHeader");
	 return "ok";
	}

}