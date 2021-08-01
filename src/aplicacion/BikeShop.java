/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion;

import controlador.ControladorGeneral;
import controlador.ControladorProducto;
import controlador.ControladorProveedor;
import controlador.ControladorUsuario;
import controlador.ControladorVenta;
import modelo.dao.CategoriaDAO;
import modelo.dao.ClienteDAO;
import modelo.dao.PedidoDAO;
import modelo.dao.ProductoDAO;
import modelo.dao.ProveedorDAO;
import modelo.dao.UsuarioDAO;
import modelo.dao.VentaDAO;
import vista.PanelProducto;
import vista.PanelProveedores;
import vista.PanelUsuarios;
import vista.PanelVentas;
import vista.VentanaPrincipal;

/**
 *
 * @author krypt97
 */
public class BikeShop {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // ÚNICA INSTANCIA DE LOS ELEMENTOS A CONECTAR
        
        // [vista]
        VentanaPrincipal miVentanaPrincipal = new VentanaPrincipal();
        PanelUsuarios miPanelUsuarios = new PanelUsuarios();
        PanelProducto miPanelProducto = new PanelProducto();
        PanelProveedores miPanelProveedores = new PanelProveedores();
        PanelVentas miPanelVentas = new PanelVentas();
        
        // [dao]
        UsuarioDAO miUsuarioDAO = new UsuarioDAO();
        ProductoDAO miProductoDAO = new ProductoDAO();
        ProveedorDAO miProveedorDAO = new ProveedorDAO();
        VentaDAO miVentaDAO = new VentaDAO();
        PedidoDAO miPedidoDAO = new PedidoDAO();
        ClienteDAO miClienteDAO = new ClienteDAO();
        
        // [controlador]
        ControladorUsuario miControladorUsuario = new ControladorUsuario();
        ControladorProducto miControladorProducto = new ControladorProducto();
        ControladorProveedor miControladorProveedor = new ControladorProveedor();
        ControladorVenta miControladorVenta = new ControladorVenta();
        
        ControladorGeneral miControladorGeneral = new ControladorGeneral();

/* ---------------------------------------------------------------------------------------- */
        // CONECTANDO CONTROLADOR A VISTAS Y/O MODELOS
        
        // [vistas]
        miControladorUsuario.setPanelUsuarios(miPanelUsuarios);
        miControladorProveedor.setPanelProveedores(miPanelProveedores);
        miControladorProducto.setPanelProducto(miPanelProducto);
        miControladorVenta.setPanelVentas(miPanelVentas);
        
        // [dao]
        miControladorUsuario.setUsuarioDAO(miUsuarioDAO);
        miControladorProveedor.setProveedorDAO(miProveedorDAO);
        miControladorProducto.SetProductoDAO(miProductoDAO);
        miControladorVenta.setVentaDAO(miVentaDAO);
        miControladorVenta.setClienteDAO(miClienteDAO);
        miControladorVenta.setPedidoDAO(miPedidoDAO);
        miControladorVenta.SetProductoDAO(miProductoDAO);
        
        // [general vistas]
        miControladorGeneral.setPanelUsuarios(miPanelUsuarios);
        miControladorGeneral.setPanelProveedores(miPanelProveedores);
        miControladorGeneral.setPanelProducto(miPanelProducto);
        miControladorGeneral.setPanelVentas(miPanelVentas);
        miControladorGeneral.setVentanaPrincipal(miVentanaPrincipal);

/* ---------------------------------------------------------------------------------------- */
        // CONECTANDO VISTAS Y MODELOS AL CONTROLADOR
        
        // [vistas]
        miPanelUsuarios.setControlador(miControladorUsuario);
        miPanelProducto.setControlador(miControladorProducto);
        miPanelProveedores.setControlador(miControladorProveedor);
        miPanelVentas.setControlador(miControladorVenta);
        
        // [dao]
        miUsuarioDAO.setControladorUsuarios(miControladorUsuario);
        miProductoDAO.setControladorProducto(miControladorProducto);
        miProveedorDAO.setControladorProveedor(miControladorProveedor);
        miVentaDAO.setControladorVentas(miControladorVenta);
        miPedidoDAO.setControladorVentas(miControladorVenta);
        miClienteDAO.setControladorVentas(miControladorVenta);
        
        miVentanaPrincipal.setControladorGeneral(miControladorGeneral);

/* ---------------------------------------------------------------------------------------- */
        // CARGANDO PANELES
        miVentanaPrincipal.add(miPanelUsuarios);
        miVentanaPrincipal.add(miPanelProducto);
        miVentanaPrincipal.add(miPanelProveedores);
        miVentanaPrincipal.add(miPanelVentas);
        
/* ---------------------------------------------------------------------------------------- */
        // SETEANDO TABLAS
        miPanelUsuarios.setTabla(miUsuarioDAO.listarUsuarios());
        miPanelProveedores.setTabla(miProveedorDAO.mostrarProveedores());
        miPanelProducto.setTablaProductos(miControladorProducto.mostrarProductos());
        miPanelProducto.setTablaCategoria(CategoriaDAO.mostrarCategorias());
        miPanelProducto.colocarCategorias(CategoriaDAO.mostrarCategorias());
    }
}
