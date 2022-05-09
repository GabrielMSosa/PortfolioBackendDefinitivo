/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfoliojwtandjpa.portfoliojwtandjpa.ControllerAPI;

import com.portfoliojwtandjpa.portfoliojwtandjpa.DTO.ExpeDTO;
import com.portfoliojwtandjpa.portfoliojwtandjpa.modelexp.Experiencia;
import com.portfoliojwtandjpa.portfoliojwtandjpa.servicioexp.IServiExp;
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
public class ControllerExp {
    
    @Autowired
    private IServiExp servi;
    
    /*
    Vamos a trabajar todo con DTO para no cambiar el codigo en el front end.
    
    
    
    */
    
    
    
    
    
//    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/experiencias")
    public void CargarValor (@RequestBody ExpeDTO dato){
        System.out.println("post exper");
    servi.crearItem(dato);
        
    }
    
//    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/experiencias/traertodo")
    public List<ExpeDTO>TraerTodo(){
        System.out.println("get exper");
    return servi.traerTodo();
    }
    
//  @CrossOrigin(origins = "http://localhost:4200")  
  @DeleteMapping("/experiencias/borrar/{id}")    
  public void deleteItem(@PathVariable Long id){
      System.out.println("delete expe");
      servi.borrarItem(id);
 
 }
//@CrossOrigin(origins = "http://localhost:4200")  
@GetMapping("/experiencias/traer/{id}")    
  public ExpeDTO traerItem(@PathVariable Long id){
      System.out.println("get expe");
      return servi.traerPorId(id);
  
  }
  

  
//   @CrossOrigin(origins = "http://localhost:4200")
   @PutMapping("/experiencias/editar/{id}")
 public void editarItem(@PathVariable Long id,
                        @RequestBody ExpeDTO dato ){
 
            System.out.println("entramos al put expe");
         servi.editarPorid(id, dato);
 
 }

  
  
  
  

  
}
