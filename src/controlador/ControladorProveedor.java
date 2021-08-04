/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import modelo.vo.Proveedor;
import modelo.dao.ProveedorDAO;
import vista.PanelProveedores;

/**
 *
 * @author Daniel
 */
public class ControladorProveedor {

    // ATRIBUTOS DE CLASE
    private PanelProveedores miPanelProveedores;
    private ProveedorDAO miProveedorDAO;
    private Proveedor miProveedor;
    private int idProveedor;

    // ENLACE VISTA
    public void setPanelProveedores(PanelProveedores miPanelProveedores) {
        this.miPanelProveedores = miPanelProveedores;
    }

    // ENLACE MODELO
    // Vo
    public void setProveedor(Proveedor miProveedor) {
        this.miProveedor = miProveedor;
    }

    // Dao
    public void setProveedorDAO(ProveedorDAO miProveedorDAO) {
        this.miProveedorDAO = miProveedorDAO;
    }

    // MÉTODOS DE CLASE
    public void registrarProveedor() {
        miProveedor = miPanelProveedores.empaquetarDatosProveedor();
        miProveedorDAO.registrarProveedor(miProveedor);
        miPanelProveedores.setTablaProveedores(miProveedorDAO.listarProveedores());
        miPanelProveedores.limpiarCampos();
    }

    public void buscarProveedor() {
        idProveedor = Integer.parseInt(miPanelProveedores.txtIdProveedor.getText());
        if (miProveedorDAO.buscarProveedor(idProveedor) != null) {
            miPanelProveedores.desempaquetarDatosProveedor(miProveedorDAO.buscarProveedor(idProveedor));
        }
    }

    public void modificarProveedor() {
        miProveedor = miPanelProveedores.empaquetarDatosProveedor();
        miProveedorDAO.modificarProveedor(miProveedor);
        miPanelProveedores.setTablaProveedores(miProveedorDAO.listarProveedores());
        miPanelProveedores.limpiarCampos();
    }

    public void eliminarProveedor() {
        idProveedor = Integer.parseInt(miPanelProveedores.txtIdProveedor.getText());
        miProveedorDAO.eliminarProveedor(idProveedor);
        miPanelProveedores.setTablaProveedores(miProveedorDAO.listarProveedores());
        miPanelProveedores.limpiarCampos();
    }
}
