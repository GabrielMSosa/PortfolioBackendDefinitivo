/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfoliojwtandjpa.portfoliojwtandjpa.modeledu;

import com.portfoliojwtandjpa.portfoliojwtandjpa.modelIdioma.Idioma;
import com.portfoliojwtandjpa.portfoliojwtandjpa.modelexp.ExpeUbi;
import com.sun.istack.NotNull;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
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
@Table(name = "edutiempo")
public class EduTiempo {
            
            @Id
            @GeneratedValue(strategy = GenerationType.IDENTITY)
            private Long id;
            
            
            
            
            @NotNull
            @Column(name = "fechaini",length = 45)
            private String fechaini;
            @Column(name = "fechafin",length = 45)
            private String fechafin; 
            @Column(name = "estado",length = 90)
            private String estado;
            @Column(name = "uriim",length = 250)
            private String uriim;
            
            
            
            
            
            
            
            
            
    
    
}
