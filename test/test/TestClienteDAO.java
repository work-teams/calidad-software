/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.util.ArrayList;
import modelo.dao.ClienteDAO;
import modelo.vo.Cliente;

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
        Cliente miCliente = new Cliente();
        ClienteDAO miClienteDAO = new ClienteDAO();
        
        miCliente.setDniCliente("73367034");
        miCliente.setApellido("MARIN EVANGELISTA");
        miCliente.setNombre("JORGE LUIS");
        miCliente.setRuc("18200275");
        
        //miClienteDAO.registrarCliente(miCliente);
        //miClienteDAO.eliminarCliente("73367034");
        //System.out.println(miClienteDAO.buscarCliente("73367034").getApellido());
        //miClienteDAO.modificarCliente(miCliente);
        
        ArrayList<Cliente> miArrayList;
        miArrayList = miClienteDAO.listarClientes();
        
        for (int i = 0; i < miArrayList.size(); i++) {
            System.out.println(miArrayList.get(i).getApellido());
        }
    }
    
}
