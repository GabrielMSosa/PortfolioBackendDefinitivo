/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfoliojwtandjpa.portfoliojwtandjpa.JWT.service;

import com.portfoliojwtandjpa.portfoliojwtandjpa.JWT.model.User;
import com.portfoliojwtandjpa.portfoliojwtandjpa.JWT.repo.IUserRepository;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 *
 * @author sosag
 */
@Service
public class Userservicce implements IUserservice, UserDetailsService {

	@Autowired
	private IUserRepository userRepo; 
	
	@Autowired
	private BCryptPasswordEncoder bCryptEncoder;    

    @Override
    public Integer saveUser(User user) {
        //vamos a guardar el asword en la BD codificada
        
        user.setPassword(bCryptEncoder.encode(user.getPassword()));
        System.out.println(user.getId());
        return userRepo.save(user).getId();
    }

    @Override
    public Optional<User> findByUsername(String username) {
   	return userRepo.findByUsername(username);     
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //buscamos el usuario
        Optional<User> opt = userRepo.findByUsername(username);
		
		org.springframework.security.core.userdetails.User springUser=null;
		
		if(opt.isEmpty()) {
                    
                    //OPT ESTA VACIO¿ si es asi ya retorno la exepcion de no encontrado
			throw new UsernameNotFoundException("User with username: " +username +" not found");
                        
		}else {
                    
                    /*
                    obtenemos todos los roles de la base de datos. que lo generamos a muke
                    y lo guardamos en la interface GrantedAuthority
                     y lo hacemos con el for
                    for(String role:roles) {
				ga.add(new SimpleGrantedAuthority(role));
			}
                    
                    */
			User user =opt.get();	//retrieving user from DB
	                   Set<String> roles = user.getRoles();
			Set<GrantedAuthority> ga = new HashSet<>();
			for(String role:roles) {
                            System.out.println(role);
				ga.add(new SimpleGrantedAuthority(role));
			}
			                 System.out.println("usamos  para depurar y entedender el usuario");
                                         System.out.println(username);
                                         System.out.println(user.getPassword());
                                         System.out.println(ga);
                        //guardamos el usuario en la variable springUser
			springUser = new org.springframework.security.core.userdetails.User(
							username,
							user.getPassword(),
							ga );
		}
		      System.out.println(springUser);
		return springUser;
    }

    






}
