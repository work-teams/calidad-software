/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

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
        VentanaPrincipal vp = new VentanaPrincipal();
        PanelUsuarios panel = new PanelUsuarios();
        panel.setBounds(0, 180, 1446, 736);
        vp.add(panel);
        vp.setVisible(true);
    }
    
}
