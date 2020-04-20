package com.leeht.web.member;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController //url을 처리하는 @.
public class MemberController {
	public MemberService memberService;
	
	@PostMapping("/join")
	public String add(@RequestBody Member member) {//controller는 무조건 응답이 있어야함!!
		System.out.println(">>>>");
		System.out.println(member.toString());
		memberService = new MemberServiceImpl();
		memberService.add(member);
		return member.getName();
	}
}
