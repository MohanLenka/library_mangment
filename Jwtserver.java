package com.example.FlipkartClone.jwtserver;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Service
public class Jwtserver {

	public String createjwt(String username) {
		
		Map<String,Object> claims=new HashMap<>();
		 String token=createtoken(claims,username);
		 return token;
			
		
	}
	 public String createtoken(Map<String,Object> claims,String username){
		 System.out.println(username);
		return Jwts.builder().
				setClaims(claims).
				setSubject(username).
				setIssuedAt(new Date(System.currentTimeMillis())).
				setExpiration(new Date(System.currentTimeMillis()*60*60)).
				signWith(getkey(),SignatureAlgorithm.HS256).
				compact();

		
	 }
	 public Key getkey() {
		 byte[] bytekey=Decoders.BASE64.decode("735da29d118acdc004aededc4643c6b1e51f74194e357ceb2f6403dbe0ce6cf0");
		 return Keys.hmacShaKeyFor(bytekey);
	 }
	 
	 public String Extractusername(String token) {
		 return Extractclaim(token,Claims::getSubject);
	 }
	 public <T> T Extractclaim(String token,Function<Claims ,T> claimresolver)
	 {
		Claims claim=extractallClaims(token);
		return claimresolver.apply(claim);
	 }
	 public Claims extractallClaims(String token) {
		 return Jwts.parser().setSigningKey(getkey())
				 .build().parseClaimsJws(token).getBody();
	 }
	 public boolean validatetoken(String token) {
		 Date date =Extractclaim(token,Claims::getExpiration);
		 return new Date(System.currentTimeMillis()).before(date);
	 }
}
