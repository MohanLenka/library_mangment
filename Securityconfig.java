package com.example.FlipkartClone.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;import org.springframework.security.config.annotation.SecurityConfigurer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Service;

import com.example.FlipkartClone.jwtserver.Jwtauth;
import com.example.FlipkartClone.jwtserver.Jwtserver;

@Service
@EnableWebSecurity
public class Securityconfig {

	@Autowired
	Myuserdetailsserver myusersdetailsserver;
	@Autowired
	Jwtauth jwtauth;
	
	@Bean
	public SecurityFilterChain filterchain(HttpSecurity http) throws Exception {
		return http.csrf().and().cors().and().authorizeHttpRequests()
				.requestMatchers("/public/**","/public").permitAll().and().authorizeHttpRequests().requestMatchers("/users/**","/admin/**","/users/**").
				authenticated().
				and().
				//formLogin().and().build();
				sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).
			 and().
			 authenticationProvider(authprovider())
				.addFilterBefore(jwtauth,UsernamePasswordAuthenticationFilter.class)
				.build();
	}
	@Bean
	public AuthenticationProvider authprovider() {
		DaoAuthenticationProvider auth=new DaoAuthenticationProvider();
		auth.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
		auth.setUserDetailsService(myusersdetailsserver);
		return auth;
	}
	
	@Bean
	public AuthenticationManager authmanager(AuthenticationConfiguration config) throws Exception {
		return config.getAuthenticationManager();
	}
}
