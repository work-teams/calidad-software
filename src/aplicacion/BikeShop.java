/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion;

import controlador.ControladorCliente;
import controlador.ControladorGeneral;
import controlador.ControladorHistorialVenta;
import controlador.ControladorLogin;
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
import modelo.vo.Cliente;
import modelo.vo.Pedido;
import modelo.vo.Producto;
import modelo.vo.Proveedor;
import modelo.vo.Usuario;
import modelo.vo.Venta;
import vista.PanelClientes;
import vista.PanelHistorialVentas;
import vista.PanelProducto;
import vista.PanelProveedores;
import vista.PanelUsuarios;
import vista.PanelVentas;
import vista.VentanaLogin;
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
        // Vista
        VentanaPrincipal miVentanaPrincipal = new VentanaPrincipal();
        VentanaLogin miVentanaLogin = new VentanaLogin();
        PanelUsuarios miPanelUsuarios = new PanelUsuarios();
        PanelProducto miPanelProducto = new PanelProducto();
        PanelProveedores miPanelProveedores = new PanelProveedores();
        PanelVentas miPanelVentas = new PanelVentas();
        PanelClientes miPanelClientes = new PanelClientes();
        PanelHistorialVentas miPanelHistorialVentas = new PanelHistorialVentas();
        // Vo
        Usuario miUsuario = new Usuario();
        Producto miProducto = new Producto();
        Proveedor miProveedor = new Proveedor();
        Venta miVenta = new Venta();
        Pedido miPedido = new Pedido();
        Cliente miCliente = new Cliente();
        // Dao
        UsuarioDAO miUsuarioDAO = new UsuarioDAO();
        ProductoDAO miProductoDAO = new ProductoDAO();
        CategoriaDAO miCategoriaDAO = new CategoriaDAO();
        ProveedorDAO miProveedorDAO = new ProveedorDAO();
        VentaDAO miVentaDAO = new VentaDAO();
        PedidoDAO miPedidoDAO = new PedidoDAO();
        ClienteDAO miClienteDAO = new ClienteDAO();
        // Controlador
        ControladorUsuario miControladorUsuario = new ControladorUsuario();
        ControladorProducto miControladorProducto = new ControladorProducto();
        ControladorProveedor miControladorProveedor = new ControladorProveedor();
        ControladorVenta miControladorVenta = new ControladorVenta();
        ControladorCliente miControladorCliente = new ControladorCliente();
        ControladorHistorialVenta miControladorHistorialVenta = new ControladorHistorialVenta();
        ControladorLogin miControladorLogin = new ControladorLogin();
        // Controlador general
        ControladorGeneral miControladorGeneral = new ControladorGeneral();

        /* ------------------------------------------------------------------ */
        // CONECTANDO CONTROLADOR A VISTAS Y MODELOS
        // Vistas
        miControladorUsuario.setPanelUsuarios(miPanelUsuarios);
        miControladorProveedor.setPanelProveedores(miPanelProveedores);
        miControladorProducto.setPanelProducto(miPanelProducto);
        miControladorVenta.setPanelVentas(miPanelVentas);
        miControladorCliente.setPanelClientes(miPanelClientes);
        miControladorHistorialVenta.setPanelHistorialVentas(miPanelHistorialVentas);
        miControladorLogin.setVentanaLogin(miVentanaLogin);
        miControladorLogin.setVentanaPrincipal(miVentanaPrincipal);
        // Vo
        miControladorProveedor.setProveedor(miProveedor);
        miControladorProducto.setProducto(miProducto);
        miControladorVenta.setVenta(miVenta);
        miControladorVenta.setCliente(miCliente);
        miControladorVenta.setPedido(miPedido);
        miControladorVenta.setUsuario(miUsuario);
        miControladorLogin.setUsuario(miUsuario);
        // Dao
        miControladorUsuario.setUsuarioDAO(miUsuarioDAO);
        miControladorProveedor.setProveedorDAO(miProveedorDAO);
        miControladorProducto.SetProductoDAO(miProductoDAO);
        miControladorProducto.SetCategoriaDAO(miCategoriaDAO);
        miControladorProducto.SetProveedorDAO(miProveedorDAO);
        miControladorVenta.setVentaDAO(miVentaDAO);
        miControladorVenta.setClienteDAO(miClienteDAO);
        miControladorVenta.setPedidoDAO(miPedidoDAO);
        miControladorVenta.SetProductoDAO(miProductoDAO);
        miControladorVenta.setCategoriaDAO(miCategoriaDAO);
        miControladorCliente.setUsuarioDAO(miUsuarioDAO);
        miControladorCliente.setVentaDAO(miVentaDAO);
        miControladorHistorialVenta.setCategoriaDAO(miCategoriaDAO);
        miControladorHistorialVenta.setClienteDAO(miClienteDAO);
        miControladorHistorialVenta.setPedidoDAO(miPedidoDAO);
        miControladorHistorialVenta.setProductoDAO(miProductoDAO);
        miControladorHistorialVenta.setUsuarioDAO(miUsuarioDAO);
        miControladorLogin.setUsuarioDAO(miUsuarioDAO);
        // General vistas
        miControladorGeneral.setPanelUsuarios(miPanelUsuarios);
        miControladorGeneral.setPanelProveedores(miPanelProveedores);
        miControladorGeneral.setPanelProducto(miPanelProducto);
        miControladorGeneral.setPanelVentas(miPanelVentas);
        miControladorGeneral.setPanelClientes(miPanelClientes);
        miControladorGeneral.setPanelHistorialVentas(miPanelHistorialVentas);
        miControladorGeneral.setVentanaPrincipal(miVentanaPrincipal);
        miControladorGeneral.setVentanaLogin(miVentanaLogin);
        // General dao
        miControladorGeneral.setMiClienteDAO(miClienteDAO);
        miControladorGeneral.setMiVentaDAO(miVentaDAO);

        /* ------------------------------------------------------------------ */
        // CONECTANDO VISTAS AL CONTROLADOR
        // Vistas
        miPanelUsuarios.setControlador(miControladorUsuario);
        miPanelProducto.setControlador(miControladorProducto);
        miPanelProveedores.setControlador(miControladorProveedor);
        miPanelVentas.setControlador(miControladorVenta);
        miPanelClientes.setControlador(miControladorCliente);
        miPanelHistorialVentas.setControlador(miControladorHistorialVenta);
        miVentanaLogin.setControlador(miControladorLogin);
        miVentanaPrincipal.setControladorGeneral(miControladorGeneral);

        /* ------------------------------------------------------------------ */
        // CARGANDO PANELES
        miVentanaPrincipal.add(miPanelUsuarios);
        miVentanaPrincipal.add(miPanelProducto);
        miVentanaPrincipal.add(miPanelProveedores);
        miVentanaPrincipal.add(miPanelVentas);
        miVentanaPrincipal.add(miPanelClientes);
        miVentanaPrincipal.add(miPanelHistorialVentas);

        /* ------------------------------------------------------------------ */
        // SETEANDO TABLAS
        miPanelUsuarios.setTablaUsuarios(miUsuarioDAO.listarUsuarios());
        miPanelProveedores.setTablaProveedores(miProveedorDAO.listarProveedores());
        miPanelProducto.setTablaProductos(miProductoDAO.listarProductos(), miCategoriaDAO.listarCategorias(), miProveedorDAO.listarProveedores());
        miPanelProducto.setTablaCategoria(miCategoriaDAO.listarCategorias());
        miPanelProducto.setCmbxCategorias(miCategoriaDAO.listarCategorias());
        miPanelVentas.setTablaPedido(miPedidoDAO.listarCarritoPedidos(miVentaDAO.generarIdVenta()), miCategoriaDAO.listarCategorias());
        miPanelClientes.setTablaClientes(miClienteDAO.listarClientes());
        miPanelHistorialVentas.setTablaVentas(miVentaDAO.listarVentas());
    }
}
