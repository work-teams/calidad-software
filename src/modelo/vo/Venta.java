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
    private float monto;
    private boolean boleta;
    
    //CONSTRUCTOR
    public Venta() {
    }
    
    // Enviar datos a DB.
    public Venta(String dniUsuario, String dniCliente, float monto, boolean boleta) {
        this.dniUsuario = dniUsuario;
        this.dniCliente = dniCliente;
        this.monto = monto;
        this.boleta = boleta;
    }
    
    // Recibir datos de DB.
    public Venta(int idVenta, String dniUsuario, String dniCliente, float monto, boolean boleta) {
        this.idVenta = idVenta;
        this.dniUsuario = dniUsuario;
        this.dniCliente = dniCliente;
        this.monto = monto;
        this.boleta = boleta;
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

    public void setMonto(float monto) {
        this.monto = monto;
    }

    public void setBoleta(boolean boleta) {
        this.boleta = boleta;
    }
    
    @Override
    public String toString() {
        return "Venta{" + "idVenta=" + idVenta + ", dniUsuario=" + dniUsuario + ", dniCliente=" + dniCliente + ", monto=" + monto + ", boleta=" + boleta +'}';
    }
}
