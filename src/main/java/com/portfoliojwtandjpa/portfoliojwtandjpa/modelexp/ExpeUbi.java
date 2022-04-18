/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfoliojwtandjpa.portfoliojwtandjpa.modelexp;

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
@Table(name = "expeubi")
public class ExpeUbi {
    
            @Id
            @GeneratedValue(strategy = GenerationType.IDENTITY)
            private Long id;
            
            
            @NotNull
            @Column(name = "localidad",length = 200)
            private String localidad;
            
            @NotNull
            @Column(name = "provincia",length = 200)
            private String provincia;
            @NotNull
            @Column(name = "pais",length = 200)
            private String pais;
            @NotNull
            @Column(name = "urlimg",length = 250)
            private String urlimg;
    

            




}
