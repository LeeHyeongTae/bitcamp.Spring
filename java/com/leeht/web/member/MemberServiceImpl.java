package com.leeht.web.member;

public class MemberServiceImpl implements MemberService{
	private Member[] members;
	private int count;
	public MemberServiceImpl() {
		members = new Member[5];
		count =0;
	}
	@Override
	public void add(Member member) {
		members[count] = member;
		count++;
	}
	@Override
	public Member detail(String userid) {
		Member returnMember =null;
		for(int i=0; i<count; i++) {
			if(userid.equals(members[i].getUserid())) {
				returnMember = members[i];
				break;
			}
		}
		return returnMember;
	}
//	@Override
//	public Member[] searchByName(String name) {
//		Member[] nameMembers = new Member[count(name)];
//		int j=0;
//		if(count(name)!=0) {
//			for(int i=0; i<count; i++) {
//				if(name.equals(members[i].getName())) {
//					nameMembers[j] = members[i];
//					j++;
//				}
//				if(count(name)==j) {
//					break;
//				}
//			}
//		}
//		return nameMembers;
//	}
	@Override
	public Member[] list() {
		
		return members;
	}
	@Override
	public int count() {
		
		return count;
	}
//	@Override
//	public int count(String name) {
//		int returnCount =0;
//		for(int i=0; i<count; i++) {
//			if(name.equals(members[i].getName())) {
//				returnCount++;
//			}
//		}
//		
//		return returnCount;
//	}
	@Override
	public void update(Member member) {
		for(int i=0; i<count; i++) {
			if(member.getUserid().equals(members[i].getUserid())) {
				members[i].setPassword(member.getPassword());
				break;
			}
		}
	}
	@Override
	public void delete(Member member) {	
		for(int i=0; i<count; i++) {
			if(member.getUserid().equals(members[i].getUserid()) && 
					member.getPassword().equals(members[i].getPassword())) {
				members[i] = members[count-1];
				members[count-1] = null;
				count--;
			}
		}
	}
}
