/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author willi
 */
public class Usuario {
    
    private int dniUsuario;
    private String apellido;
    private String nombre;
    private String username;
    private String password;
    private boolean privilegios;
    
    public Usuario(int dniUsuario, String apellido,String nombre, String username, String password, boolean privilegios){
        this.dniUsuario = dniUsuario;
        this.apellido = apellido;
        this.nombre = nombre;
        this.username = username;
        this.password = password;
        this.privilegios = privilegios;
    }

    /**
     * @return the dniUsuario
     */
    public int getDniUsuario() {
        return dniUsuario;
    }

    /**
     * @param dniUsuario the dniUsuario to set
     */
    public void setDniUsuario(int dniUsuario) {
        this.dniUsuario = dniUsuario;
    }

    /**
     * @return the apellido
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * @param apellido the apellido to set
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the privilegios
     */
    public boolean isPrivilegios() {
        return privilegios;
    }

    /**
     * @param privilegios the privilegios to set
     */
    public void setPrivilegios(boolean privilegios) {
        this.privilegios = privilegios;
    }
   
}
