/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portfoliojwtandjpa.portfoliojwtandjpa.servicioexp;

import com.portfoliojwtandjpa.portfoliojwtandjpa.DTO.ExpeDTO;
import java.util.List;

/**
 *
 * @author sosag
 */
public interface IServiExp {
    
      public List<ExpeDTO> traerTodo();
  
      public void borrarItem(Long id);
  
      public String crearItem(ExpeDTO dato);
  
      public ExpeDTO traerPorId(Long id);
      public String editarPorid(Long id,ExpeDTO dato);
    
}
