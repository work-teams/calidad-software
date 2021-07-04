/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import modelo.UsuarioDAO;

/**
 *
 * @author krypt97
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        UsuarioDAO miUsuarioDAO = new UsuarioDAO();
        for (int i = 0; i < miUsuarioDAO.listarUsuarios().size(); i++) {
            System.out.print(miUsuarioDAO.listarUsuarios().get(i).getDniUsuario());
            System.out.print(miUsuarioDAO.listarUsuarios().get(i).getApellido());
            System.out.print(miUsuarioDAO.listarUsuarios().get(i).getNombre());
            System.out.print(miUsuarioDAO.listarUsuarios().get(i).getUsername());
            System.out.print(miUsuarioDAO.listarUsuarios().get(i).getPassword());
            System.out.println(miUsuarioDAO.listarUsuarios().get(i).getRol());
        }
        
        System.out.println(miUsuarioDAO.buscarUsuario("73367034").getUsername());
    }
    
}
