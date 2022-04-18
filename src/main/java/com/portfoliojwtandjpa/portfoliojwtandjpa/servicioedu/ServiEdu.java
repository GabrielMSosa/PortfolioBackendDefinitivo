/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfoliojwtandjpa.portfoliojwtandjpa.servicioedu;

import com.portfoliojwtandjpa.portfoliojwtandjpa.DTO.EduDTO;
import com.portfoliojwtandjpa.portfoliojwtandjpa.model.Usuario;
import com.portfoliojwtandjpa.portfoliojwtandjpa.modeledu.EduTiempo;
import com.portfoliojwtandjpa.portfoliojwtandjpa.modeledu.Educacion;
import com.portfoliojwtandjpa.portfoliojwtandjpa.repository.IRepoUsuario;
import com.portfoliojwtandjpa.portfoliojwtandjpa.repositoryedu.IRepoEduTiempo;
import com.portfoliojwtandjpa.portfoliojwtandjpa.repositoryedu.IRepoEducacion;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author sosag
 */
@Service
public class ServiEdu implements IServiEdu{
@Autowired
private IRepoEduTiempo repoeduti;

@Autowired
private IRepoEducacion repoedu;
    

@Autowired
private IRepoUsuario repouser;
    
    
    
    @Override
    public List<EduDTO> traerTodo() {
    
        List<EduDTO> expdto=new ArrayList<>();
        List<Educacion> expe = repoedu.findAll();
    //para evitar errores en traer con otro indice de nuestra base de datos solamente aprovechamos de las entidades que estan 
    //vinculadas y solamente usamos la entidad Experiencia y esa esta relaciona con la tabla Expetiempo que a su ves esta
    //relacionada con la entidad Expubi.
        
        //recorremos solo un array list ya que el resto tiene una relacion OneTOone entonces todos tienen la misma dimension-
        for (int i = 0; i < expe.size(); i++) {
               EduDTO x=new EduDTO();
               x.setId(expe.get(i).getId());
               x.setInstitucion(expe.get(i).getInstitucion());
               x.setTitulo(expe.get(i).getTitulo()); //para evitar buscar y que podamos traer con otro indice usamos la FK,
               
               x.setFechaIni(Long.parseLong(expe.get(i).getEdutiempo().getFechaini()));
               x.setFechaFin(Long.parseLong(expe.get(i).getEdutiempo().getFechafin()));
               x.setEstado((expe.get(i).getEdutiempo().getEstado()));
               x.setUriImg((expe.get(i).getEdutiempo().getUriim()));
               expdto.add(x);
            
        }
        return  expdto;
    
    }

    @Override
    public void borrarItem(Long id) {
        
       repoedu.deleteById(id);
        System.out.println("Item borrado con exito");
    }

    @Override
    public String crearItem(EduDTO dato) {
        
        EduTiempo exptie= new EduTiempo();
        Educacion expe = new Educacion();
        List<Usuario> user=repouser.findAll();
        
       
        exptie.setFechaini(dato.getFechaIni().toString());
        exptie.setFechafin(dato.getFechaFin().toString());
        exptie.setEstado(dato.getEstado());
        exptie.setUriim(dato.getUriImg());
        
        repoeduti.save(exptie);
        
        expe.setInstitucion(dato.getInstitucion());
        expe.setUsuario(user.get(0));//asumimos que van a  no van a convivir +de 1 usuario a la vez en nuestra Base de datos
        expe.setTitulo(dato.getTitulo());
        expe.setEdutiempo(exptie);
        repoedu.save(expe);
        
        return "la carga de la experiencia fue exitosa";
        
        
        
    }

    @Override
    public EduDTO traerPorId(Long id) {
    Educacion expe=repoedu.getById(id); //trae por id de la base de datos Experiencia               
    EduDTO x=new EduDTO();
               x.setId(expe.getId());
               x.setInstitucion(expe.getInstitucion());
               x.setTitulo(expe.getTitulo()); //para evitar buscar y que podamos traer con otro indice usamos la FK,
               
               x.setFechaIni(Long.parseLong(expe.getEdutiempo().getFechaini()));
               x.setFechaFin(Long.parseLong(expe.getEdutiempo().getFechafin()));
               x.setEstado((expe.getEdutiempo().getEstado()));
               x.setUriImg((expe.getEdutiempo().getUriim()));
    
 
               return x;
    }
    
    @Override
    public String editarPorid(Long id,EduDTO dato){
    Educacion expe=repoedu.getById(id); //trae por id de la base de datos Experiencia               
    Long pk1= expe.getEdutiempo().getId();
    EduTiempo et=new EduTiempo();
    expe.setId(id);
    expe.setInstitucion(dato.getInstitucion());
    expe.setTitulo(dato.getTitulo());
    et.setEstado(dato.getEstado());
    et.setFechafin(dato.getFechaFin().toString());
    et.setFechaini(dato.getFechaFin().toString());
    et.setUriim(dato.getUriImg());
    et.setId(pk1);
    
    expe.setEdutiempo(et);
    
    repoedu.save(expe);
    return "editadoOK";
    }
    
}
