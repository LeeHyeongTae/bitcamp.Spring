package com.leeht.web.member;

public interface MemberService {
	public void add(Member member);
	public Member[] list();
	public Member detail(String userid);
	public Member login(Member member);
	public int count();
	public void update(Member member);
	public void delete(Member member);
}
