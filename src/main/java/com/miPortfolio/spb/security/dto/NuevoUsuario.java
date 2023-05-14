package com.miPortfolio.spb.security.dto;

import java.util.HashSet;
import java.util.Set;

public class NuevoUsuario {
    private String nombre;
    private String nombreUsuario;
    private String emailUsuario;
    private String password;
    private Set<String> roles = new HashSet<>();

    //metodos getters
    public String getNombre() {
        return nombre;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public String getEmailUsuario() {
        return emailUsuario;
    }

    public String getPassword() {
        return password;
    }

    public Set<String> getRoles() {
        return roles;
    }
    
    //metodos setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public void setEmailUsuario(String emailUsuario) {
        this.emailUsuario = emailUsuario;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRoles(Set<String> roles) {
        this.roles = roles;
    }
}
