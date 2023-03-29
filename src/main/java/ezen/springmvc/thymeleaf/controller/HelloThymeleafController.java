package ezen.springmvc.thymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class HelloThymeleafController {
	
	@GetMapping("/thymeleaf/hello")
	public String hello(Model model) {
		model.addAttribute("message1", "안녕. 타입리프!!!!");
		model.addAttribute("message2", "<strong>안녕. 타입리프!!!!</strong>");
		return "hello"; //
	}
}
