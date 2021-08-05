/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import modelo.dao.UsuarioDAO;
import modelo.dao.VentaDAO;
import vista.PanelClientes;

/**
 *
 * @author krypt97
 */
public class ControladorCliente {

    // ATRIBUTOS DE CLASE
    private PanelClientes miPanelClientes;
    private UsuarioDAO miUsuarioDAO;
    private VentaDAO miVentaDAO;
    private String dniClienteSeleccionado;

    // ENLACE VISTA
    public void setPanelClientes(PanelClientes miPanelClientes) {
        this.miPanelClientes = miPanelClientes;
    }

    // ENLACE MODELO
    public void setUsuarioDAO(UsuarioDAO miUsuarioDAO) {
        this.miUsuarioDAO = miUsuarioDAO;
    }

    public void setVentaDAO(VentaDAO miVentaDAO) {
        this.miVentaDAO = miVentaDAO;
    }

    // MÉTODOS DE CLASE
    public void cargarVentasSeleccionadas() {
        dniClienteSeleccionado = miPanelClientes.dniClienteSeleccionado();
        miPanelClientes.setTablaVentas(miVentaDAO.listarVentas(), miUsuarioDAO.listarUsuarios(), dniClienteSeleccionado);
        miPanelClientes.tblVenta.requestFocus();
    }
}
