/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import controlador.ControladorProducto;
import vista.PanelProducto;
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
        PanelProducto panel = new PanelProducto();
        ControladorProducto con = new ControladorProducto(panel);
        vp.panCardChange.add(panel);
        vp.setVisible(true);
    }

}
