/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portfoliojwtandjpa.portfoliojwtandjpa.repositoryexp;

import com.portfoliojwtandjpa.portfoliojwtandjpa.modelexp.ExpeTiempo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author sosag
 */
@Repository
public interface IRepoExpeTiempo extends JpaRepository<ExpeTiempo,Long> {
    
}
