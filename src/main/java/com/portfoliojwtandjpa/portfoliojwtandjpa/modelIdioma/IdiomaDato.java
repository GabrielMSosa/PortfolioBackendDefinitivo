/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfoliojwtandjpa.portfoliojwtandjpa.modelIdioma;

import com.sun.istack.NotNull;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author sosag
 */

@Entity
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "idiomadato")
public class IdiomaDato {
            @Id
            @GeneratedValue(strategy = GenerationType.IDENTITY)
            private Long id;
  
                   
            @NotNull
            @Column(name = "nivellectura",length = 90)
            private String nivellectura;
            @NotNull
            @Column(name = "nivelescritura",length = 90)
            private String nivelescritura; 
                  
                  
                  
    
}
