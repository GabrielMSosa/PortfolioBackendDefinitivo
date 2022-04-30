/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portfoliojwtandjpa.portfoliojwtandjpa.repository;

import com.portfoliojwtandjpa.portfoliojwtandjpa.model.DatoUser;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**%
 *
 * @author sosag
 */
@Repository
public interface IRepoDatoUsuario extends JpaRepository<DatoUser,Long>{

//@Query(nativeQuery = true,value="select * from datouser where email=:%email%")
    //DatoUser getByEmail(@Param("email") String email);
  
    List<DatoUser> findByEmail(String email);
}
