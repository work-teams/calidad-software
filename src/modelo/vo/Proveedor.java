/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.vo;

/**
 *
 * @author Daniel
 */
public class Proveedor {

    // ATRIBUTOS DE CLASE
    private int idProveedor;
    private String nombre;
    private String direccion;
    private String telefono;

    // CONSTRUCTOR
    public Proveedor() {
    }

    // GETTERS
    public int getIdProveedor() {
        return idProveedor;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getNombre() {
        return nombre;
    }

    // SETTERS
    public void setIdProveedor(int idProveedor) {
        this.idProveedor = idProveedor;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
