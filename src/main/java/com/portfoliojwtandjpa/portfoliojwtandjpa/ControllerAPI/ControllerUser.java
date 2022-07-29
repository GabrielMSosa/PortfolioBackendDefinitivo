/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfoliojwtandjpa.portfoliojwtandjpa.ControllerAPI;

import com.portfoliojwtandjpa.portfoliojwtandjpa.DTO.SocialDTO;
import com.portfoliojwtandjpa.portfoliojwtandjpa.DTO.UserDTO;
import com.portfoliojwtandjpa.portfoliojwtandjpa.servicios.IServicios;
import com.portfoliojwtandjpa.portfoliojwtandjpa.varentorno.VarGlobal;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
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
public class ControllerUser {
 
    @Autowired
    private IServicios servi;
    
    
    @CrossOrigin(origins = VarGlobal.urlcross)
    @PostMapping("/userp/cargar")
    public void cargarvalores(@RequestBody UserDTO dato){
        System.out.println("post user");
        servi.guardarUser(dato);
    
    }
    @CrossOrigin(origins = VarGlobal.urlcross)
    @GetMapping("/userp/traertodo")
    public List<UserDTO> traertodo(){
        System.out.println("entramos al get de user");
        
    return servi.retornaUser();
    
    }
    

    
  @CrossOrigin(origins = VarGlobal.urlcross)
  @PutMapping("/userp/editar/{id}")
 public void editarItem(@PathVariable Long id,
                        @RequestBody UserDTO dato
            ){
 
      System.out.println("entramos al put");
      servi.editarPorid(id, dato);
 
 }


 //============abajo va a estar los endpoints de las redes sociales
 
 
    @CrossOrigin(origins = VarGlobal.urlcross)
    @PostMapping("/redsoc/cargar")
    public void cargarRedesSociales(@RequestBody SocialDTO dato){
        System.out.println("post user");
        servi.guardarRedSocial(dato);
    
    }
 
    @CrossOrigin(origins = VarGlobal.urlcross)
    @GetMapping("/redsoc/traertodo")
    public List<SocialDTO> traertodoSocial(){
        System.out.println("entramos al get de user");
        
    return servi.retornaRed();
    
    }   
 
    
    @CrossOrigin(origins = VarGlobal.urlcross)
    @PutMapping("/redsoc/editar/{id}")
    public void editarItemredsoc(@PathVariable Long id,
                        @RequestBody SocialDTO dato
            ){
 
      System.out.println("entramos al put");
      servi.editarRedporId(id, dato);
 
 }
 
    
    
    
 
    
}
