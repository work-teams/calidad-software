/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.ArrayList;
import modelo.Proveedor;
import modelo.ProveedorDAO;
import vista.PanelProveedores;

/**
 *
 * @author Daniel
 */
public class ControladorProveedor {
    PanelProveedores miPanelProveedores;
    ProveedorDAO miProveedorDAO;

    public void setPanelProveedores(PanelProveedores miPanelProveedores) {
        this.miPanelProveedores = miPanelProveedores;
    }

    public void setProveedorDAO(ProveedorDAO miProveedorDAO) {
        this.miProveedorDAO = miProveedorDAO;
    }
    
    public void registrar(Proveedor miProveedor){
        miProveedorDAO.registrarProveedor(miProveedor);
    }
    
    public void buscar(int idProveedor){
        miProveedorDAO.buscarProveedor(idProveedor);
    }
    
    public ArrayList<Proveedor> mostrarProveedores(){
        return miProveedorDAO.mostrarProveedores();
    }
    
    public void modificar(Proveedor miProveedor){
        miProveedorDAO.modificarProveedor(miProveedor);
    }
    
    public void eliminar(int idProveedor){
        miProveedorDAO.eliminarProveedor(idProveedor);
    }
}
