package com.example.FlipkartClone.Controller;

import java.util.Optional;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import com.example.FlipkartClone.entity.Users;
import com.example.FlipkartClone.jwtserver.Jwtserver;
import com.example.FlipkartClone.repository.userrepo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@CrossOrigin
public class Usercontroller {

	@Autowired
	userrepo repo;
	@Autowired
	Jwtserver jwt;
	@Autowired
	AuthenticationManager authmanager;
	@GetMapping("/public")
	String get() {
		return "jgvnbvj";
	}
	@GetMapping("/public/login")
	public String getMethodName(@RequestBody Users user) {
	
org.springframework.security.core.Authentication auth=authmanager.authenticate(new UsernamePasswordAuthenticationToken(user.getEmail(),user.getPassword()));
		if(auth.isAuthenticated()) {
			
			Optional<Users> users=repo.findByEmail(user.getEmail());
		String token=jwt.createjwt(users.get().getEmail());
		return token;
		}
		return "";
	}
	
	@GetMapping("/admin/user")
	public String getMethodName() {
		return "authenticated api";
	}
	
}
