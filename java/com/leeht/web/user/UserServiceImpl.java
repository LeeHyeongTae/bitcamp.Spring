package com.leeht.web.user;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
	private Map<String, Object> map;
	
	public UserServiceImpl() {
		map = new HashMap<>();
	}
	@Override
	public void signup(User user) {
		map.put(user.getUserid(), user);
	}
	@Override
	public int count() {
		return map.size();
	}
	@Override
	public User login(User user) {
		User returnUser = null;
		if(map.containsKey(user.getUserid())) {
			User u = detail(user.getUserid());
			if(user.getPassword().equals(u.getPassword())) {
				returnUser = u;
			}
		}
		
		return returnUser;
	}
	@Override
	public User detail(String userid) {
		return (User) map.get(userid);
	}

}
