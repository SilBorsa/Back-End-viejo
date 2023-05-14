package com.miPortfolio.spb.security.entity;

import com.miPortfolio.spb.security.enums.RolNombre;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;

@Entity
public class Rol {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int idRol;
    
    @NotNull
    @Enumerated(EnumType.STRING)
    private RolNombre rolNombre;

    //constructor vacio
    public Rol() {
    }

    //constructor para el nombre
    public Rol(RolNombre rolNombre) {
        this.rolNombre = rolNombre;
    }
    
    //metodos getters
    public int getIdRol() {
        return idRol;
    }

    public RolNombre getRolNombre() {
        return rolNombre;
    }
    
    //metodos setters
    public void setIdRol(int idRol) {
        this.idRol = idRol;
    }

    public void setRolNombre(RolNombre rolNombre) {
        this.rolNombre = rolNombre;
    }    
}
