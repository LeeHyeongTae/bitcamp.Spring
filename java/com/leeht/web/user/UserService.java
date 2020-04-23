package com.leeht.web.user;

public interface UserService {

	public void signup(User user);

	public int count();

	public User login(User user);
	public User detail(String userid);

}
