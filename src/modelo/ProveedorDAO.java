/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Daniel
 */
import controlador.ControladorProveedor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;


public class ProveedorDAO extends ConexionDB{
    
    ControladorProveedor miControladorProveedor;
      
    final String INSERT = "INSERT INTO proveedores(idProveedor, nombre, direccion, telefono) VALUES(?,?,?,?)";
    final String UPDATE = "UPDATE proveedores SET nombre = ?, direccion = ?, telefono = ? WHERE idProveedor = ?";
    final String DELETE = "DELETE from proveedores WHERE idProveedor = ?";
    final String SEARCH = "SELECT idProveedor, nombre, direccion, telefono from proveedores WHERE idProveedor = ?";
    final String SEARCHALL = "SELECT idProveedor, nombre, direccion, telefono from proveedores";

    public void registrarProveedor(Proveedor p){     
        PreparedStatement stat = null;
        try{
            Connection con = getConexion();
            stat = con.prepareStatement(INSERT);
            stat.setInt(1, p.getIdProveedor());
            stat.setString(2, p.getNombre());
            stat.setString(3, p.getDireccion());
            stat.setString(4, p.getTelefono());
            if(stat.executeUpdate() ==0){
                System.out.println("Puede que el proveedor no haya sido registrado");
            }
            con.close();
        } catch(SQLException ex){
            System.out.println(ex.getMessage());
            JOptionPane.showMessageDialog(null, "No se Registro el proveedor");
        } finally{
            if(stat != null){
                try {
                    stat.close();
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }
            } 
        }    
    };
    
    private Proveedor convertir(ResultSet rs)throws SQLException{
        int idProveedor = rs.getInt("idProveedor");
        String nombre = rs.getString("nombre");
        String direccion = rs.getString("direccion");
        String telefono = rs.getString("telefono");
        Proveedor p = new Proveedor(idProveedor, nombre, direccion, telefono);
        return p;
    }
   
    public Proveedor buscarProveedor(int idProveedor) {   
        PreparedStatement stat = null;
        ResultSet rs = null;
        Proveedor p = null;
        try{
            Connection con = getConexion();
            stat = con.prepareStatement(SEARCH);
            stat.setInt(1, idProveedor);
            rs = stat.executeQuery();
            if(rs.next()){
                p = convertir(rs);
            }else{
                System.out.println("No se ha encontrando ese registro");
            }
            con.close();
        } catch(SQLException ex){
            System.out.println(ex.getMessage());
            JOptionPane.showMessageDialog(null, "No se encontro el proveedor");
        } finally{
            if(rs != null){
                try {
                    rs.close();
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                    System.out.println("Error de SQL");
                }
            } 
            if(stat != null){
                try {
                    stat.close();
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                    System.out.println("Error de SQL");
                }
            } 
        }
        return p;
    };
    
    public ArrayList<Proveedor> mostrarProveedores(){   
        PreparedStatement stat = null;
        ResultSet rs = null;
        ArrayList<Proveedor> p = new ArrayList<>();
        try{
            Connection con = getConexion();
            stat = con.prepareStatement(SEARCHALL);
            rs = stat.executeQuery();
            while(rs.next()){
                p.add(convertir(rs));
            }
            con.close();
        } catch(SQLException ex){
            System.out.println(ex.getMessage());
            JOptionPane.showMessageDialog(null, "Error de SQL");
        } finally{
            if(rs != null){
                try {
                    rs.close();
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                    System.out.println("Error de SQL");
                }
            } 
            if(stat != null){
                try {
                    stat.close();
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                    System.out.println("Error de SQL");
                }
            } 
        }
        return p;    
    }
    
    public void modificarProveedor(Proveedor p){   
        PreparedStatement stat = null;
        try{
            Connection con = getConexion();
            stat = con.prepareStatement(UPDATE);
            stat.setString(1, p.getNombre());
            stat.setString(2, p.getDireccion());
            stat.setString(3, p.getTelefono());
            stat.setInt(4, p.getIdProveedor());
            if(stat.executeUpdate()==0){
                System.out.println("Puede que el proveedor no haya sido modificado");
            }
            con.close();
        } catch(SQLException ex){
            System.out.println(ex.getMessage());
            System.out.println("No se modifico el proveedor");
        } finally{
            if(stat != null){
                try {
                    stat.close();
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                    System.out.println("Error de SQL");
                }
            } 
        }   
    };
    
    public void eliminarProveedor(int idProveedor){   
        PreparedStatement stat = null;
        try{
            Connection con = getConexion();
            stat = con.prepareStatement(DELETE);
            stat.setInt(1, idProveedor);
            if(stat.executeUpdate()==0){
                System.out.println("Puede que el proveedor no haya sido eliminado");
            }
            con.close();
        } catch(SQLException ex){
            System.out.println(ex.getMessage());
            System.out.println("No se elimino proveedor");
        } finally{
            if(stat != null){
                try {
                    stat.close();
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                    System.out.println("Error de SQL");
                }
            } 
        } 
    }

    public void setControladorProveedor(ControladorProveedor miControladorProveedor) {
        this.miControladorProveedor = miControladorProveedor;
    }
}
