/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import controlador.ControladorProducto;
import modelo.CategoriaDAO;
import modelo.ProductoDAO;
import vista.PanelProducto;
import vista.VentanaPrincipal;

/**
 *
 * @author krypt97
 */
public class TestPanelProductos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        VentanaPrincipal vp = new VentanaPrincipal();

        PanelProducto panel = new PanelProducto();
        ProductoDAO dao = new ProductoDAO();
        ControladorProducto control = new ControladorProducto();

        control.setPanelProducto(panel);
        control.SetProductoDAO(dao);

        dao.setControladorProducto(control);
        panel.setControlador(control);
        panel.setTablaProductos(control.mostrarProductos());        
        panel.setTablaCategoria(CategoriaDAO.mostrarCategorias());
        panel.colocarCategorias(CategoriaDAO.mostrarCategorias());
        
        
        panel.setBounds(0, 180, 1446, 736);
        vp.add(panel);
        vp.setVisible(true);
    }
}
