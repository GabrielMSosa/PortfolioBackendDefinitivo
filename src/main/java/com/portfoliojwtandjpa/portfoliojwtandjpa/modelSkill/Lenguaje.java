/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfoliojwtandjpa.portfoliojwtandjpa.modelSkill;

import com.portfoliojwtandjpa.portfoliojwtandjpa.model.Usuario;
import com.portfoliojwtandjpa.portfoliojwtandjpa.modelIdioma.IdiomaDato;
import com.sun.istack.NotNull;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

/**
 *
 * @author sosag
 */


@Entity
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "lenguaje")
public class Lenguaje {
            @Id
            @GeneratedValue(strategy = GenerationType.IDENTITY)
            private Long id;
            
            @NotNull
            @Column(name = "lenguaje",length = 200)
            private String lenguaje;
            
               
            @ManyToOne(fetch = FetchType.LAZY,optional = false)
            @JoinColumn(name = "usuario_id")
            @OnDelete(action = OnDeleteAction.CASCADE)
            private Usuario usuario;
            
               
            @OneToOne(cascade = CascadeType.ALL)
            @JoinColumn(name = "lenguajedato_id")
            private LenguajeDato lenguajedato;

         
            
            
    
}
