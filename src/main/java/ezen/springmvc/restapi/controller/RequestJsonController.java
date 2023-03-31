package ezen.springmvc.restapi.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ezen.springmvc.basic.dto.Member;
import lombok.extern.slf4j.Slf4j;

@Controller  //json일지 view일지 모르기때문에 @RestController써주면 안됨
@Slf4j
public class RequestJsonController {
	
	@GetMapping("/request-form")
	public String registerForm() {
		return "member/fetchRegister";
	}
	
	@PostMapping("/request-json")
	@ResponseBody
	public String processJson(@RequestBody Member member){ //@RequestBody의 장점은 Member만 선언해주면 jackson라이브러리를 통해서 알아서 들어옴, Gson에서 했던 작업들을, 선언으로 끝냄
		log.info("회원 객체 : {}", member);
		// Member 객체를 서비스객체 이용하여 DB 등록
		return "회원등록 처리 완료..."; //@ResponseBody 이게 없으면 논리적view이름 -> member-result로 바꿔줘야함
	}
	
	@PostMapping("/request-json2")
	@ResponseBody  //1.주고받고자하는 데이터만 선언해주면  
	public Member processJson2(@RequestBody Member member){ //2.Member ->json
		log.info("회원 객체 : {}", member);
		return member; //3.json ->Member 작업 다해줌
	}
	
	@GetMapping("/request-json3")
	@ResponseBody
	public List<Member> processJson3(){
		List<Member> members = new ArrayList<>();
		members.add(new Member("bangry1", "1111", "김기정1", 10));
		members.add(new Member("bangry2", "1111", "김기정2", 10));
		members.add(new Member("bangry3", "1111", "김기정3", 10));
		return members;
	}
}






