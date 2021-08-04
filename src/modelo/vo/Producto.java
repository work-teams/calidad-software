/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.vo;

/**
 *
 * @author AlexTprog
 */
public class Producto {

    private int idProducto;
    private String nombre;
    private int cantidad;
    private float precio;
    private int idProveedor;
    private int idCategoria;

    // CONSTRUCTOR
    public Producto() {
    }

    // GETTERS
    public int getIdProducto() {
        return idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public float getPrecio() {
        return precio;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public int getIdProveedor() {
        return idProveedor;
    }

    // SETTERS
    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public void setIdProveedor(int idProveedor) {
        this.idProveedor = idProveedor;
    }
}
