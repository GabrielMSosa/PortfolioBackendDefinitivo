/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfoliojwtandjpa.portfoliojwtandjpa.servicioIdioma;

import com.portfoliojwtandjpa.portfoliojwtandjpa.DTO.IdiomaDTO;
import com.portfoliojwtandjpa.portfoliojwtandjpa.model.Usuario;
import com.portfoliojwtandjpa.portfoliojwtandjpa.modelIdioma.Idioma;
import com.portfoliojwtandjpa.portfoliojwtandjpa.modelIdioma.IdiomaDato;
import com.portfoliojwtandjpa.portfoliojwtandjpa.repository.IRepoUsuario;
import com.portfoliojwtandjpa.portfoliojwtandjpa.repositoryIdioma.IRepoIdioma;
import com.portfoliojwtandjpa.portfoliojwtandjpa.repositoryIdioma.IRepoIdiomaDato;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author sosag
 */
@Service
public class ServiIdioma implements IServiIdioma {
    @Autowired
    private IRepoIdioma repoido;
    @Autowired
    private IRepoIdiomaDato repoidat;
   @Autowired
   private IRepoUsuario repouser;

    @Override
    public List<IdiomaDTO> traerTodo() {
    List<IdiomaDTO> expdto=new ArrayList<>();
        List<Idioma> idio = repoido.findAll();
    //para evitar errores en traer con otro indice de nuestra base de datos solamente aprovechamos de las entidades que estan 
    //vinculadas y solamente usamos la entidad Experiencia y esa esta relaciona con la tabla Expetiempo que a su ves esta
    //relacionada con la entidad Expubi.
        
        //recorremos solo un array list ya que el resto tiene una relacion OneTOone entonces todos tienen la misma dimension-
        for (int i = 0; i < idio.size(); i++) {
               IdiomaDTO x=new IdiomaDTO();
               x.setId(idio.get(i).getId());
               x.setIdioma(idio.get(i).getIdioma());
               x.setNivel_escritura(idio.get(i).getIdiomadato().getNivelescritura()); //para evitar buscar y que podamos traer con otro indice usamos la FK,
               x.setNivel_lectura(idio.get(i).getIdiomadato().getNivellectura()); //para evitar buscar y que podamos traer con otro indice usamos la FK,
               expdto.add(x);
            
        }
        return  expdto;
    
    }
        
        
        
    

    @Override
    public void borrarItem(Long id) {
        repoido.deleteById(id);
        System.out.println("Item borrado con exito");
    }

    @Override
    public String crearItem(IdiomaDTO dato) {
        Idioma idio= new Idioma();
        IdiomaDato idiodt = new IdiomaDato();
        List<Usuario> user=repouser.findAll();
        
        idiodt.setNivelescritura(dato.getNivel_escritura());
        idiodt.setNivellectura(dato.getNivel_lectura());
        
        idio.setIdioma(dato.getIdioma());
        idio.setIdiomadato(idiodt);
        idio.setUsuario(user.get(0));
        repoido.save(idio);
        return "Se ha creado el item";
    }

    @Override
    public IdiomaDTO traerPorId(Long id) {
        Idioma idio=repoido.getById(id); //trae por id de la base de datos Experiencia               
        IdiomaDTO x=new IdiomaDTO();
               x.setId(idio.getId());
               x.setIdioma(idio.getIdioma());
               x.setNivel_escritura(idio.getIdiomadato().getNivelescritura());
               x.setNivel_lectura(idio.getIdiomadato().getNivellectura());
        return x;   
            
    
        
        
    }

    @Override
    public String editarPorid(Long id, IdiomaDTO dato) {
        Idioma expe=repoido.getById(id); //trae por id de la base de datos Experiencia               
        IdiomaDato et=new IdiomaDato();
        Long pk1=expe.getIdiomadato().getId();
        et.setNivelescritura(dato.getNivel_escritura());
        et.setNivellectura(dato.getNivel_escritura());
        et.setId(pk1);
        expe.setIdioma(dato.getIdioma());
        expe.setIdiomadato(et);
        repoido.save(expe);
        return "item editado con exito";
        
    }
    
}
