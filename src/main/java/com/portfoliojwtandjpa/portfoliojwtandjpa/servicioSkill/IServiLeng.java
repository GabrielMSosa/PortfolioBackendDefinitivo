/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portfoliojwtandjpa.portfoliojwtandjpa.servicioSkill;

import com.portfoliojwtandjpa.portfoliojwtandjpa.DTO.SkillDTO;
import java.util.List;

/**
 *
 * @author sosag
 */
public interface IServiLeng {
        
      public List<SkillDTO> traerTodo();
  
      public void borrarItem(Long id);
  
      public String crearItem(SkillDTO dato);
  
      public SkillDTO traerPorId(Long id);
      
      public String editarPorid(Long id,SkillDTO dato);


    
    
}
