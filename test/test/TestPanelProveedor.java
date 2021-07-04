/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import controlador.ControladorProveedor;
import modelo.Proveedor;
import modelo.ProveedorDAO;
import vista.PanelProveedores;
import vista.VentanaPrincipal;

/**
 *
 * @author Daniel
 */
public class TestPanelProveedor {
    public static void main(String[] args) {
        // TODO code application logic here
        
        VentanaPrincipal miVentanaPrincipal = new VentanaPrincipal();
        
        Proveedor miProveedor = null;
        ProveedorDAO miProveedorDAO = new ProveedorDAO();
        PanelProveedores miPanelProveedores = new PanelProveedores();
        ControladorProveedor miControladorProveedor = new ControladorProveedor();
        
        miControladorProveedor.setPanelProveedores(miPanelProveedores);
        miControladorProveedor.setProveedorDAO(miProveedorDAO);
        
        miProveedorDAO.setControladorProveedor(miControladorProveedor);
        miPanelProveedores.setControlador(miControladorProveedor);
        miPanelProveedores.setProveedor(miProveedor);
        
        miPanelProveedores.setBounds(0, 180, 1446, 736);
        miVentanaPrincipal.add(miPanelProveedores);
        miVentanaPrincipal.setVisible(true);
    }
}
