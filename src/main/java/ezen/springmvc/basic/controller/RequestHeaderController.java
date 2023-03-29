package ezen.springmvc.basic.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.http.HttpMethod;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j 
public class RequestHeaderController {
	@RequestMapping("/headers")
	public String headers(HttpServletRequest request, 
			              HttpServletResponse response, 
			              HttpMethod httpMethod,
			              @RequestHeader MultiValueMap<String, String> headerMap, 
			              @RequestHeader("host") String host,
			              @CookieValue(value = "myCookie", required = false, defaultValue = "bangry") String myCookie) {
		log.info("request={}", request);
		log.info("response={}", response);
		log.info("httpMethod={}", httpMethod);
		log.info("headerMap={}", headerMap);
		log.info("header host={}", host);
		log.info("myCookie={}", myCookie);
		return "ok";
	}
}