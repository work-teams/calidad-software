/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.vo;

/**
 *
 * @author krypt97
 */
public class Cliente {
    
    // ATRIBUTOS DE CLASE
    private String dniCliente;
    private String nombre;
    private String apellido;
    private String ruc;

    // CONSTRUCTOR
    public Cliente() {
    }

    // GETTERS
    public String getDniCliente() {
        return dniCliente;
    }

    public String getNombre() {
        return nombre;
    }
    
    public String getApellido() {
        return apellido;
    }
    
    public String getRuc() {
        return ruc;
    }
    
    // SETTERS
    public void setDniCliente(String dniCliente) {
        this.dniCliente = dniCliente;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }
    
}
