/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfoliojwtandjpa.portfoliojwtandjpa.modelexp;

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
@Table(name = "expetiempo")
public class ExpeTiempo {
    
            @Id
            @GeneratedValue(strategy = GenerationType.IDENTITY)
            private Long id;
            
            @NotNull 
            @Column(name = "empresa",length = 250)
            private String empresa;
            
            
            @NotNull 
            @Column(name = "fechaini",length = 90)
            private String fechaini;
            @NotNull 
            @Column(name = "fechafin",length = 90)
            private String fechafin;
            @NotNull 
            @Column(name = "deltaanio",length = 90)
            private String deltaanio;
            
            
            @OneToOne(cascade = CascadeType.ALL)
            @JoinColumn(name = "expeubi_id")
            private ExpeUbi ubi;
    
            
    
    
    
    
}
