package kr.co.fastcampus.eatgo.interfaces;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

	
	//접속하면 바로 hello메서드 실행 /현재경로. 
	//GETmapping url접근
	//localhost:8083으로 접근하면 hello world가 출력된다 화면에
	
	@GetMapping("/")
	public String hello() {
		return "Hello, World!!!";
	}
	
}
