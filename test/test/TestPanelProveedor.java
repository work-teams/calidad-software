/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import controlador.ControladorProveedor;
import modelo.dao.ProveedorDAO;
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
        
        ProveedorDAO miProveedorDAO = new ProveedorDAO();
        PanelProveedores miPanelProveedores = new PanelProveedores();
        miPanelProveedores.setTabla(miProveedorDAO.mostrarProveedores());
        ControladorProveedor miControladorProveedor = new ControladorProveedor();
        
        miControladorProveedor.setPanelProveedores(miPanelProveedores);
        miControladorProveedor.setProveedorDAO(miProveedorDAO);
        
        miProveedorDAO.setControladorProveedor(miControladorProveedor);
        miPanelProveedores.setControlador(miControladorProveedor);
        
        miVentanaPrincipal.setSize(1366, 700);
        miPanelProveedores.setBounds(0, 0, 1366, 768);
        miVentanaPrincipal.add(miPanelProveedores);
        miVentanaPrincipal.setVisible(true);
    }
}
