/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion;

import java.awt.Frame;
import javax.swing.UIManager;
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
        try {
            // TODO code application logic here
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception c) {
            
        }
        VentanaPrincipal sistema= new VentanaPrincipal();
        sistema.setExtendedState(Frame.MAXIMIZED_BOTH);
        sistema.setVisible(true);
    }
    
}
