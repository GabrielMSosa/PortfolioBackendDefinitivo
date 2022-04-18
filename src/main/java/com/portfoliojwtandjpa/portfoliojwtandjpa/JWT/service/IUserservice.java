/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portfoliojwtandjpa.portfoliojwtandjpa.JWT.service;

import com.portfoliojwtandjpa.portfoliojwtandjpa.JWT.model.User;
import java.util.Optional;

/**
 *
 * @author sosag
 */

public interface IUserservice {
        Integer saveUser(User user);
	
	   Optional<User> findByUsername(String username);
    
}
