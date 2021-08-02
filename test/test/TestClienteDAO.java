/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.util.ArrayList;
import modelo.dao.CategoriaDAO;
import modelo.dao.PedidoDAO;
import modelo.vo.Pedido;

/**
 *
 * @author krypt97
 */
public class TestClienteDAO {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Pedido miCliente = new Pedido();
        PedidoDAO miClienteDAO = new PedidoDAO();
        
        Pedido miCliente2 = new Pedido();
        
        miCliente2.setIdPedido(1);
        //miCliente2.setIdVenta("10");
        //miCliente2.setIdProducto("120");
        miCliente2.setCantidad(145);
        
        miCliente.setIdPedido(12);
        //miCliente.setIdVenta("10");
        //miCliente.setIdProducto("121");
        miCliente.setCantidad(141);
        
        
        
        //miClienteDAO.registrarPedido(miCliente);
        //miClienteDAO.registrarPedido(miCliente2);
        //miClienteDAO.eliminarPedido(1000);
        //System.out.println(miClienteDAO.listarCarritoPedidos("1000").getCantidad());
        //miClienteDAO.modificarPedido(miCliente);
        
        /*
        ArrayList<Pedido> miArrayList;
        miArrayList = miClienteDAO.listarPedido();
        
        for (int i = 0; i < miArrayList.size(); i++) {
            System.out.println(miArrayList.get(i).getIdVenta());
        }*/
        
        System.out.println("\n\nListar Busqueda \n\n");
        
        ArrayList<Pedido> miArrayList;
        //miArrayList = miClienteDAO.listarCarritoPedidos("10");
        
        //for (int i = 0; i < miArrayList.size(); i++) {
            //System.out.println(miArrayList.get(i).getIdVenta());
        //}
        
        
    }
    
}
