/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.Rectangle;
import modelo.dao.ClienteDAO;
import modelo.dao.VentaDAO;
import vista.PanelClientes;
import vista.PanelHistorialVentas;
import vista.PanelProducto;
import vista.PanelProveedores;
import vista.PanelUsuarios;
import vista.PanelVentas;
import vista.VentanaLogin;
import vista.VentanaPrincipal;

/**
 *
 * @author krypt97
 */
public class ControladorGeneral {

    // ATRIBUTOS DE CLASE
    private VentanaPrincipal miVentanaPrincipal;
    private VentanaLogin miVentanaLogin;
    private PanelProveedores miPanelProveedores;
    private PanelUsuarios miPanelUsuarios;
    private PanelProducto miPanelProducto;
    private PanelVentas miPanelVentas;
    private PanelClientes miPanelClientes;
    private PanelHistorialVentas miPanelHistorialVentas;
    private VentaDAO miVentaDAO;
    private ClienteDAO miClienteDAO;
    final Rectangle bounds = new Rectangle(0, 0, 0, 0);

    // ENLACE VENTA DAO
    public void setMiVentaDAO(VentaDAO miVentaDAO) {
        this.miVentaDAO = miVentaDAO;
    }

    // ENLACE CLIENTE DAO
    public void setMiClienteDAO(ClienteDAO miClienteDAO) {
        this.miClienteDAO = miClienteDAO;
    }

    // ENLACE VENTANA PRINCIPAL
    public void setVentanaPrincipal(VentanaPrincipal miVentanaPrincipal) {
        this.miVentanaPrincipal = miVentanaPrincipal;
    }

    // ENLACE PANEL USUARIOS
    public void setPanelUsuarios(PanelUsuarios miPanelUsuarios) {
        this.miPanelUsuarios = miPanelUsuarios;
        this.miPanelUsuarios.setBounds(bounds);
        this.miPanelUsuarios.setVisible(false);
    }

    // ENLACE PANEL PROVEEDORES
    public void setPanelProveedores(PanelProveedores miPanelProveedores) {
        this.miPanelProveedores = miPanelProveedores;
        this.miPanelProveedores.setBounds(bounds);
        this.miPanelProveedores.setVisible(false);
    }

    // ENLACE PANEL PRODUCTO
    public void setPanelProducto(PanelProducto MiPanelProducto) {
        this.miPanelProducto = MiPanelProducto;
        this.miPanelProducto.setBounds(bounds);
        this.miPanelProducto.setVisible(false);
    }

    // ENLACE PANEL VENTAS
    public void setPanelVentas(PanelVentas miPanelVentas) {
        this.miPanelVentas = miPanelVentas;
        this.miPanelVentas.setBounds(bounds);
        this.miPanelVentas.setVisible(false);
    }

    // ENLACE PANEL CLIENTES       
    public void setPanelClientes(PanelClientes miPanelClientes) {
        this.miPanelClientes = miPanelClientes;
        this.miPanelClientes.setBounds(bounds);
        this.miPanelClientes.setVisible(false);
    }

    // ENLACE PANEL HISTORIAL VENTAS      
    public void setPanelHistorialVentas(PanelHistorialVentas miPanelHistorialVentas) {
        this.miPanelHistorialVentas = miPanelHistorialVentas;
        this.miPanelHistorialVentas.setBounds(bounds);
        this.miPanelHistorialVentas.setVisible(false);
    }

    // ENLACE MI VENTANA LOGIN
    public void setVentanaLogin(VentanaLogin miVentanaLogin) {
        this.miVentanaLogin = miVentanaLogin;
    }

    // MÉTODOS DE CLASE
    public void cargarPanelUsuarios() {
        this.miVentanaPrincipal.panelHome.setVisible(false);
        this.miPanelProducto.setVisible(false);
        this.miPanelProveedores.setVisible(false);
        this.miPanelVentas.setVisible(false);
        this.miPanelClientes.setVisible(false);
        this.miPanelHistorialVentas.setVisible(false);

        this.miPanelUsuarios.setVisible(true);
    }

    public void cargarPanelProveedores() {
        this.miVentanaPrincipal.panelHome.setVisible(false);
        this.miPanelProducto.setVisible(false);
        this.miPanelUsuarios.setVisible(false);
        this.miPanelVentas.setVisible(false);
        this.miPanelClientes.setVisible(false);
        this.miPanelHistorialVentas.setVisible(false);

        this.miPanelProveedores.setVisible(true);
    }

    public void cargarPanelProductos() {
        this.miVentanaPrincipal.panelHome.setVisible(false);
        this.miPanelProveedores.setVisible(false);
        this.miPanelUsuarios.setVisible(false);
        this.miPanelVentas.setVisible(false);
        this.miPanelClientes.setVisible(false);
        this.miPanelHistorialVentas.setVisible(false);

        this.miPanelProducto.setVisible(true);
    }

    public void cargarPanelVentas() {
        this.miVentanaPrincipal.panelHome.setVisible(false);
        this.miPanelProveedores.setVisible(false);
        this.miPanelUsuarios.setVisible(false);
        this.miPanelProducto.setVisible(false);
        this.miPanelClientes.setVisible(false);
        this.miPanelHistorialVentas.setVisible(false);

        this.miPanelVentas.setVisible(true);
    }

    public void cargarPanelClientes() {
        this.miVentanaPrincipal.panelHome.setVisible(false);
        this.miPanelProveedores.setVisible(false);
        this.miPanelUsuarios.setVisible(false);
        this.miPanelProducto.setVisible(false);
        this.miPanelVentas.setVisible(false);
        this.miPanelHistorialVentas.setVisible(false);

        this.miPanelClientes.setVisible(true);
        this.miPanelClientes.setTablaClientes(miClienteDAO.listarClientes());
    }

    public void cargarPanelHistorialVentas() {
        this.miVentanaPrincipal.panelHome.setVisible(false);
        this.miPanelProveedores.setVisible(false);
        this.miPanelUsuarios.setVisible(false);
        this.miPanelProducto.setVisible(false);
        this.miPanelVentas.setVisible(false);
        this.miPanelClientes.setVisible(false);

        this.miPanelHistorialVentas.setVisible(true);
        this.miPanelHistorialVentas.setTablaVentas(miVentaDAO.listarVentas());
    }

    public void cargarPanelHome() {
        this.miPanelProveedores.setVisible(false);
        this.miPanelUsuarios.setVisible(false);
        this.miPanelProducto.setVisible(false);
        this.miPanelVentas.setVisible(false);
        this.miPanelClientes.setVisible(false);
        this.miPanelHistorialVentas.setVisible(false);

        this.miVentanaPrincipal.panelHome.setVisible(true);
    }

    public void logout() {
        this.miVentanaPrincipal.setVisible(false);
        this.miVentanaPrincipal.panelHome.setVisible(false);
        this.miPanelProveedores.setVisible(false);
        this.miPanelUsuarios.setVisible(false);
        this.miPanelProducto.setVisible(false);
        this.miPanelVentas.setVisible(false);
        this.miPanelClientes.setVisible(false);
        this.miPanelHistorialVentas.setVisible(false);

        this.miVentanaLogin.setVisible(true);
    }
}
