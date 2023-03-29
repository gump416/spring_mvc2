package ezen.springmvc.basic.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class LogTestController { 
	
	//private Logger log = LoggerFactory.getLogger(getClass());
	//private Logger log = LoggerFactory.getLogger(LogTestController.class);
	
	@RequestMapping("/springmvc/log-test")
	public ModelAndView logTest() {
		String name = "Spring MVC";
		// 시스템 콘솔에 출력
		System.out.println("name = " + name);
		
		// 로그레벨별 출력
		// application.properties 파일에 설정한 로그 레벨에 따라 출력
		// 코드 수정 없이 로그레벨 설정만으로 로그를 조절할 수 있는 장점이 있다
		log.trace("name = {}", name);
		log.debug("name = {}", name);
		log.info("name = {}, {}, {}", name, "김기정", "바보");
		log.warn("name = {}", name);
		log.error("name = {}", name);
		
		// 주의사항
		// 로그레벨이 info로 설정되어 있는 경우 trace는 출력되지 않지만 '+' 연산자는 수행된다(CPU, 메모리 사용)
		// 성능 저하 요인
		log.trace("name = " + name);
		
		return new ModelAndView("log-test");
	}
}

//로그 사용시 장점
//1. 쓰레드 정보, 클래스 이름 같은 부가 정보를 함께 볼 수 있고, 출력 모양을 조정할 수 있다.
//2. 로그 레벨에 따라 개발 서버에서는 모든 로그를 출력하고, 운영서버에서는 출력하지 않는 등 로그를 상황에 맞게 조절할 수 있다.
//3. 시스템 콘솔에만 출력하는 것이 아니라, 파일이나 네트워크 등 로그를 별도의 대상에 남길 수 있다. 
//4. 특히 파일로 남길 때는 일별, 특정 용량에 따라 로그를 분할하는 것도 가능하다.
//5. 성능도 일반 System.out보다 훨씬 좋다(내부 버퍼링, 멀티 쓰레드 등등)
// 실무에서는 반드시  로그를 사용해야 한다.
