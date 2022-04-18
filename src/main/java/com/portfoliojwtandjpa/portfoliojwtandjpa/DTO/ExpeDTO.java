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
public class ExpeDTO implements Serializable {
            
            private Long id;
            private String trabajo;
            private String empresa;
            private String deltaanio;
            private Long fechaIni;
            private String uriImg;
            private String pais;
            private String localidad;
            private String provincias;
            private Long fechaFin;
    
    
    
    
    
    
    
}
