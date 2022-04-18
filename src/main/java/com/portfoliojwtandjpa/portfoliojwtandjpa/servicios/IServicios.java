/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portfoliojwtandjpa.portfoliojwtandjpa.servicios;

import com.portfoliojwtandjpa.portfoliojwtandjpa.DTO.UserDTO;
import com.portfoliojwtandjpa.portfoliojwtandjpa.repository.IRepoCredenciales;
import com.portfoliojwtandjpa.portfoliojwtandjpa.repository.IRepoDatoUsuario;
import com.portfoliojwtandjpa.portfoliojwtandjpa.repository.IRepoUsuario;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author sosag
 */
public interface IServicios {

    public List<UserDTO> retornaUser();
    
    public String guardarUser(UserDTO dato);
    
    public void EliminarUserporId(Long id);
    
    public void EditarUserporId(Long id);
    
}
