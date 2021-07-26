/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao;

/**
 *
 * @author willi
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.ConexionDB;
import modelo.vo.Pedido;

public class PedidoDAO extends ConexionDB{
    // ATRIBUTOS DE CLASE
    
    private Connection miConnection;
    private PreparedStatement miPreparedStatement;
    private ResultSet miResultSet;
    
    // SENTENCIAS SQL
    private final String INSERT = "INSERT INTO pedido (idPedido, idVenta, idProducto,  cantidad) VALUES (?,?,?,?)";
    private final String UPDATE = "UPDATE pedido SET idVenta=? idProducto=?, cantidad=?, WHERE idPedido=?";
    private final String SEARCH = "SELECT * FROM pedido WHERE idVenta=?";
    private final String DELETE = "DELETE FROM pedido WHERE idPedido=?";
    private final String LISTAR = "SELECT * FROM pedido";
    
    // MÉTODOS C.R.U.D.
    public void registrarPedido(Pedido miPedido) {
        try {
            miConnection = getConexion();
            miPreparedStatement = miConnection.prepareStatement(INSERT);
            miPreparedStatement.setInt(1, miPedido.getIdPedido());
            miPreparedStatement.setString(2, miPedido.getIdVenta());
            miPreparedStatement.setString(3, miPedido.getIdProducto());
            miPreparedStatement.setInt(4, miPedido.getCantidad());
            // Mensaje
            if (miPreparedStatement.executeUpdate() != 0) {JOptionPane.showMessageDialog(null, "Pedido registrado con exito.");}
            // Fin mensaje
        } catch (SQLException ex) {System.out.println(ex);JOptionPane.showMessageDialog(null, "Pedido ya registrado.");
        } finally {
            try {
                miConnection.close();
            } catch (SQLException e) {System.out.println(e);
            }
        }
    }
    
    /*
    public Pedido buscarPedido(String idVenta) {
        Pedido miPedido = null;
        try {
            miConnection = getConexion();
            miPreparedStatement = miConnection.prepareStatement(SEARCH);
            miPreparedStatement.setString(1, idVenta);
            miResultSet = miPreparedStatement.executeQuery();
            if (miResultSet.next()) {
                miPedido = empaquetarDatosBuscarPedidos(miResultSet);
            }
            // Mensaje
            else {JOptionPane.showMessageDialog(null, "El id ingresado no coincide con ningún pedido registrado.");}
            // Fin mensaje
        } catch (SQLException ex) {System.out.println(ex);
        } finally {
            try {
                miConnection.close();
            } catch (SQLException e) {System.out.println(e);
            }
        }
        return miPedido;
    }*/
    
    
        public ArrayList<Pedido> buscarPedido(String idVenta) {
        ArrayList<Pedido> misPedidos = new ArrayList<>();
        try {
            miConnection = getConexion();
            miPreparedStatement = miConnection.prepareStatement(SEARCH);
            miPreparedStatement.setString(1, idVenta);
            miResultSet = miPreparedStatement.executeQuery();
            while (miResultSet.next()) {
                misPedidos.add(empaquetarDatosListarPedidos(miResultSet));
            }
        } catch (SQLException e) {System.out.println(e);
        } finally {
            try {
                miConnection.close();
            } catch (SQLException e) {System.out.println(e);
            }
        }
        return misPedidos;
    }
    
    
    
    
    public void modificarPedido(Pedido miPedido){
        try {
            miConnection = getConexion();
            miPreparedStatement = miConnection.prepareStatement(UPDATE);
            miPreparedStatement.setString(1, miPedido.getIdVenta());
            miPreparedStatement.setString(2, miPedido.getIdProducto());
            miPreparedStatement.setInt(3, miPedido.getCantidad());
            miPreparedStatement.setInt(3, miPedido.getIdPedido());
            
            // Mensaje
            if (miPreparedStatement.executeUpdate() != 0) {JOptionPane.showMessageDialog(null, "Pedido modificado con exito.");}
            else {JOptionPane.showMessageDialog(null, "El id ingresado no coincide con ningún pedido registrado.");}
            // Fin mensaje
        } catch (SQLException ex) {System.out.println(ex);
        } finally {
            try {
                miConnection.close();
            } catch (SQLException e) {System.out.println(e);
            }
        }
    }
    
    public void eliminarPedido(int idPedido){
        try {
            miConnection = getConexion();
            miPreparedStatement = miConnection.prepareStatement(DELETE);
            miPreparedStatement.setInt(1, idPedido);
            // Mensaje
            if (miPreparedStatement.executeUpdate() != 0) {JOptionPane.showMessageDialog(null, "Pedido eliminado con exito.");}
            else {JOptionPane.showMessageDialog(null, "El id ingresado no coincide con ningún pedido registrado.");}
            // Fin mensaje
        } catch (SQLException ex) {System.out.println(ex);
        } finally {
            try {
                miConnection.close();
            } catch (SQLException e) {System.out.println(e);
            }
        }
    }
    
    public ArrayList<Pedido> listarPedido() {
        ArrayList<Pedido> misPedidos = new ArrayList<>();
        try {
            miConnection = getConexion();
            miPreparedStatement = miConnection.prepareStatement(LISTAR);
            miResultSet = miPreparedStatement.executeQuery();
            while (miResultSet.next()) {
                misPedidos.add(empaquetarDatosListarPedidos(miResultSet));
            }
        } catch (SQLException e) {System.out.println(e);
        } finally {
            try {
                miConnection.close();
            } catch (SQLException e) {System.out.println(e);
            }
        }
        return misPedidos;
    }
    
    // MÉTODOS AUXILIARES
    private Pedido empaquetarDatosBuscarPedidos(ResultSet miResultSet) throws SQLException {
        Pedido miPedido = new Pedido();
        miPedido.setIdProducto(miResultSet.getString("idVenta"));
        miPedido.setIdProducto(miResultSet.getString("idProducto"));
        miPedido.setCantidad(miResultSet.getInt("cantidad"));        
        return miPedido;
    }
    
    private Pedido empaquetarDatosListarPedidos(ResultSet miResultSet) throws SQLException {
        Pedido miPedido = new Pedido();
        miPedido.setIdPedido(miResultSet.getInt("idPedido"));
        miPedido.setIdVenta(miResultSet.getString("idVenta"));
        miPedido.setIdProducto(miResultSet.getString("idProducto"));
        miPedido.setCantidad(miResultSet.getInt("cantidad"));        
        return miPedido;
    }
    
}

