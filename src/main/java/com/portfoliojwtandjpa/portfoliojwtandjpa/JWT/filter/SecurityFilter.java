/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfoliojwtandjpa.portfoliojwtandjpa.JWT.filter;

import com.portfoliojwtandjpa.portfoliojwtandjpa.JWT.util.JWTUtil;
import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

/**
 *
 * @author sosag
 */
@Component
public class SecurityFilter extends OncePerRequestFilter {
    @Autowired
	private JWTUtil util;
	@Autowired
	private UserDetailsService userDetailsService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        
        	// Reading Token from Authorization Header
                //sacamos el token del header de los request
		String token= request.getHeader("Authorization");
		if(token !=null) {
			String username= util.getSubject(token);
                        System.out.println("username sacado delfiltro"+username);
			//if username is not null & Context Authentication must be null
			if(username !=null && SecurityContextHolder.getContext().getAuthentication()==null) {
		           UserDetails user= userDetailsService.loadUserByUsername(username);
				boolean isValid=util.isValidToken(token, user.getUsername());
				if(isValid) {
                                     UsernamePasswordAuthenticationToken authToken= 
					new UsernamePasswordAuthenticationToken(username, user.getPassword(), user.getAuthorities());
					authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
					SecurityContextHolder.getContext().setAuthentication(authToken);
							
				}
			}
		}
		filterChain.doFilter(request, response);
	}
        
        
        
    }
    
        
        
        
        

