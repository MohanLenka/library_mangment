package com.example.FlipkartClone.security;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.FlipkartClone.entity.Users;

public class Myuserdetails implements UserDetails {
	
	String name;
	String email;
	List<GrantedAuthority> role;
	String password;
	  Myuserdetails(Users user){
		  name=user.getName();
		  email=user.getEmail();
		  password=user.getPassword();
		  role=Arrays.stream(user.getRole().split(",")).map(SimpleGrantedAuthority::new).collect(Collectors.toList());
	  }

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return role;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}

	@Override
	public String getUsername() {
		
		return email;
	}

}
