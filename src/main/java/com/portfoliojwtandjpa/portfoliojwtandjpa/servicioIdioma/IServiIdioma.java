/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portfoliojwtandjpa.portfoliojwtandjpa.servicioIdioma;

import com.portfoliojwtandjpa.portfoliojwtandjpa.DTO.IdiomaDTO;
import java.util.List;

/**
 *
 * @author sosag
 */
public interface IServiIdioma {

    
      public List<IdiomaDTO> traerTodo();
  
      public void borrarItem(Long id);
  
      public String crearItem(IdiomaDTO dato);
  
      public IdiomaDTO traerPorId(Long id);
      
      public String editarPorid(Long id,IdiomaDTO dato);





    
}
