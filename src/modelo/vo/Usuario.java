/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.vo;

/**
 *
 * @author willi
 */
public class Usuario {

    // VARIABLES DE CLASE
    private String dniUsuario;
    private String apellido;
    private String nombre;
    private String username;
    private String password;
    private String rol;

    // CONSTRUCTOR
    public Usuario() {
    }

    // GETTERS
    public String getDniUsuario() {
        return dniUsuario;
    }

    public String getApellido() {
        return apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getRol() {
        return rol;
    }

    // SETTERS
    public void setDniUsuario(String dniUsuario) {
        this.dniUsuario = dniUsuario;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
}
