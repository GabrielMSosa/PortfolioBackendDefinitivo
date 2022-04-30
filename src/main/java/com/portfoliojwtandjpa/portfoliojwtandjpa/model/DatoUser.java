/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfoliojwtandjpa.portfoliojwtandjpa.model;

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
import lombok.ToString;

/**
 *
 * @author sosag
 */
@Entity
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "datouser")
public class DatoUser {
    
            @Id
            @GeneratedValue(strategy = GenerationType.IDENTITY)
            private Long id;
    
            @NotNull
            @Column(name = "telefono",length = 90)
            private String telefono;
            @NotNull
            @Column(name = "email",length = 90)
            private String email;
            @NotNull
            @Column(name = "edad")
            private Long edad;
            @NotNull
            @Column(name = "acercade",length = 500)
            private String acercade;
            @NotNull
            @Column(name = "urlimg",length = 250)
            private String urlimg;
            
            

            @OneToOne(cascade = {CascadeType.MERGE, CascadeType.REFRESH})
            @JoinColumn(name = "usuario_id")
            private Usuario usuario;
            
        
    
    
}
