/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfoliojwtandjpa.portfoliojwtandjpa.ControllerAPI;

import com.portfoliojwtandjpa.portfoliojwtandjpa.DTO.EduDTO;
import com.portfoliojwtandjpa.portfoliojwtandjpa.servicioedu.IServiEdu;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author sosag
 */
@RestController
public class EduControlle {
    
     @Autowired
    private IServiEdu servi;
     
     
    /*
    Vamos a trabajar todo con DTO para no cambiar el codigo en el front end.
    
    
    
    */
    
    
    
    
    
    @CrossOrigin(origins = "https://portfolio2-a6e86.web.app/")
    @PostMapping("/educacion")
    public void CargarValor1 (@RequestBody EduDTO dato){
        System.out.println("entramos post educacion");
    servi.crearItem(dato);
        
    }
    
    @CrossOrigin(origins = "https://portfolio2-a6e86.web.app/")
    @GetMapping("/educacion/traertodo")
    public List <EduDTO>TraerTodo1(){
        System.out.println("get educacion");
    return servi.traerTodo();
    }
    
  @CrossOrigin(origins = "https://portfolio2-a6e86.web.app/")  
  @DeleteMapping("/educacion/borrar/{id}")    
  public void deleteItem(@PathVariable Long id){
      System.out.println("delete educacuin");
      servi.borrarItem(id);
 
 }
@CrossOrigin(origins = "https://portfolio2-a6e86.web.app/")  
@GetMapping("/educacion/traer/{id}")    
  public EduDTO traerItem(@PathVariable Long id){
      System.out.println("entramos  al get por  id de edu");
      return servi.traerPorId(id);
  
  }
  
  
 @CrossOrigin(origins = "https://portfolio2-a6e86.web.app/")
  @PutMapping("/educacion/editar/{id}")
 public void editarItem(@PathVariable Long id,
                        @RequestBody EduDTO dato
            ){
 
      System.out.println("entramos al put");
 servi.editarPorid(id, dato);
 
 }

  
  
  
  
     
     
     
     
     
     
    
    
    
    
    
    
}
