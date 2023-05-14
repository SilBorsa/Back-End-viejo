package com.miPortfolio.spb.security.dto;

import java.util.Collection;
import org.springframework.security.core.GrantedAuthority;


public class JwtDTO {
    private String token;
    private String bearer = "Bearer";
    private String nombreUsuario;
    private Collection<? extends GrantedAuthority> authorities;
    
    //constructor
    public JwtDTO(String token, String nombreUsuario, Collection<? extends GrantedAuthority> authorities) {
        this.token = token;
        this.nombreUsuario = nombreUsuario;
        this.authorities = authorities;
    }

    //metodos getters 
    public String getToken() {
        return token;
    }

    public String getBearer() {
        return bearer;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }
    
    //metodos setters
    public void setToken(String token) {
        this.token = token;
    }

    public void setBearer(String bearer) {
        this.bearer = bearer;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
        this.authorities = authorities;
    }
    
}
