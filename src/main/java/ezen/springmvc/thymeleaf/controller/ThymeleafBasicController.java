package ezen.springmvc.thymeleaf.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ezen.springmvc.basic.dto.Member;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("/thymeleaf")
public class ThymeleafBasicController {

	@GetMapping("/variable")
	public String variableExample(Model model) {
		Member member1 = new Member("chulsu", "1111", "철수", 10);
		Member member2 = new Member("young", "1111", "영희", 20);

		List<Member> list = new ArrayList<Member>();
		list.add(member1);
		list.add(member2);

		Map<String, Member> map = new HashMap<String, Member>();
		map.put("member1", member1);
		map.put("member2", member2);

		model.addAttribute("member", member1);
		model.addAttribute("list", list);
		model.addAttribute("map", map);
		return "basic/variable";
	}
	
	@GetMapping("/literal")
	public String literalExample(Model model) {
		model.addAttribute("message", "Thymeleaf에서 리터럴 처리");
		return "basic/literal";
	}
	
	@GetMapping("/operation")
	public String operationExample(Model model) {
		model.addAttribute("message", "Spring MVC Thymeleaf");
		model.addAttribute("name", null);
		return "basic/operation";
	}

	@GetMapping("/default-object")
	public String objectExample(HttpSession httpSession, RedirectAttributes redirectAttributes) {
		httpSession.setAttribute("loginId", "bangry");
		redirectAttributes.addAttribute("name", "bangry");
		return "redirect:default-object2"; //redirect기억안나면 명시적으로 ?name="bangry"파라미터입력가능,비권장
	}
	
	@GetMapping("/default-object2")
	public String objectExample2() {
		return "basic/default-object";
	}

	@Component("helloBean")
	static class HelloBean {
		public String hello(String data) {
			return "Hello " + data;
		}
	}

	@GetMapping("/default-utils")
	public String dateExample(Model model) {
		model.addAttribute("today", Calendar.getInstance());
		model.addAttribute("localDateTime", LocalDateTime.now());
		return "basic/utils";
	}

	@GetMapping("/url")
	public String urlExammple(Model model) {
		model.addAttribute("param1", "value1");
		model.addAttribute("param2", "value2");
		return "basic/url";
	}

	@GetMapping("/attribute")
	public String attribute() {
		return "basic/attribute";
	}

	@GetMapping("/each")
	public String each(Model model) {
		Member member1 = new Member("chulsu", "111", "철수", 10);
		Member member2 = new Member("younghee", "111", "영희", 20);
		Member member3 = new Member("chanho", "111", "찬호", 30);
		List<Member> list = new ArrayList<>();
		list.add(member1);
		list.add(member2);
		list.add(member3);
		model.addAttribute("members", list);
		return "basic/each";
	}
	
	@GetMapping("/condition")
	public String conditionExample(Model model) {
		Member member1 = new Member("chulsu", "111", "철수", 10);
		Member member2 = new Member("younghee", "111", "영희", 20);
		Member member3 = new Member("chanho", "111", "찬호", 30);
		List<Member> list = new ArrayList<Member>();
		list.add(member1);
		list.add(member2);
		list.add(member3);
		
		model.addAttribute("score", 88);
		model.addAttribute("members", list);
		return "basic/condition";
	}
	
	@GetMapping("/block")
	public String blockExample(Model model) {
		Member member1 = new Member("chulsu", "111", "철수", 10);
		Member member2 = new Member("younghee", "111", "영희", 20);
		Member member3 = new Member("chanho", "111", "찬호", 30);
		List<Member> list = new ArrayList<>();
		list.add(member1);
		list.add(member2);
		list.add(member3);
		model.addAttribute("members", list);
		return "basic/block";
	}
	
		
	@GetMapping("/index")
	public String main() {
		return "basic/index";
	}
	
	@GetMapping("/index2")
	public String main2() {
		return "basic/index2";
	}
	
	@GetMapping("/index3")
	public String main3() {
		return "basic/index3";
	}

	@GetMapping("/boards")
	public String boards() {
		return "basic/boards";
	}





}
