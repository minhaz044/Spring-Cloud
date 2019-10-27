package com.microService.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.reactive.function.client.WebClientAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.microService.model.response.Users;

@RestController
public class HomeController {
	
	@Autowired
	public WebClient.Builder builder;
	@Autowired
	public RestTemplate restTemplate;

	
	@GetMapping("/user")
	public List<Users> getUsersInfo(){
		@SuppressWarnings("unchecked")
		Map<String,String> usersNu= builder.build()
			.get()
			.uri("http://Numeric/user") 
			.retrieve()
			.bodyToMono(Map.class)
			.block();
		 
		// @SuppressWarnings("unchecked")
		Map<String,String> usersSt= builder.build()
				.get()
				.uri("http://StringNum/user")
				.retrieve()
				.bodyToMono(Map.class)
				.block();

		System.out.println(usersNu.get(1));
		System.out.println(usersNu.get("1"));
		List<Users> users=new ArrayList<Users>();
		Users u;
		for(String eNu: usersNu.keySet() ) {
	
			for (String eSt : usersSt.keySet()) {
				if(eNu.equals(eSt)) {
					u=new Users();
					u.setId(Integer.parseInt(eSt));
					System.out.println(usersNu.get(1));
					System.out.println(usersNu.get("1"));
					u.setNuName(usersNu.get(eNu));
					u.setStName(usersSt.get(eNu));
					users.add(u);
				}
			}
			
		}
		 for (Entry<String,String> eNu : usersNu.entrySet()) {
			 for (Entry<String,String> eSt : usersSt.entrySet()) {
				 if(eSt.getKey()==eNu.getKey()){
						 u=new Users();
						// u.setId("null");
						 System.out.println(eNu.getKey());
						 u.setId(Integer.parseInt(eNu.getKey()));
						 u.setNuName(eNu.getValue());
						 u.setStName(eSt.getValue());
						 users.add(u);
					 }
			}
		}
		return users;
		
		//return null;
	}
	@GetMapping("/users")
	public Map<String, String> getUserInfo(){
		@SuppressWarnings("unchecked")
		Map<String,String> users= builder.build()
		.get()
		.uri("http://localhost:8082/user")
		.retrieve()
		.bodyToMono(Map.class)
		.block();
		return users;
	}
	
	
	@GetMapping("/test")
	public String test(){
		//Map<String,String> map= restTemplate.getForObject("http://localhost:8082/user",Map.class);
		return "OK";
	}
	
	
	

} 
