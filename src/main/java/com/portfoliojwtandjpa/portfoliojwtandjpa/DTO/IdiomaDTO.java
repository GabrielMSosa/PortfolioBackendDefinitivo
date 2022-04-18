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
 * @author Voolkia
 */

@Getter @Setter 
@AllArgsConstructor
@NoArgsConstructor
public class IdiomaDTO implements Serializable{

     private Long id;
     private String idioma;
     private String nivel_lectura;
     private String nivel_escritura;

    
}
