/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfoliojwtandjpa.portfoliojwtandjpa.JWT.config;

import com.portfoliojwtandjpa.portfoliojwtandjpa.JWT.filter.SecurityFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.access.channel.ChannelProcessingFilter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 *
 * @author sosag
 */

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    
//	public static String[] SWAGGER_URL_PATHS = new String[] { "/swagger-ui.html**", "/swagger-resources/**",
//	"/v2/api-docs**", "/webjars/**" };


	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
	private BCryptPasswordEncoder bCryptEncoder;
	
	@Autowired
	private UnAuthorizedUserAuthenticationEntryPoint authenticationEntryPoint;
	
	@Autowired
	private SecurityFilter secFilter;
	
	//Required in case of Stateless Authentication

    @Override @Bean
    protected AuthenticationManager authenticationManager() throws Exception {
    return super.authenticationManager();
    }
        
        
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
       	auth.userDetailsService(userDetailsService)
		    .passwordEncoder(bCryptEncoder);
    }
	
	@Override
	public void configure(WebSecurity web) throws Exception {
	  web
		.ignoring()
		  .mvcMatchers("/swagger-ui.html/**", "/configuration/**", "/swagger-resources/**", "/v2/api-docs", "/webjars/**");
	}




        
	
    @Override
    protected void configure(HttpSecurity http) throws Exception {
       //  http.addFilterBefore(new CorsFilter(), ChannelProcessingFilter.class);
       
       
       /*,
                                "/experiencias","/experiencias/traertodo","/experiencias/borrar/{id}",
                                "/experiencias/traer/{id}","/experiencias/editar/{id}",
                                "/idioma","/idioma/traertodo","/idioma/borrar/{id}","/idioma/traer/{id}","/idioma/editar/{id}",
                                "/skill","/skill/traertodo","/skill/borrar/{id}","/skill/traer/{id}","/skill/editar/{id}",
                                "/user/cargar","/user/traertodo","/educacion",
                                "/educacion/traertodo","/educacion/borrar/{id}","/educacion/traer/{id}","/educacion/editsar/{id}"*/
       //ANT MATCHER TENEMOS QUE AGREGAR TODOS LOS ENDPOINTS
       
       http
               .csrf().disable()    //Disabling CSRF as not using form based login
			.authorizeRequests()
			.antMatchers("/user/saveUser","/user/loginUser").permitAll()
		//	.antMatchers(SWAGGER_URL_PATHS)
		//	.permitAll()
			.anyRequest().authenticated()
			.and()
			.exceptionHandling()
			.authenticationEntryPoint(authenticationEntryPoint)
			.and()
			.sessionManagement()
			.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
			//To Verify user from second request onwards............
			.and()
			.addFilterBefore(secFilter, UsernamePasswordAuthenticationFilter.class) 
                        .cors();  
                        
               /*
            
               .csrf().disable()    //Disabling CSRF as not using form based login
			.authorizeRequests()
			.antMatchers("/user/saveUser","/user/loginUser").permitAll()
			.anyRequest().authenticated()
			.and()
			.exceptionHandling()
			.authenticationEntryPoint(authenticationEntryPoint)
			.and()
			.sessionManagement()
			.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
			//To Verify user from second request onwards............
			.and()
			.addFilterBefore(secFilter, UsernamePasswordAuthenticationFilter.class)
                        .cors();
               
       
              .requiresChannel()
                        .requestMatchers(r -> r.getHeader("X-Forwarded-Proto") != null)
                        .requiresSecure();
                 
       */
    }



    
}
