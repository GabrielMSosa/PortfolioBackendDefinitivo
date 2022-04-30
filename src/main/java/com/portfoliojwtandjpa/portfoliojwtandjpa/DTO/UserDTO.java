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
import lombok.ToString;

/**
 *
 * @author sosag
 */
@Getter
@Setter
@AllArgsConstructor
@ToString
@NoArgsConstructor
public class UserDTO implements Serializable {

    private Long id;
    private String nombre;
    private String apellido;
    private String telefono;
    private String email;
    private String edad;
    private String acercademi;
    private String urlImg;
    
    
}
