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

import controlador.ControladorUsuario;
import java.sql.*;
import javax.swing.*; 
import java.util.*;

public class UsuarioDAO extends ConexionDB{
    ControladorUsuario miconControladorUsuario;
    
    final String INSERT = "INSERT INTO usuarios(dniUsuario, apellido, nombre, username, password, privilegios) VALUES (?,?,?,?,?,?)";
    final String UPDATE = "UPDATE usuarios SET dniUsuario = ?, apellido = ?, nombre = ?, username = ?, password= ?, privilegios = ? WHERE dniUsuario = ?";
    final String DELETE = "DELETE from usuarios WHERE dniUsuario = ?";
    final String SEARCH = "SELECT dniUsuario, apellido, nombre, username, password, privilegios FROM usuarios WHERE dniUsuario = ?";
    
    public UsuarioDAO (){
        
    }
    
    public void registrarUsuario(Usuario u){
        Connection con = ConexionDB.getConexion();
        PreparedStatement stat = null;
        try{
           stat = con.prepareStatement(INSERT);
           stat.setInt(1, u.getDniUsuario());
           stat.setString(2, u.getApellido());
           stat.setString(3, u.getNombre());
           stat.setString(4, u.getUsername());
           stat.setString(5, u.getPassword());
           stat.setBoolean(6, u.isPrivilegios());
           stat.executeUpdate();
           
//           if(stat.executeUpdate() == 0){
//               JOptionPane.showMessageDialog(null,"Puede que no se haya registrado el usuario");
//           }
           con.close();
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
        Connection con = ConexionDB.getConexion();
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
            con.close();
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
        Connection con = ConexionDB.getConexion();
        PreparedStatement stat = null;
        try{
            stat = con.prepareStatement(UPDATE);
            stat.setInt(1, u.getDniUsuario());
            stat.setString(2, u.getApellido());
            stat.setString(3, u.getNombre());
            stat.setString(4, u.getUsername());
            stat.setString(5, u.getPassword());
            stat.setBoolean(6, u.isPrivilegios());
            stat.setInt(7, u.getDniUsuario());
            stat.executeUpdate();
//            if(stat.executeUpdate() == 0){
//                System.out.println("Es posible que no se haya modificado el Usuario");
//            }
            con.close();
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
        Connection con = ConexionDB.getConexion();
        PreparedStatement stat = null; 
        try{
            stat = con.prepareStatement(DELETE);
            stat.setInt(1,dniUsuario);
            stat.executeUpdate();
//            if(stat.executeUpdate() == 0){
//                System.out.println("Puede que no se halla eliminado el usuario");
//            } 
            con.close();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
            JOptionPane.showMessageDialog(null, "Error SQL");
        }
    }
    
    public ArrayList<Usuario> mostrarUsuarios(){
        ArrayList<Usuario> u = new ArrayList<>();
        PreparedStatement stat = null;
        ResultSet rs = null;
        try{
            Connection con = ConexionDB.getConexion();
            stat = con.prepareStatement("SELECT * FROM usuarios");
            rs = stat.executeQuery();
            
            while(rs.next()){
                u.add(convertir(rs));
            }
            con.close();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
            System.out.println("Probablemente no se hallo a todos los Usuarios");
        }
//        finally{
//            if(rs != null){
//                try{
//                    rs.close();
//                }catch(SQLException ex){
//                    System.out.println(ex.getMessage());
//                }
//            }
//            if(stat != null){
//                try{
//                    rs.close();
//                }catch(SQLException ex){
//                    System.out.println(ex.getMessage());
//                }
//            }
//        }
        return u;
    }

    public void setControlador(ControladorUsuario miControladorUsuario) {
        this.miconControladorUsuario = miControladorUsuario;
    }
}
