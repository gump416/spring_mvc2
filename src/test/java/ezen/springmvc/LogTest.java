package ezen.springmvc;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
class LogTest {
	//private Logger log = LoggerFactory.getLogger(getClass());
	@Test
	void logTest() {
		String name = "Spring MVC";
		log.trace("name = {}", name);
		log.debug("name = {}", name);
		log.info("name = {}", name);
		log.warn("name = {}", name);
		log.error("name = {}", name);
	}

}
