/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfoliojwtandjpa.portfoliojwtandjpa.JWT.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Base64;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.stereotype.Component;

/**
 *
 * @author sosag
 */
@Component
public class JWTUtil {
    
	@Value("${app.secret.key}")
	private String secret_key;

	// code to generate Token
	public String generateToken(String subject) {
		String tokenId= String.valueOf(new Random().nextInt(10000));
		return Jwts.builder()
				.setId(tokenId)
				.setSubject(subject)
				.setIssuer("ABC_Ltd")
				.setAudience("XYZ_Ltd")
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + TimeUnit.HOURS.toMillis(1)))
				.signWith(SignatureAlgorithm.HS512, Base64.getEncoder().encode(secret_key.getBytes()))
				.compact();
	}

	// code to get Claims
	public Claims getClaims(String token) {

		return Jwts.parser()
				.setSigningKey(Base64.getEncoder().encode(secret_key.getBytes()))
				.parseClaimsJws(token)
				.getBody();
	}

	// code to check if token is valid
	public boolean isValidToken(String token) {
		return getClaims(token).getExpiration().after(new Date(System.currentTimeMillis()));
	}
	
	// code to check if token is valid as per username
	public boolean isValidToken(String token,String username) {
		String tokenUserName=getSubject(token);
		return (username.equals(tokenUserName) && !isTokenExpired(token));
	}
	
	// code to check if token is expired
	public boolean isTokenExpired(String token) {
		return getExpirationDate(token).before(new Date(System.currentTimeMillis()));
	}
	
	//code to get expiration date
	public Date getExpirationDate(String token) {
            System.out.println("fechaHora que expira"+getClaims(token).getExpiration());
            return getClaims(token).getExpiration();
                
	}
	
	//code to get expiration date
	public String getSubject(String token) {
            System.out.println("sujeto que expira"+getClaims(token).getSubject());
		return getClaims(token).getSubject();
	}
    
    
}
