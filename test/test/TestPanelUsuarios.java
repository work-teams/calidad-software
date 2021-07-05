/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import controlador.ControladorUsuario;
import modelo.UsuarioDAO;
import vista.PanelUsuarios;
import vista.VentanaPrincipal;

/**
 *
 * @author krypt97
 */
public class TestPanelUsuarios {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        VentanaPrincipal miVentanaPrincipal = new VentanaPrincipal();

        // Unica instancia de los elementos a conectar
        UsuarioDAO miUsuarioDAO = new UsuarioDAO();
        PanelUsuarios miPanelUsuarios = new PanelUsuarios();
        miPanelUsuarios.setTabla(miUsuarioDAO.listarUsuarios());
        ControladorUsuario miControladorUsuario = new ControladorUsuario();
        
        // Conectando elementos al controlador
        miControladorUsuario.setPanelUsuarios(miPanelUsuarios);
        miControladorUsuario.setUsuarioDAO(miUsuarioDAO);
        
        // Conectando controlador a los elementos
        miUsuarioDAO.setControlador(miControladorUsuario);
        miPanelUsuarios.setControlador(miControladorUsuario);
        
        // Esto es solo una demo
        miPanelUsuarios.setBounds(0, 180, 1446, 736);
        miVentanaPrincipal.add(miPanelUsuarios);
        miVentanaPrincipal.setVisible(true);
    }
}
