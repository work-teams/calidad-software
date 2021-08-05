/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import modelo.dao.ClienteDAO;
import modelo.dao.VentaDAO;
import vista.PanelClientes;
import vista.PanelHistorialVentas;
import vista.PanelProducto;
import vista.PanelProveedores;
import vista.PanelUsuarios;
import vista.PanelVentas;
import vista.VentanaPrincipal;

/**
 *
 * @author krypt97
 */
public class ControladorGeneral {

    // ATRIBUTOS DE CLASE
    VentanaPrincipal miVentanaPrincipal;
    PanelProveedores miPanelProveedores;
    PanelUsuarios miPanelUsuarios;
    PanelProducto miPanelProducto;
    PanelVentas miPanelVentas;
    PanelClientes miPanelClientes;
    PanelHistorialVentas miPanelHistorialVentas;
    private VentaDAO miVentaDAO;
    private ClienteDAO miClienteDAO;

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
        this.miVentanaPrincipal.setVisible(true);
    }

    // ENLACE PANEL USUARIOS
    public void setPanelUsuarios(PanelUsuarios miPanelUsuarios) {
        this.miPanelUsuarios = miPanelUsuarios;
        this.miPanelUsuarios.setBounds(171, 0, 1265, 912);
        this.miPanelUsuarios.setVisible(false);
    }

    // ENLACE PANEL PROVEEDORES
    public void setPanelProveedores(PanelProveedores miPanelProveedores) {
        this.miPanelProveedores = miPanelProveedores;
        this.miPanelProveedores.setBounds(171, 0, 1265, 912);
        this.miPanelProveedores.setVisible(false);
    }

    // ENLACE PANEL PRODUCTO
    public void setPanelProducto(PanelProducto MiPanelProducto) {
        this.miPanelProducto = MiPanelProducto;
        this.miPanelProducto.setBounds(171, 0, 1265, 912);
        this.miPanelProducto.setVisible(false);
    }

    // ENLACE PANEL VENTAS
    public void setPanelVentas(PanelVentas miPanelVentas) {
        this.miPanelVentas = miPanelVentas;
        this.miPanelVentas.setBounds(171, 0, 1265, 912);
        this.miPanelVentas.setVisible(false);
    }
    
    // ENLACE PANEL CLIENTES       
    public void setPanelClientes(PanelClientes miPanelClientes) {
        this.miPanelClientes = miPanelClientes;
        this.miPanelClientes.setBounds(171, 0, 1265, 912);
        this.miPanelClientes.setVisible(false);
    }
    
    // ENLACE PANEL HISTORIAL VENTAS      
    public void setPanelHistorialVentas(PanelHistorialVentas miPanelHistorialVentas) {
        this.miPanelHistorialVentas = miPanelHistorialVentas;
        this.miPanelHistorialVentas.setBounds(171, 0, 1265, 912);
        this.miPanelHistorialVentas.setVisible(false);
    }

    // MÉTODOS DE CLASE
    public void cargarPanelUsuarios() {
        this.miPanelProducto.setVisible(false);
        this.miPanelProveedores.setVisible(false);
        this.miPanelVentas.setVisible(false);
        this.miPanelClientes.setVisible(false);
        this.miPanelHistorialVentas.setVisible(false);

        this.miPanelUsuarios.setVisible(true);
    }

    public void cargarPanelProveedores() {
        this.miPanelProducto.setVisible(false);
        this.miPanelUsuarios.setVisible(false);
        this.miPanelVentas.setVisible(false);
        this.miPanelClientes.setVisible(false);
        this.miPanelHistorialVentas.setVisible(false);

        this.miPanelProveedores.setVisible(true);
    }

    public void cargarPanelProductos() {
        this.miPanelProveedores.setVisible(false);
        this.miPanelUsuarios.setVisible(false);
        this.miPanelVentas.setVisible(false);
        this.miPanelClientes.setVisible(false);
        this.miPanelHistorialVentas.setVisible(false);

        this.miPanelProducto.setVisible(true);
    }

    public void cargarPanelVentas() {
        this.miPanelProveedores.setVisible(false);
        this.miPanelUsuarios.setVisible(false);
        this.miPanelProducto.setVisible(false);
        this.miPanelClientes.setVisible(false);
        this.miPanelHistorialVentas.setVisible(false);

        this.miPanelVentas.setVisible(true);
    }
    
    public void cargarPanelClientes() {
        this.miPanelProveedores.setVisible(false);
        this.miPanelUsuarios.setVisible(false);
        this.miPanelProducto.setVisible(false);
        this.miPanelVentas.setVisible(false);
        this.miPanelHistorialVentas.setVisible(false);

        this.miPanelClientes.setVisible(true);
        this.miPanelClientes.setTablaClientes(miClienteDAO.listarClientes());
    }
    
    public void cargarPanelHistorialVentas() {
        this.miPanelProveedores.setVisible(false);
        this.miPanelUsuarios.setVisible(false);
        this.miPanelProducto.setVisible(false);
        this.miPanelVentas.setVisible(false);
        this.miPanelClientes.setVisible(false);

        this.miPanelHistorialVentas.setVisible(true);
        this.miPanelHistorialVentas.setTablaVentas(miVentaDAO.listarVentas());
    }
}
