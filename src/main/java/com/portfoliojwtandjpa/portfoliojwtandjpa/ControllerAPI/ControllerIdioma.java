/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfoliojwtandjpa.portfoliojwtandjpa.ControllerAPI;


import com.portfoliojwtandjpa.portfoliojwtandjpa.DTO.IdiomaDTO;
import com.portfoliojwtandjpa.portfoliojwtandjpa.servicioIdioma.IServiIdioma;
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
 * @author Voolkia
 */
@RestController
public class ControllerIdioma {
    @Autowired
    private IServiIdioma servi;
    
    
    
    @CrossOrigin(origins = "https://portfolio2-a6e86.web.app/")
    @PostMapping("/idioma")
    public void CargarValor1 (@RequestBody IdiomaDTO dato){
    System.out.println("entramos al post de idioma");
     servi.crearItem(dato);
        
    }
    
    @CrossOrigin(origins = "https://portfolio2-a6e86.web.app/")
    @GetMapping("/idioma/traertodo")
    public List <IdiomaDTO>TraerTodo1(){
        System.out.println("se entro al get idioma");
    return servi.traerTodo();
    }
    
  @CrossOrigin(origins = "https://portfolio2-a6e86.web.app/")  
  @DeleteMapping("/idioma/borrar/{id}")    
  public void deleteItem(@PathVariable Long id){
      System.out.println("se borro el idioma");
      servi.borrarItem(id);
 
 }
@CrossOrigin(origins = "https://portfolio2-a6e86.web.app/")  
@GetMapping("/idioma/traer/{id}")    
  public IdiomaDTO traerItem(@PathVariable Long id){
      System.out.println("entramos  al get por  id de edu");
      return servi.traerPorId(id);
  
  }
  
  
  @CrossOrigin(origins = "https://portfolio2-a6e86.web.app/")
  @PutMapping("/idioma/editar/{id}")
 public void editarItem(@PathVariable Long id,
                        @RequestBody IdiomaDTO dato
            ){
 
      System.out.println("entramos al put de idioma");
       servi.editarPorid(id, dato);
 
 }

  
  
  
  
     
     
    
    
    
    
    
    
    
    
}
