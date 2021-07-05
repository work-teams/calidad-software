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
    private Connection miConnection;
    private PreparedStatement stat;
    private ResultSet rs;
      
    final String INSERT = "INSERT INTO proveedores(idProveedor, nombre, direccion, telefono) VALUES(?,?,?,?)";
    final String UPDATE = "UPDATE proveedores SET nombre = ?, direccion = ?, telefono = ? WHERE idProveedor = ?";
    final String DELETE = "DELETE from proveedores WHERE idProveedor = ?";
    final String SEARCH = "SELECT idProveedor, nombre, direccion, telefono from proveedores WHERE idProveedor = ?";
    final String SEARCHALL = "SELECT idProveedor, nombre, direccion, telefono from proveedores";

    public void registrarProveedor(Proveedor p){     
        try{
            miConnection = getConexion();
            stat = miConnection.prepareStatement(INSERT);
            stat.setInt(1, p.getIdProveedor());
            stat.setString(2, p.getNombre());
            stat.setString(3, p.getDireccion());
            stat.setString(4, p.getTelefono());
            if(stat.executeUpdate() ==0){
                System.out.println("Puede que el proveedor no haya sido registrado");
            }
            
        } catch(SQLException ex){
            System.out.println(ex.getMessage());
            JOptionPane.showMessageDialog(null, "Este id ya esta siendo usado");
        } finally{
                try {
                    miConnection.close();
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
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
        Proveedor p = null;
        try{
            miConnection = getConexion();
            stat = miConnection.prepareStatement(SEARCH);
            stat.setInt(1, idProveedor);
            rs = stat.executeQuery();
            if(rs.next()){
                p = convertir(rs);
            }else{
                System.out.println("No se ha encontrando ese registro");
                JOptionPane.showMessageDialog(null, "No se encontro el proveedor");
            }
        } catch(SQLException ex){
            System.out.println(ex.getMessage());
            JOptionPane.showMessageDialog(null, "No se encontro el proveedor");
        } finally{
                try {
                    miConnection.close();
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                    System.out.println("Error de SQL");
                }
        }
        return p;
    };
    
    public ArrayList<Proveedor> mostrarProveedores(){   
        ArrayList<Proveedor> p = new ArrayList<>();
        try{
            miConnection = getConexion();
            stat = miConnection.prepareStatement(SEARCHALL);
            rs = stat.executeQuery();
            while(rs.next()){
                p.add(convertir(rs));
            }
        } catch(SQLException ex){
            System.out.println(ex.getMessage());
            JOptionPane.showMessageDialog(null, "Error de SQL");
        } finally{
                try {
                    miConnection.close();
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                    System.out.println("Error de SQL");
                }
        }
        return p;    
    }
    
    public void modificarProveedor(Proveedor p){   
        try{
            miConnection = getConexion();
            stat = miConnection.prepareStatement(UPDATE);
            stat.setString(1, p.getNombre());
            stat.setString(2, p.getDireccion());
            stat.setString(3, p.getTelefono());
            stat.setInt(4, p.getIdProveedor());
            if(stat.executeUpdate()==0){
                System.out.println("Puede que el proveedor no haya sido modificado");
                JOptionPane.showMessageDialog(null, "No se encontro el proveedor");
            }
        } catch(SQLException ex){
            System.out.println(ex.getMessage());
            System.out.println("No se modifico el proveedor");
        } finally{
                try {
                    miConnection.close();
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                    System.out.println("Error de SQL");
                }
        }   
    };
    
    public void eliminarProveedor(int idProveedor){   
        try{
            miConnection = getConexion();
            stat = miConnection.prepareStatement(DELETE);
            stat.setInt(1, idProveedor);
            if(stat.executeUpdate()==0){
                System.out.println("Puede que el proveedor no haya sido eliminado");
                JOptionPane.showMessageDialog(null, "No se encontro el proveedor");
            }
        } catch(SQLException ex){
            System.out.println(ex.getMessage());
            System.out.println("No se elimino proveedor");
        } finally{
                try {
                    miConnection.close();
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                    System.out.println("Error de SQL");
                } 
        } 
    }

    public void setControladorProveedor(ControladorProveedor miControladorProveedor) {
        this.miControladorProveedor = miControladorProveedor;
    }
}
