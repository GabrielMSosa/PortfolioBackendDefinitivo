/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfoliojwtandjpa.portfoliojwtandjpa.JWT.controller;

import com.portfoliojwtandjpa.portfoliojwtandjpa.JWT.entity.UserRequest;
import com.portfoliojwtandjpa.portfoliojwtandjpa.JWT.entity.UserResponse;
import com.portfoliojwtandjpa.portfoliojwtandjpa.JWT.model.User;
import com.portfoliojwtandjpa.portfoliojwtandjpa.JWT.service.IUserservice;
import com.portfoliojwtandjpa.portfoliojwtandjpa.JWT.util.JWTUtil;
import java.security.Principal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 *
 * @author sosag
 */


@Controller
@RequestMapping("/user")

public class UserController {
    
    
	@Autowired
	private IUserservice userService;
	@Autowired
	private JWTUtil util;
	@Autowired
	private AuthenticationManager authenticationManager;
        
        @CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/saveUser")
	public ResponseEntity<String> saveUser(@RequestBody User user) {
            
        	Integer id = userService.saveUser(user);
		String message= "User with id '"+id+"' saved succssfully!";
		//return new ResponseEntity<String>(message, HttpStatus.OK);
		return ResponseEntity.ok(message);
	}
        @CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/loginUser")
	public ResponseEntity<UserResponse> login(@RequestBody UserRequest request){
	        System.out.println(request.getPassword());
                System.out.println(request.getUsername());
		
		//Validate username/password with DB(required in case of Stateless Authentication)
		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
	        request.getUsername(), request.getPassword()));
		String token =util.generateToken(request.getUsername());
                System.out.println(token);
		return ResponseEntity.ok(new UserResponse(token,"Token generated successfully!"));
	}
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/getData")
	public ResponseEntity<String> testAfterLogin(Principal p){
		return ResponseEntity.ok("You are accessing data after a valid Login. You are :" +p.getName());
	}
    
    
    
}
