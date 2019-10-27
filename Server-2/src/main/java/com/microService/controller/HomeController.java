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
		users.put(1, "One");
		users.put(2, "Two");
		users.put(3, "Three");
		users.put(4, "Four");
		return users;
		
	}
	@GetMapping("/user")
	public Map<Integer, String> Users(){
		return getUsers();
	}
	

}
