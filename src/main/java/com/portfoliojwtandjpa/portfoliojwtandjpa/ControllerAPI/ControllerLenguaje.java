/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfoliojwtandjpa.portfoliojwtandjpa.ControllerAPI;

import com.portfoliojwtandjpa.portfoliojwtandjpa.DTO.IdiomaDTO;
import com.portfoliojwtandjpa.portfoliojwtandjpa.DTO.SkillDTO;
import com.portfoliojwtandjpa.portfoliojwtandjpa.servicioSkill.IServiLeng;
import com.portfoliojwtandjpa.portfoliojwtandjpa.varentorno.VarGlobal;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author sosag
 */
@RestController
public class ControllerLenguaje {
       @Autowired
    private IServiLeng servi;
       
          
    @CrossOrigin(origins =VarGlobal.urlcross)
    @PostMapping("/skill")
    public void CargarValor1 (@RequestBody SkillDTO dato){
        System.out.println("entramos al post de lenguaje");
    servi.crearItem(dato);
        
    }
    
    @CrossOrigin(origins =VarGlobal.urlcross)
    @GetMapping("/skill/traertodo")
    public List <SkillDTO>TraerTodo1(){
        System.out.println("get de lenguaje");
    return servi.traerTodo();
    }
    
  @CrossOrigin(origins =VarGlobal.urlcross )
  @DeleteMapping("/skill/borrar/{id}")    
  public void deleteItem(@PathVariable Long id){
      System.out.println("delete de lenguaje");
      servi.borrarItem(id);
 
 }
@CrossOrigin(origins =VarGlobal.urlcross )
@GetMapping("/skill/traer/{id}")    
  public SkillDTO traerItem(@PathVariable Long id){
      System.out.println("entramos  al get por  id de lenguaje");
      return servi.traerPorId(id);
  
  }
  
  
 @CrossOrigin(origins =VarGlobal.urlcross)
  @PutMapping("/skill/editar/{id}")
 public String editarItem(@PathVariable Long id,
                        @RequestBody SkillDTO dato
            ){
 
      System.out.println("entramos al put de lenguaje");
 return servi.editarPorid(id, dato);
 
 }

       
       
    
    
}
