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

@Controller
@Slf4j
public class RequestJsonController {
	
	@GetMapping("/request-form")
	public String registerForm() {
		return "member/fetchRegister";
	}
	
	@PostMapping("/request-json")
	@ResponseBody
	public String processJson(@RequestBody Member member){
		log.info("회원 객체 : {}", member);
		// Member 객체를 서비스객체 이용하여 DB 등록
		return "회원등록 처리 완료...";
	}
	
	@PostMapping("/request-json2")
	@ResponseBody
	public Member processJson2(@RequestBody Member member){
		log.info("회원 객체 : {}", member);
		return member;
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






