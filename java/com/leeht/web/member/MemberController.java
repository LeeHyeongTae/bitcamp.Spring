package com.leeht.web.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.leeht.web.util.Messenger;

@RestController //url을 처리하는 @.
@RequestMapping("/member")
public class MemberController {
	@Autowired MemberService memberService;
	
	@PostMapping("/join")
	public Messenger add(@RequestBody Member member) {//controller는 무조건 응답이 있어야함!!
		int current = memberService.count();
		memberService.add(member);
		int count = memberService.count();
		return (count == current+1)?Messenger.SUCCESS:Messenger.FAIL;
	}
	
	@PostMapping("/login")
	public Messenger login(@RequestBody Member member) {
    return (memberService.login(member))? Messenger.SUCCESS:Messenger.FAIL;
	}
	
	@GetMapping("/list")
	public Member[] list() {
		Member[] memberList = new Member[memberService.count()];
		memberList = memberService.list();
		return memberList;
	}
	@GetMapping("/detail")
	public Member detail(@RequestBody Member member) {
		Member returnMember = null;
		returnMember = memberService.detail(member.getUserid());
		return returnMember;
	}
	
	@GetMapping("/count")
	public int count() {
		int returnCount = 0;
		returnCount = memberService.count();
		return returnCount;
	}
	
	@PutMapping("/update")
	public Member update(@RequestBody Member member) {
		Member returnMember = new Member();
		return returnMember;
	}
	
	@DeleteMapping("/delete")
	public Member delete(@RequestBody Member member) {
		Member returnMember = new Member();
		return returnMember;
	}
}
