package com.miPortfolio.spb.security.entity;

//clase que accede direto a la BD

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;


@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int idUsuario;
    
    @NotNull
    private String nombre;
    
    @NotNull
    @Column(unique=true)
    private String nombreUsuario;
    
    @NotNull
    private String emailUsuario;
    
    @NotNull
    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "usuario_rol", joinColumns = @JoinColumn(name = "usuario_idUsuario"), inverseJoinColumns = @JoinColumn(name = "rol_idUsuario"))
    private Set<Rol> roles = new HashSet<>();
    
    //constructor vacio
    public Usuario() {
    }

    //constructores para los campos string
    public Usuario(String nombre, String nombreUsuario, String emailUsuario, String password) {
        this.nombre = nombre;
        this.nombreUsuario = nombreUsuario;
        this.emailUsuario = emailUsuario;
        this.password = password;
    }
    
    //metodos getters
    public int getIdUsuario() {
        return idUsuario;
    }

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

    public Set<Rol> getRoles() {
        return roles;
    }

    //metodos setters
    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

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

    public void setRoles(Set<Rol> roles) {
        this.roles = roles;
    }
 }
