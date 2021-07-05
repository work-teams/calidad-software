/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import vista.PanelProducto;
import vista.PanelProveedores;
import vista.PanelUsuarios;
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

    // ENLACE VENTANA PRINCIPAL
    public void setVentanaPrincipal(VentanaPrincipal miVentanaPrincipal) {
        this.miVentanaPrincipal = miVentanaPrincipal;
    }

    // ENLACE PANEL USUARIOS
    public void setPanelUsuarios(PanelUsuarios miPanelUsuarios) {
        this.miPanelUsuarios = miPanelUsuarios;
    }

    // ENLACE PANEL PROVEEDORES
    public void setPanelProveedores(PanelProveedores miPanelProveedores) {
        this.miPanelProveedores = miPanelProveedores;
    }

    // ENLACE PANEL PRODUCTO
    public void setPanelProducto(PanelProducto MiPanelProducto) {
        this.miPanelProducto = MiPanelProducto;
    }
    
    // MÉTODOS DE CLASE
    public void cargarPanelUsuarios() {
        this.miPanelProducto.setVisible(false);
        this.miPanelProveedores.setVisible(false);
        
        this.miVentanaPrincipal.add(miPanelUsuarios);
        this.miPanelUsuarios.setBounds(0, 180, 1446, 736);
        this.miPanelUsuarios.setVisible(true);
    }
    
    public void cargarPanelProveedores() {
        this.miPanelProducto.setVisible(false);
        this.miPanelUsuarios.setVisible(false);
        
        this.miVentanaPrincipal.add(miPanelProveedores);
        this.miPanelProveedores.setBounds(0, 180, 1446, 736);
        this.miPanelProveedores.setVisible(true);
    }
    
    public void cargarPanelProductos() {
        this.miPanelProveedores.setVisible(false);
        this.miPanelUsuarios.setVisible(false);
        
        this.miVentanaPrincipal.add(miPanelProducto);
        this.miPanelProducto.setBounds(0, 180, 1446, 736);
        this.miPanelProducto.setVisible(true);
    }
}
