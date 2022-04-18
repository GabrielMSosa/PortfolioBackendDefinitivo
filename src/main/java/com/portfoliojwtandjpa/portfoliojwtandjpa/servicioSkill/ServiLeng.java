/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfoliojwtandjpa.portfoliojwtandjpa.servicioSkill;


import com.portfoliojwtandjpa.portfoliojwtandjpa.DTO.SkillDTO;
import com.portfoliojwtandjpa.portfoliojwtandjpa.model.Usuario;

import com.portfoliojwtandjpa.portfoliojwtandjpa.modelSkill.Lenguaje;
import com.portfoliojwtandjpa.portfoliojwtandjpa.modelSkill.LenguajeDato;
import com.portfoliojwtandjpa.portfoliojwtandjpa.repository.IRepoUsuario;
import com.portfoliojwtandjpa.portfoliojwtandjpa.repositorySkill.IRepoLenguaje;
import com.portfoliojwtandjpa.portfoliojwtandjpa.repositorySkill.IRepoLenguajeDato;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author sosag
 */
@Service
public class ServiLeng implements IServiLeng {
       @Autowired
       private IRepoUsuario repouser;
       @Autowired
       private IRepoLenguaje repolen;
       @Autowired
       private IRepoLenguajeDato repold;
    
    
    
    @Override
    public List<SkillDTO> traerTodo() {
        List<SkillDTO> expdto=new ArrayList<>();
        List<Lenguaje> idio = repolen.findAll();
    //para evitar errores en traer con otro indice de nuestra base de datos solamente aprovechamos de las entidades que estan 
    //vinculadas y solamente usamos la entidad Experiencia y esa esta relaciona con la tabla Expetiempo que a su ves esta
    //relacionada con la entidad Expubi.
        
        //recorremos solo un array list ya que el resto tiene una relacion OneTOone entonces todos tienen la misma dimension-
        for (int i = 0; i < idio.size(); i++) {
               SkillDTO x=new SkillDTO();
               x.setId(idio.get(i).getId());
               x.setLenguaje(idio.get(i).getLenguaje());
               x.setInfo(idio.get(i).getLenguajedato().getInfo()); //para evitar buscar y que podamos traer con otro indice usamos la FK,
               x.setNivel(idio.get(i).getLenguajedato().getNivel());//para evitar buscar y que podamos traer con otro indice usamos la FK,
               x.setUrlImg(idio.get(i).getLenguajedato().getUrlimg());
               expdto.add(x);
            
        }
        return  expdto;
    
    }
        
        
        
        
    

    @Override
    public void borrarItem(Long id) {
       repolen.deleteById(id);
        System.out.println("Item borrado con exito");
        
        
    }

    @Override
    public String crearItem(SkillDTO dato) {
        Lenguaje idio= new Lenguaje();
        LenguajeDato lengdt = new LenguajeDato();
        List<Usuario> user=repouser.findAll();
        
        lengdt.setInfo(dato.getInfo());
        lengdt.setNivel(dato.getNivel());
        lengdt.setUrlimg(dato.getUrlImg());
        
        idio.setLenguaje(dato.getLenguaje());
        idio.setLenguajedato(lengdt);
        idio.setUsuario(user.get(0));
        repolen.save(idio);
        return "Se ha creado el item";
        
    }

    @Override
    public SkillDTO traerPorId(Long id) {
    Lenguaje idio=repolen.getById(id); //trae por id de la base de datos Experiencia               
        SkillDTO x=new SkillDTO();
               x.setId(idio.getId());
               x.setInfo(idio.getLenguajedato().getInfo());
               x.setLenguaje(idio.getLenguaje());
               x.setNivel(idio.getLenguajedato().getNivel());
               x.setUrlImg(idio.getLenguajedato().getUrlimg());
        return x;   
        
        
    }

    @Override
    public String editarPorid(Long id, SkillDTO dato) {
        Lenguaje expe=repolen.getById(id); //trae por id de la base de datos Experiencia               
        LenguajeDato et=new LenguajeDato();
        Long pk1=expe.getLenguajedato().getId();
        et.setInfo(dato.getInfo());
        et.setNivel(dato.getNivel());
        et.setUrlimg(dato.getUrlImg());
        et.setId(pk1);
        expe.setLenguaje(dato.getLenguaje());
        expe.setLenguajedato(et);
        repolen.save(expe);
        return "item editado con exito";
        
        
    }
    
    
    
}
