package com.microService.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	public Map<Integer, String> users;
	public Map<Integer, String> getUsers() {
		return users==null? setUsers():users;
	}
	private Map<Integer, String> setUsers() {
		users=new HashMap<Integer,String>();
		users.put(1, "1");
		users.put(2, "2");
		users.put(3, "3");
		users.put(4, "4");
		return users;
		
	}
	@GetMapping("/user")
	public Map<Integer, String> Users(){
		return getUsers();
	}
	

}
