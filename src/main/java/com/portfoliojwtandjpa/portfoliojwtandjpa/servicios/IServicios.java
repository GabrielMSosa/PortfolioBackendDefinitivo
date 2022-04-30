/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portfoliojwtandjpa.portfoliojwtandjpa.servicios;

import com.portfoliojwtandjpa.portfoliojwtandjpa.DTO.SocialDTO;
import com.portfoliojwtandjpa.portfoliojwtandjpa.DTO.UserDTO;
import com.portfoliojwtandjpa.portfoliojwtandjpa.model.RSocial;
import java.util.List;


/**
 *
 * @author sosag
 */
public interface IServicios {

    public List<UserDTO> retornaUser();
    
    public String guardarUser(UserDTO dato);
    
    public void EliminarUserporId(Long id);
    
    public String editarPorid(Long id,UserDTO dato);

    //===================RED SOCIAL======================
    public List<SocialDTO> retornaRed();

    public String editarRedporId(Long id,SocialDTO dato);

    public String guardarRedSocial(SocialDTO dato);
    
}
