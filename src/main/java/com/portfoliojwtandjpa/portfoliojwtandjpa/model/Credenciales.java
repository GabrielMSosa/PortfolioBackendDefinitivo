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

/**
 *
 * @author sosag
 */

@Getter @Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="credenciales")
public class Credenciales {
            @Id
            @GeneratedValue(strategy = GenerationType.IDENTITY)
            private Long id;
            
            @NotNull
            @Column(name = "usuario",length = 90)
            private String usuario;
            
            @NotNull
            @Column(name = "password",length = 90)
            private String password;
            
            @OneToOne(cascade = CascadeType.ALL)
            @JoinColumn(name ="datouser_id" )
            private DatoUser datouser;
                    
            @OneToOne(cascade = CascadeType.ALL)
            @JoinColumn(name ="datouser_usuario_id")
            private Usuario usua;
    
    
}
