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
		String message = httpEntity.getBody(); //위에 주석처리한 작업을 더 쉽게 해줌
		log.info("요청메시지 바디 : {}", message);
		return new HttpEntity<String>("반갑습니다. 클라이언트...");
	}
	
	@PostMapping("/request-body2")
	public ResponseEntity<String> processRequestBody(RequestEntity<String> httpEntity){
		String message = httpEntity.getBody();
		log.info("요청메시지 바디 : {}", message);
//		return new ResponseEntity<String>("반갑습니다. 클라이언트...", HttpStatus.CREATED);//201
		return new ResponseEntity<String>("반갑습니다. 클라이언트...", HttpStatus.OK);//200 //위에꺼랑 다르게 ok 같은 추가적인 정보 입력가능
	}
	
	@PostMapping("/request-body3")
	@ResponseBody //응답도 어노테이션으로...
	public String processRequestBody(@RequestBody String bodyMessage){
		//string타입으로 body메세지 인자로 넣어주면됨, 더 간단, 응답메세지 추가적으로 보내고싶을때는 body2방법써도됨,
		//근데 바디에 응답메세지 포함 가능이라 굳이 body2방법 안씀
		log.info("요청메시지 바디 : {}", bodyMessage);
		return "반갑습니다. 클라이언트님...";
	}
}






