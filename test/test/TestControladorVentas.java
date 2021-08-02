/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import controlador.ControladorVenta;
import modelo.dao.ClienteDAO;
import modelo.dao.VentaDAO;
import modelo.vo.Cliente;
import modelo.vo.Venta;

/**
 *
 * @author krypt97
 */
public class TestControladorVentas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        VentaDAO miVentaDAO = new VentaDAO();
//        int nuevaVenta = miVentaDAO.generarIdVenta();
//        System.out.println(nuevaVenta);
        
        Cliente miCliente = new Cliente();
        miCliente.setApellido("asd");
        miCliente.setDniCliente("73367034");
        miCliente.setNombre("asd");
        miCliente.setRuc("0");
        
        ControladorVenta miControladorVenta = new ControladorVenta();
        miControladorVenta.registrarCliente(miCliente);
        
        //ClienteDAO miClienteDAO = new ClienteDAO();
        //miClienteDAO.registrarCliente(miCliente);
        
//        Venta miVenta = new Venta("8", "8", 8, true);
//        miVentaDAO.registrarVenta(miVenta);
        
    }
    
}
