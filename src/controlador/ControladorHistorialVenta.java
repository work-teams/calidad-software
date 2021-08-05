/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import modelo.dao.CategoriaDAO;
import modelo.dao.ClienteDAO;
import modelo.dao.PedidoDAO;
import modelo.dao.ProductoDAO;
import modelo.dao.UsuarioDAO;
import vista.PanelHistorialVentas;

/**
 *
 * @author krypt97
 */
public class ControladorHistorialVenta {

    // ATRIBUTOS DE CLASE
    private PanelHistorialVentas miPanelHistorialVentas;
    private CategoriaDAO miCategoriaDAO;
    private ProductoDAO miProductoDAO;
    private UsuarioDAO miUsuarioDAO;
    private ClienteDAO miClienteDAO;
    private PedidoDAO miPedidoDAO;
    private int idVentaSeleccionado;
    private String dniUsuarioSelecionado;
    private String dniClienteSeleccionado;

    // ENLACE VISTA
    public void setPanelHistorialVentas(PanelHistorialVentas miPanelHistorialVentas) {
        this.miPanelHistorialVentas = miPanelHistorialVentas;
    }

    // Dao
    public void setUsuarioDAO(UsuarioDAO miUsuarioDAO) {
        this.miUsuarioDAO = miUsuarioDAO;
    }

    public void setProductoDAO(ProductoDAO miProductoDAO) {
        this.miProductoDAO = miProductoDAO;
    }

    public void setClienteDAO(ClienteDAO miClienteDAO) {
        this.miClienteDAO = miClienteDAO;
    }

    public void setPedidoDAO(PedidoDAO miPedidoDAO) {
        this.miPedidoDAO = miPedidoDAO;
    }

    public void setCategoriaDAO(CategoriaDAO miCategoriaDAO) {
        this.miCategoriaDAO = miCategoriaDAO;
    }

    // MÉTODOS DE CLASE
    public void cargarPedidosSeleccionados() {
        idVentaSeleccionado = miPanelHistorialVentas.idVentaSeleccionado();
        dniUsuarioSelecionado = miPanelHistorialVentas.dniUsuarioSeleccionado();
        dniClienteSeleccionado = miPanelHistorialVentas.dniClienteSeleccionado();
        miPanelHistorialVentas.desempaquetarDatosUsuario(miUsuarioDAO.buscarUsuario(dniUsuarioSelecionado));
        miPanelHistorialVentas.desempaquetarDatosCliente(miClienteDAO.buscarCliente(dniClienteSeleccionado));
        miPanelHistorialVentas.SetTablaPedidos(miPedidoDAO.listarCarritoPedidos(idVentaSeleccionado), miProductoDAO.listarProductos(), miCategoriaDAO.listarCategorias());
        miPanelHistorialVentas.tblPedidos.requestFocus();
    }
}
