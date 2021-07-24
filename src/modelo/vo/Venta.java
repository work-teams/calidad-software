/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.vo;

/**
 *
 * @author nick_
 */
public class Venta {
    private int idVenta;
    private String dniUsuario;
    private String dniCliente;
    private int idPedido;
    private float monto;
    private boolean boleta;
    
    //CONSTRUCTOR
    public Venta(int idVenta, String dniUsuario, String dniCliente, int idPedido, float monto, boolean boleta) {
        this.idVenta = idVenta;
        this.dniUsuario = dniUsuario;
        this.dniCliente = dniCliente;
        this.idPedido = idPedido;
        this.monto = monto;
        this.boleta = boleta;
    }
    
    public Venta() {

    }
    
    //GETTERS
    public int getIdVenta() {
        return idVenta;
    }

    public String getDniUsuario() {
        return dniUsuario;
    }

    public String getDniCliente() {
        return dniCliente;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public float getMonto() {
        return monto;
    }

    public boolean isBoleta() {
        return boleta;
    }

    
    //SETTERS
    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public void setDniUsuario(String dniUsuario) {
        this.dniUsuario = dniUsuario;
    }

    public void setDniCliente(String dniCliente) {
        this.dniCliente = dniCliente;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public void setMonto(float monto) {
        this.monto = monto;
    }

    public void setBoleta(boolean boleta) {
        this.boleta = boleta;
    }
    
    @Override
    public String toString() {
        return "Venta{" + "idVenta=" + idVenta + ", dniUsuario=" + dniUsuario + ", dniCliente=" + dniCliente + ", idPedido=" + idPedido + ", monto=" + monto + ", boleta=" + boleta +'}';
    }
}
