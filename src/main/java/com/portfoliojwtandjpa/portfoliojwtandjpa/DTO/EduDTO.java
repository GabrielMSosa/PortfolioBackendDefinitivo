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
    public class EduDTO implements Serializable  {
    private Long id;
    private String institucion;
    private String titulo;
    private Long fechaIni;
    private Long fechaFin;
    private String estado;
    private String uriImg;

    @Override
    public String toString() {
        return "EduDTO{" + "id=" + id + ", institucion=" + institucion + ", titulo=" + titulo + ", fechaIni=" + fechaIni + ", fechaFin=" + fechaFin + ", estado=" + estado + ", uriImg=" + uriImg + '}';
    }

}
