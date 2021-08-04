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
import modelo.vo.Categoria;
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
        PanelUsuarios miPanelUsuarios = new PanelUsuarios();
        PanelProducto miPanelProducto = new PanelProducto();
        PanelProveedores miPanelProveedores = new PanelProveedores();
        PanelVentas miPanelVentas = new PanelVentas();
        PanelClientes  miPanelClientes = new PanelClientes();
        PanelHistorialVentas miPanelHistorialVentas = new PanelHistorialVentas();
        // Vo
        Usuario miUsuario = new Usuario();
        Producto miProducto = new Producto();
        Categoria miCategoria = new Categoria();
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

        ControladorGeneral miControladorGeneral = new ControladorGeneral();

        /* ------------------------------------------------------------------ */
        // CONECTANDO CONTROLADOR A VISTAS
        // Vistas
        miControladorUsuario.setPanelUsuarios(miPanelUsuarios);
        miControladorProveedor.setPanelProveedores(miPanelProveedores);
        miControladorProducto.setPanelProducto(miPanelProducto);
        miControladorVenta.setPanelVentas(miPanelVentas);
        // Vo
        miControladorUsuario.setUsuario(miUsuario);
        miControladorProveedor.setProveedor(miProveedor);
        miControladorProducto.setProducto(miProducto);
        miControladorVenta.setVenta(miVenta);
        miControladorVenta.setCliente(miCliente);
        miControladorVenta.setPedido(miPedido);
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
        // General vistas
        miControladorGeneral.setPanelUsuarios(miPanelUsuarios);
        miControladorGeneral.setPanelProveedores(miPanelProveedores);
        miControladorGeneral.setPanelProducto(miPanelProducto);
        miControladorGeneral.setPanelVentas(miPanelVentas);
        miControladorGeneral.setPanelClientes(miPanelClientes);
        miControladorGeneral.setPanelHistorialVentas(miPanelHistorialVentas);
        miControladorGeneral.setVentanaPrincipal(miVentanaPrincipal);

        /* ------------------------------------------------------------------ */
        // CONECTANDO VISTAS Y MODELOS AL CONTROLADOR
        // Vistas
        miPanelUsuarios.setControlador(miControladorUsuario);
        miPanelProducto.setControlador(miControladorProducto);
        miPanelProveedores.setControlador(miControladorProveedor);
        miPanelVentas.setControlador(miControladorVenta);
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
        
        miPanelClientes.setTablaVentas(miVentaDAO.listarVentas(), miUsuarioDAO.listarUsuarios(), "74854108");
    }
}
