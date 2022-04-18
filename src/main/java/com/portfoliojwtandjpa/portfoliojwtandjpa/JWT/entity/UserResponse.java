/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfoliojwtandjpa.portfoliojwtandjpa.JWT.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author sosag
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse {
    
    private String token;
    private String message;
    
    
    
}
