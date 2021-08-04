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
public class Pedido {

    // ATRIBUTOS DE CLASE
    private int idPedido; // autoincremental
    private int idVenta;
    private int idProducto;
    private int cantidad;

    //Constructor
    public Pedido() {
    }

    // GETTERS
    public int getIdVenta() {
        return idVenta;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public int getIdPedido() {
        return idPedido;
    }

    // SETTERS
    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }
}
