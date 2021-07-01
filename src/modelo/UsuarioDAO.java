/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author willi
 */

import java.sql.*;
import javax.swing.*; 

public class UsuarioDAO extends ConexionDB{
    
    private final Connection con = ConexionDB.getConexion();
    
    final String INSERT = "INSERT INTO usuario(dniUsuario, apellido, nombre, username, password, privilegios)";
    final String UPDATE = "UPDATE usuario SET dniUsuario = ?, apellido = ?, nombre = ?, username = ?, password= ?, privilegios = ? WHERE dniUsuario = ?";
    final String DELETE = "DELETE  from usuario WHERE dniUsuario = ?";
    final String SEARCH = "SELECT dniUsuario, apellido, nombre, username, password, privilegios WHERE dniUsuario = ?";
    
    public UsuarioDAO (){
        
    }
    
    public void registrarUsuario(Usuario u){
        PreparedStatement stat = null;
        try{
           stat = con.prepareStatement(INSERT);
           stat.setInt(1, u.getDniUsuario());
           stat.setString(2, u.getApellido());
           stat.setString(3, u.getNombre());
           stat.setString(4, u.getUsername());
           stat.setString(5, u.getPassword());
           stat.setBoolean(6, u.isPrivilegios());
           
           if(stat.executeUpdate() == 0){
               JOptionPane.showMessageDialog(null,"Puede que no se haya registrado el usuario");
           }
        }catch (SQLException ex){
            System.out.println(ex.getMessage());
            JOptionPane.showMessageDialog(null,"No se pudo registrar el usuario");
        }finally{
            if(stat != null){
                try{
                    stat.close();
                }catch(SQLException ex){
                    System.out.println(ex.getMessage());
                }
            }
        }
    }
    
    private Usuario convertir(ResultSet rs)throws SQLException{
        int dniUsuario = rs.getInt("dniUsuario");
        String apellido = rs.getString("apellido");
        String nombre = rs.getString("nombre");
        String username = rs.getString("username");
        String password = rs.getString("password");
        boolean privilegios = rs.getBoolean("privilegios");
        Usuario u = new Usuario(dniUsuario, apellido, nombre, username, password, privilegios);
        return u;
    }
    
    public Usuario buscarUsuario(int dniUsuario){
        PreparedStatement stat = null;
        ResultSet rs = null;
        Usuario u = null;
        try{
            stat = con.prepareStatement(SEARCH);
            stat.setInt(1, dniUsuario);
            rs = stat.executeQuery();
            if(rs.next()){
                u = convertir(rs);
            }else{
                System.out.println("No se encontro usuario");
            }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
            JOptionPane.showMessageDialog(null, "No se encontro usuario");
        }finally{
            if(rs != null){
                try{
                    stat.close();
                }catch(SQLException ex){
                    System.out.println(ex.getMessage());
                    JOptionPane.showMessageDialog(null, "Error en SQL");
                }
            }
        }
        return u;
    }
    
    public void modificarUsuario(Usuario u){
        PreparedStatement stat = null;
        try{
            stat = con.prepareStatement(UPDATE);
            stat.setString(1, u.getApellido());
            stat.setString(2, u.getNombre());
            stat.setString(3, u.getUsername());
            stat.setString(4, u.getPassword());
            stat.setBoolean(5, u.isPrivilegios());
            stat.setInt(6, u.getDniUsuario());
            if(stat.executeUpdate() == 0){
                System.out.println("Es posible que no se haya modificado el Usuario");
            }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
            JOptionPane.showMessageDialog(null, "No se modifico el Usuario");
        }finally{
            if(stat != null){
                try{
                    stat.close();
                }catch(SQLException ex){
                    System.out.println(ex.getMessage());
                    JOptionPane.showMessageDialog(null, "Error SQL");
                }
            }
        }
    }
    
    public void eliminarUsuario(int dniUsuario){
        PreparedStatement stat = null; 
        try{
            stat = con.prepareStatement(DELETE);
            stat.setInt(1,dniUsuario);
            if(stat.executeUpdate() == 0){
                System.out.println("Puede que no se halla eliminado el usuario");
            }       
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
            JOptionPane.showMessageDialog(null, "Error SQL");
        }
    }
}
