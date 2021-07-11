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
        ControladorGeneral miControladorGeneral = new ControladorGeneral();

        UsuarioDAO miUsuarioDAO = new UsuarioDAO();
        PanelUsuarios miPanelUsuarios = new PanelUsuarios();
        ControladorUsuario miControladorUsuario = new ControladorUsuario();

        PanelProducto MiPanelProducto = new PanelProducto();
        ProductoDAO miProductoDAO = new ProductoDAO();
        ControladorProducto miControladorProducto = new ControladorProducto();

        ProveedorDAO miProveedorDAO = new ProveedorDAO();
        PanelProveedores miPanelProveedores = new PanelProveedores();
        ControladorProveedor miControladorProveedor = new ControladorProveedor();

        // CONECTANDO CONTROLADOR A VISTAS Y/O MODELOS
        miControladorGeneral.setVentanaPrincipal(miVentanaPrincipal);
        miControladorGeneral.setPanelUsuarios(miPanelUsuarios);
        miControladorGeneral.setPanelProveedores(miPanelProveedores);
        miControladorGeneral.setPanelProducto(MiPanelProducto);

        miControladorUsuario.setPanelUsuarios(miPanelUsuarios);
        miControladorUsuario.setUsuarioDAO(miUsuarioDAO);

        miControladorProveedor.setPanelProveedores(miPanelProveedores);
        miControladorProveedor.setProveedorDAO(miProveedorDAO);

        miControladorProducto.setPanelProducto(MiPanelProducto);
        miControladorProducto.SetProductoDAO(miProductoDAO);

        // CONECTANDO VISTAS Y MODELOS AL CONTROLADOR
        miVentanaPrincipal.setControladorGeneral(miControladorGeneral);

        miUsuarioDAO.setControlador(miControladorUsuario);
        miPanelUsuarios.setControlador(miControladorUsuario);

        miProveedorDAO.setControladorProveedor(miControladorProveedor);
        miPanelProveedores.setControlador(miControladorProveedor);

        miProductoDAO.setControladorProducto(miControladorProducto);
        MiPanelProducto.setControlador(miControladorProducto);

        // SETEANDO TABLAS
        miPanelUsuarios.setTabla(miUsuarioDAO.listarUsuarios());

        miPanelProveedores.setTabla(miProveedorDAO.mostrarProveedores());

        MiPanelProducto.setTablaProductos(miControladorProducto.mostrarProductos());
        MiPanelProducto.setTablaCategoria(CategoriaDAO.mostrarCategorias());
        MiPanelProducto.colocarCategorias(CategoriaDAO.mostrarCategorias());
    }
}
