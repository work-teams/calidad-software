/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.awt.Frame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
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
//         TODO code application logic here
        try {
            // TODO code application logic here
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException c) {
            
        }
        VentanaPrincipal vp = new VentanaPrincipal();
        PanelUsuarios sistema= new PanelUsuarios();
        //sistema.setExtendedState(Frame.MAXIMIZED_BOTH);
        //vp.setExtendedState(Frame.MAXIMIZED_BOTH);
        vp.add(sistema);
        vp.setVisible(true);
        sistema.setVisible(true);
    }
    
}
