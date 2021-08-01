/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.ArrayList;
import modelo.dao.ClienteDAO;
import modelo.dao.PedidoDAO;
import modelo.dao.ProductoDAO;
import modelo.dao.VentaDAO;
import modelo.vo.Cliente;
import modelo.vo.Pedido;
import modelo.vo.Producto;
import modelo.vo.Venta;
import vista.PanelVentas;

/**
 *
 * @author krypt97
 */
public class ControladorVenta {
    // ATRIBUTOS DE CLASE
    PanelVentas miPanelVentas;
    VentaDAO miVentaDAO;
    ClienteDAO miClienteDAO;
    PedidoDAO miPedidoDAO;
    ProductoDAO miProductoDAO;

    // ENLACE VISTA
    public void setPanelVentas(PanelVentas miPanelVentas) {
        this.miPanelVentas = miPanelVentas;
    }

    // ENLACE MODELO
    public void setVentaDAO(VentaDAO miVentaDAO) {
        this.miVentaDAO = miVentaDAO;
    }

    public void setClienteDAO(ClienteDAO miClienteDAO) {
        this.miClienteDAO = miClienteDAO;
    }

    public void setPedidoDAO(PedidoDAO miPedidoDAO) {
        this.miPedidoDAO = miPedidoDAO;
    }

    public void SetProductoDAO(ProductoDAO miProductoDAO) {
        this.miProductoDAO = miProductoDAO;
    }
    
    // METODOS DE CLASE PARA VENTA DAO
    public void registrarVenta(Venta miVenta) {
        miVentaDAO.registrarVenta(miVenta);
        miPanelVentas.limpiarCamposPanelProducto();
    }
    
    public void actualizarTablaVenta() {
        miPanelVentas.setTabla(miPedidoDAO.listarCarritoPedidos(miVentaDAO.generarIdVenta()));
    }
    
    // METODOS DE CLASE PARA PEDIDO DAO
    public void registrarPedido(Pedido miPedido) {
        miPedidoDAO.registrarPedido(miPedido);
        miPanelVentas.limpiarCamposPanelProducto();
    }
    
    public void buscarPedido(int idPedido) {
        if (idPedido != -1) {
            Pedido miPedidoBuscado = miPedidoDAO.buscarPedido(idPedido);
            Producto miProductoBuscado = miProductoDAO.buscarProducto(miPedidoBuscado.getIdProducto());
            miPanelVentas.desempaquetarDatosPedido(miPedidoBuscado);
            miPanelVentas.desempaquetarDatosProducto(miProductoBuscado);
        }
    }
    
    public void eliminarPedido(int idPedido) {
        miPedidoDAO.eliminarPedido(idPedido);
        miPanelVentas.limpiarCamposPanelProducto();
    }

    public void eliminarCarritoPedidos() {
        ArrayList<Pedido> miCarritoPedidos = miPedidoDAO.listarCarritoPedidos(miVentaDAO.generarIdVenta());
        miCarritoPedidos.forEach(miPedido -> {
            miPedidoDAO.eliminarPedido(miPedido.getIdPedido());
        });
    }

    public void modificarPedido(int cantidad, int idPedido) {
        miPedidoDAO.modificarPedido(cantidad, idPedido);
        miPanelVentas.limpiarCamposPanelProducto();
    }
    
    public int generarIdVenta() {
        return miVentaDAO.generarIdVenta();
    }
    
    // METODOS DE CLASE PARA CLIENTE DAO
    public void registrarCliente(Cliente miCliente) {
        if (miClienteDAO.buscarCliente(miCliente.getDniCliente()) == null) {
            miClienteDAO.registrarCliente(miCliente);
        }
        miPanelVentas.limpiarCamposPanelCliente();
    }

    // METODOS DE CLASE PARA PRODUCTO DAO
    public Producto buscarIdProducto(int idProducto) {
        return miProductoDAO.buscarProducto(idProducto);
    }
}
