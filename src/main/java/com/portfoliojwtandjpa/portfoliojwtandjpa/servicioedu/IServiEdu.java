/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portfoliojwtandjpa.portfoliojwtandjpa.servicioedu;

import com.portfoliojwtandjpa.portfoliojwtandjpa.DTO.EduDTO;
import java.util.List;

/**
 *
 * @author sosag
 */
public interface IServiEdu {
    
      public List<EduDTO> traerTodo();
  
      public void borrarItem(Long id);
  
      public String crearItem(EduDTO dato);
  
      public EduDTO traerPorId(Long id);
      
      public String editarPorid(Long id,EduDTO dato);

    
}
