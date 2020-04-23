package com.leeht.web.user;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.leeht.web.util.Messenger;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired UserService userService;
	
	@PostMapping("/signup")
	public Messenger signup(@RequestBody User user) {
		int count = userService.count();
		userService.signup(user);
		return (userService.count()==count+1)?Messenger.SUCCESS:Messenger.FAIL;
	}
	
	@PostMapping("/signin")
	public Map<String, Object> signin(@RequestBody User user) {
		Map<String, Object> returnMap = new HashMap<>();
		User signinedUser = userService.login(user);
		if(signinedUser != null) {
				returnMap.put("user", signinedUser);
				returnMap.put("messenger", Messenger.SUCCESS);
				
		}else {
				returnMap.put("messenger", Messenger.FAIL);
		}
		return returnMap;
	}
}
