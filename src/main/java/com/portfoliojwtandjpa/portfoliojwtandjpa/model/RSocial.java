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
@Table(name = "redsocial")
public class RSocial {
 
            @Id
            @GeneratedValue(strategy = GenerationType.IDENTITY)
            private Long id;
    
            @NotNull
            @Column(name = "linkGit",length = 500)
            private String linkGit;
            @NotNull
            @Column(name = "linkLn",length = 500)
            private String linkLn;
            @NotNull
            @Column(name = "linkFace",length = 500)
            private String linkFace;
            @NotNull
            @Column(name = "linkTwit",length = 500)
            private String linkTwit;
            
            

            @OneToOne(cascade = {CascadeType.MERGE, CascadeType.REFRESH})
            @JoinColumn(name = "usuario_id")
            private Usuario usuario;
            
        
    
    
}
