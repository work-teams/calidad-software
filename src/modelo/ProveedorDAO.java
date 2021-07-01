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
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


public class ProveedorDAO extends ConexionDB{
    
    private final Connection con = getConexion();
    
    final String INSERT = "INSERT INTO proveedor(idProveedor, nombre, direccion, telefono, correo) VALUES(?,?,?,?,?)";
    final String UPDATE = "UPDATE proveedor SET nombre = ?, direccion = ?, telefono = ?, correo = ? WHERE idProveedor = ?";
    final String DELETE = "DELETE from proveedor WHERE idProveedor = ?";
    final String SEARCH = "SELECT idProveedor, nombre, direccion, telefono, correo from proveedor WHERE idProveedor = ?";
    final String SEARCHALL = "SELECT idProveedor, nombre, direccion, telefono, correo from proveedor";

    public ProveedorDAO() {
    }

    public void registrarProveedor(Proveedor p){
        PreparedStatement stat = null;
        try{
            stat = con.prepareStatement(INSERT);
            stat.setInt(1, p.getIdProveedor());
            stat.setString(2, p.getNombre());
            stat.setString(3, p.getDireccion());
            stat.setString(4, p.getTelefono());
            stat.setString(5, p.getCorreo());
            if(stat.executeUpdate() ==0){
                System.out.println("Puede que el proveedor no haya sido registrado");
            }
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
        String correo = rs.getString("correo");
        Proveedor p = new Proveedor(idProveedor, nombre, direccion, telefono, correo);
        return p;
    }
   
    public Proveedor buscarProveedor(int idProveedor) {
        PreparedStatement stat = null;
        ResultSet rs = null;
        Proveedor p = null;
        try{
            stat = con.prepareStatement(SEARCH);
            stat.setInt(1, idProveedor);
            rs = stat.executeQuery();
            if(rs.next()){
                p = convertir(rs);
            }else{
                System.out.println("No se ha encontrando ese registro");
            }
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
    
    public List<Proveedor> mostrarProveedores(){ 
        PreparedStatement stat = null;
        ResultSet rs = null;
        List<Proveedor> p = new ArrayList<>();
        try{
            stat = con.prepareStatement(SEARCHALL);
            rs = stat.executeQuery();
            while(rs.next()){
                p.add(convertir(rs));
            }
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
            stat = con.prepareStatement(UPDATE);
            stat.setString(1, p.getNombre());
            stat.setString(2, p.getDireccion());
            stat.setString(3, p.getTelefono());
            stat.setString(4, p.getCorreo());
            stat.setInt(5, p.getIdProveedor());
            if(stat.executeUpdate()==0){
                System.out.println("Puede que el proveedor no haya sido modificado");
            }
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
            stat = con.prepareStatement(DELETE);
            stat.setInt(1, idProveedor);
            if(stat.executeUpdate()==0){
                System.out.println("Puede que el proveedor no haya sido eliminado");
            }
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
}
