/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import vista.NewPanelUsuarios;
import vista.VentanaPrincipal;

/**
 *
 * @author krypt97
 */
public class TestVentanaPrincipal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        VentanaPrincipal vp = new VentanaPrincipal();
        NewPanelUsuarios panel = new NewPanelUsuarios();
        panel.setBounds(0, 180, 1446, 736);
        vp.add(panel);
        vp.setVisible(true);
    }
    
}
