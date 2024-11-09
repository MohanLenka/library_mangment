package com.example.FlipkartClone.jwtserver;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.filter.OncePerRequestFilter;

import com.example.FlipkartClone.security.Myuserdetailsserver;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

	@Component
	public class Jwtauth extends OncePerRequestFilter {

		@Autowired
		Jwtserver jwtser;
		@Autowired
		Myuserdetailsserver userser;
		@Override
		protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
				throws ServletException, IOException {
			// TODO Auto-generated method stub
			String username=null;
		String token=null;
		   
			String header=request.getHeader("Authorization");
			
			if(header!=null && header.startsWith("Bearer")) {
				
				token=header.substring(7);
	            username=jwtser.Extractusername(token);
	            
			}
			if(username!=null && SecurityContextHolder.getContext().getAuthentication()==null) {
				
				UserDetails userdetails=userser.loadUserByUsername(username);
			
				if(userdetails.getUsername().equals(username) && jwtser.validatetoken(token)) {
					UsernamePasswordAuthenticationToken usertoken=new UsernamePasswordAuthenticationToken(userdetails,null,userdetails.getAuthorities());
					usertoken.setDetails(new WebAuthenticationDetails(request));
					SecurityContextHolder.getContext().setAuthentication(usertoken);
					
					
				}
			}
			filterChain.doFilter(request, response);
			
		}

	}

