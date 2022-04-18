/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfoliojwtandjpa.portfoliojwtandjpa.DTO;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author sosag
 */


@Getter @Setter 
@AllArgsConstructor
@NoArgsConstructor
public class SkillDTO implements Serializable {
 
    
private Long id;
private String lenguaje;
private String info;
private String nivel;
private String urlImg;
    
    
    
    
}
