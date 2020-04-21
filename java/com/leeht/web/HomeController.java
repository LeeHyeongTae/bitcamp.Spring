package com.leeht.web;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@SpringBootConfiguration
@Controller //붙이면 자동으로 new해서 생성됨.
public class HomeController {
	@GetMapping("/")
	public String hello() {
		return "index.html";
	}
}
