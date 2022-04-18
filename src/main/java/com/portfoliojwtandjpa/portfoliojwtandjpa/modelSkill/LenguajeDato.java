/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfoliojwtandjpa.portfoliojwtandjpa.modelSkill;

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
@Table(name = "lenguajedato")
public class LenguajeDato {
            @Id
            @GeneratedValue(strategy = GenerationType.IDENTITY)
            private Long id;
            
            @NotNull
            @Column(name = "info",length = 250)
            private String info;
            @NotNull
            @Column(name = "nivel",length = 90)
            private String nivel;
            @NotNull
            @Column(name = "urlimg",length = 250)
            private String urlimg;

    
}
