/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portfoliojwtandjpa.portfoliojwtandjpa.repositoryIdioma;

import com.portfoliojwtandjpa.portfoliojwtandjpa.modelIdioma.IdiomaDato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author sosag
 */
@Repository
public interface IRepoIdiomaDato extends JpaRepository<IdiomaDato, Long> {
    
}
