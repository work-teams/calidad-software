/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import controlador.ControladorUsuario;
import modelo.Usuario;
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
//        VentanaPrincipal vp = new VentanaPrincipal();
//        PanelUsuarios panel = new PanelUsuarios();
//        panel.setBounds(0, 180, 1446, 736);
//        vp.add(panel);
//        vp.setVisible(true);
//        
    public static void main(String[] args) {
        // TODO code application logic here
        VentanaPrincipal miVentanaPrincipal = new VentanaPrincipal();

        Usuario miUsuario = null;
        UsuarioDAO miUsuarioDAO = new UsuarioDAO();
        PanelUsuarios miPanelUsuarios = new PanelUsuarios();
        ControladorUsuario miControladorUsuario = new ControladorUsuario();
        
        miControladorUsuario.setPanelUsuarios(miPanelUsuarios);
        miControladorUsuario.setUsuarioDAO(miUsuarioDAO);
        
        miUsuarioDAO.setControlador(miControladorUsuario);
        miPanelUsuarios.setControlador(miControladorUsuario);
        miPanelUsuarios.setUsuario(miUsuario);
        
        
        
        
        
        
        
        
        
        
        
        miPanelUsuarios.setBounds(0, 180, 1446, 736);
        miVentanaPrincipal.add(miPanelUsuarios);
        miVentanaPrincipal.setVisible(true);
        
        
        
        
        
    }
    
}
