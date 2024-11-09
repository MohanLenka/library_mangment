package com.example.FlipkartClone.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.FlipkartClone.entity.Users;
import com.example.FlipkartClone.repository.userrepo;
@Service
public class Myuserdetailsserver implements UserDetailsService {

	                     
	@Autowired
	userrepo userrepo;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	
		Optional<Users> users=userrepo.findByEmail(username);
		Users user=users.get();
		return  users.map(Myuserdetails::new)
				.orElseThrow(()-> new UsernameNotFoundException("user not found"));
	}

}
