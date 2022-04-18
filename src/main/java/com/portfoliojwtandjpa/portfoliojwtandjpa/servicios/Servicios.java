/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfoliojwtandjpa.portfoliojwtandjpa.servicios;

import com.portfoliojwtandjpa.portfoliojwtandjpa.DTO.UserDTO;
import com.portfoliojwtandjpa.portfoliojwtandjpa.model.Credenciales;
import com.portfoliojwtandjpa.portfoliojwtandjpa.model.DatoUser;
import com.portfoliojwtandjpa.portfoliojwtandjpa.model.Usuario;
import com.portfoliojwtandjpa.portfoliojwtandjpa.repository.IRepoCredenciales;
import com.portfoliojwtandjpa.portfoliojwtandjpa.repository.IRepoDatoUsuario;
import com.portfoliojwtandjpa.portfoliojwtandjpa.repository.IRepoUsuario;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author sosag
 */
@Service
public class Servicios implements IServicios  {
    
    @Autowired 
    private IRepoUsuario repouser;
    @Autowired 
    private IRepoDatoUsuario repodatous;
    @Autowired 
    private IRepoCredenciales repocrede;

    @Override
    public List<UserDTO> retornaUser() {
        List<UserDTO> dato1= new ArrayList<>();
            
        List<Usuario> user=repouser.findAll();
        List<DatoUser> datouser=repodatous.findAll();
        for (int i = 0; i < user.size(); i++) {
            UserDTO dato=new UserDTO();
             
            dato.setId(user.get(i).getId());
            dato.setNombre(user.get(i).getNombre());
            dato.setApellido(user.get(i).getApellido());
            dato.setTelefono(datouser.get(i).getTelefono());
            dato.setEmail(datouser.get(i).getEmail());
            dato.setEdad(datouser.get(i).getEdad().toString());
            dato.setAcercademi(datouser.get(i).getAcercade());
            dato.setUrlImg(datouser.get(i).getUrlimg());
            dato1.add(dato);
    }
        return dato1;
           
            }
    
    
    

    @Override
    public String guardarUser(UserDTO dato) {
       Usuario user= new Usuario();
       DatoUser datouser=new DatoUser();
       user.setId(dato.getId());
       user.setNombre(dato.getNombre());
       user.setApellido(dato.getApellido());
       repouser.save(user);
       datouser.setId(dato.getId());
       datouser.setTelefono(dato.getEdad());
       datouser.setEmail(dato.getEmail());
       datouser.setEdad(Long.parseLong(dato.getEdad()));
       datouser.setAcercade(dato.getAcercademi());
       datouser.setUrlimg(dato.getUrlImg());
       datouser.setUsuario(user);
       repodatous.save(datouser);
       return "Guardado con exito";
       
    }        
    
    @Override
    public void EliminarUserporId(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void EditarUserporId(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    
}
