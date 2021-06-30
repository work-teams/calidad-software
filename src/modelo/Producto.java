/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author AlexTprog
 */
public class Producto {

    private int idProducto;
    private String nombre;
    private int cantidad;
    private float precio;
    private String categoria;
    private int idCategoria;
    private int idProveedor;

    //CONSTRUCTOR
    public Producto(int idProducto, String nombre, int cantidad, float precio, String nombreCategoria, int idCategoria, int idProveedor) {
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precio = precio;
        this.categoria = nombreCategoria;
        this.idCategoria = idCategoria;
        this.idProveedor = idProveedor;
    }

    //GETTERS
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

    public String getCategoria() {
        return categoria;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public int getIdProveedor() {
        return idProveedor;
    }

    //SETTERS
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

    public void setCategoria(String Categoria) {
        this.categoria = Categoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public void setIdProveedor(int idProveedor) {
        this.idProveedor = idProveedor;
    }
}
