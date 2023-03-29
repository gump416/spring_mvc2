package ezen.springmvc.restapi.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.io.Writer;
import java.nio.charset.StandardCharsets;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.slf4j.Slf4j;

/**
 * 자바스크립트 비동기요청(ajax)에 대한 API 서비스 컨트롤러 예제
 */
@Controller
@Slf4j
public class RequestBodyController {
	
	/*
	@PostMapping("/request-body")
	public void processRequestBody(InputStream in, Writer out) throws IOException{
//		in.read();
		// Spring이 지원하는 스트림 관련 Util 클래스 활용
		String bodyMessage = StreamUtils.copyToString(in, StandardCharsets.UTF_8);
		log.info("요청메시지 바디 : {}", bodyMessage);
		out.write("ok");
	}
	*/
	
	@PostMapping("/request-body")
	public HttpEntity<String> processRequestBody(HttpEntity<String> httpEntity){
		String message = httpEntity.getBody();
		log.info("요청메시지 바디 : {}", message);
		return new HttpEntity<String>("반갑습니다. 클라이언트...");
	}
	
	@PostMapping("/request-body2")
	public ResponseEntity<String> processRequestBody(RequestEntity<String> httpEntity){
		String message = httpEntity.getBody();
		log.info("요청메시지 바디 : {}", message);
		return new ResponseEntity<String>("반갑습니다. 클라이언트...", HttpStatus.OK);//200
	}
	
	@PostMapping("/request-body3")
	@ResponseBody
	public String processRequestBody(@RequestBody String bodyMessage){
		log.info("요청메시지 바디 : {}", bodyMessage);
		return "반갑습니다. 클라이언트님...";
	}
}






