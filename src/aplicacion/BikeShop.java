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
import modelo.dao.CategoriaDAO;
import modelo.dao.ProductoDAO;
import modelo.dao.ProveedorDAO;
import modelo.dao.UsuarioDAO;
import vista.PanelProducto;
import vista.PanelProveedores;
import vista.PanelUsuarios;
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
        VentanaPrincipal miVentanaPrincipal = new VentanaPrincipal();
        PanelUsuarios miPanelUsuarios = new PanelUsuarios();
        PanelProducto MiPanelProducto = new PanelProducto();
        PanelProveedores miPanelProveedores = new PanelProveedores();
        UsuarioDAO miUsuarioDAO = new UsuarioDAO();
        ProductoDAO miProductoDAO = new ProductoDAO();
        ProveedorDAO miProveedorDAO = new ProveedorDAO();
        ControladorUsuario miControladorUsuario = new ControladorUsuario();
        ControladorProducto miControladorProducto = new ControladorProducto();
        ControladorProveedor miControladorProveedor = new ControladorProveedor();
        ControladorGeneral miControladorGeneral = new ControladorGeneral();

        

        // CONECTANDO CONTROLADOR A VISTAS Y/O MODELOS
        miControladorUsuario.setPanelUsuarios(miPanelUsuarios);
        miControladorProveedor.setPanelProveedores(miPanelProveedores);
        miControladorProducto.setPanelProducto(MiPanelProducto);
        miControladorUsuario.setUsuarioDAO(miUsuarioDAO);
        miControladorProveedor.setProveedorDAO(miProveedorDAO);
        miControladorProducto.SetProductoDAO(miProductoDAO);
        miControladorGeneral.setPanelUsuarios(miPanelUsuarios);
        miControladorGeneral.setPanelProveedores(miPanelProveedores);
        miControladorGeneral.setPanelProducto(MiPanelProducto);
        miControladorGeneral.setVentanaPrincipal(miVentanaPrincipal);

        

        // CONECTANDO VISTAS Y MODELOS AL CONTROLADOR
        miPanelUsuarios.setControlador(miControladorUsuario);
        MiPanelProducto.setControlador(miControladorProducto);
        miPanelProveedores.setControlador(miControladorProveedor);
        miUsuarioDAO.setControlador(miControladorUsuario);
        miProductoDAO.setControladorProducto(miControladorProducto);
        miProveedorDAO.setControladorProveedor(miControladorProveedor);
        miVentanaPrincipal.setControladorGeneral(miControladorGeneral);

        
        
        // CARGANDO PANELES
        miVentanaPrincipal.add(miPanelUsuarios);
        miVentanaPrincipal.add(MiPanelProducto);
        miVentanaPrincipal.add(miPanelProveedores);
        

        
        // SETEANDO TABLAS
        miPanelUsuarios.setTabla(miUsuarioDAO.listarUsuarios());
        miPanelProveedores.setTabla(miProveedorDAO.mostrarProveedores());
        MiPanelProducto.setTablaProductos(miControladorProducto.mostrarProductos());
        MiPanelProducto.setTablaCategoria(CategoriaDAO.mostrarCategorias());
        MiPanelProducto.colocarCategorias(CategoriaDAO.mostrarCategorias());
    }
}
