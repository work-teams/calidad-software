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

import controlador.ControladorVenta;
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
    ControladorVenta miControladorVenta;
    private Connection miConnection;
    private PreparedStatement miPreparedStatement;
    private ResultSet miResultSet;
    
    // SENTENCIAS SQL
    private final String INSERT = "INSERT INTO pedido (idVenta, idProducto, cantidad) VALUES (?,?,?)";
    private final String UPDATE = "UPDATE pedido SET cantidad=? WHERE idPedido=?";
    private final String SEARCH_CARRITO = "SELECT * FROM pedido WHERE idVenta=?";
    private final String SEARCH = "SELECT * FROM pedido WHERE idPedido=?";
    private final String DELETE = "DELETE FROM pedido WHERE idPedido=?";
    private final String LISTAR = "SELECT * FROM pedido";
    
    // ENLACE CONTROLADOR
    public void setControladorVentas(ControladorVenta miControladorVenta) {
        this.miControladorVenta = miControladorVenta;
    }
    
    // MÉTODOS C.R.U.D.
    public void registrarPedido(Pedido miPedido) {
        try {
            miConnection = getConexion();
            miPreparedStatement = miConnection.prepareStatement(INSERT);
            miPreparedStatement.setInt(1, miPedido.getIdVenta());
            miPreparedStatement.setInt(2, miPedido.getIdProducto());
            miPreparedStatement.setInt(3, miPedido.getCantidad());
            // Mensaje
            if (miPreparedStatement.executeUpdate() != 0) {System.out.println("Pedido registrado");}
            // Fin mensaje
        } catch (SQLException ex) {System.out.println(ex);
        } finally {
            try {
                miConnection.close();
            } catch (SQLException e) {System.out.println(e);
            }
        }
    }
    
    public Pedido buscarPedido(int idPedido) {
        Pedido miPedido = null;
        try {
            miConnection = getConexion();
            miPreparedStatement = miConnection.prepareStatement(SEARCH);
            miPreparedStatement.setInt(1, idPedido);
            miResultSet = miPreparedStatement.executeQuery();
            if (miResultSet.next()) {
                miPedido = empaquetarDatosBuscarPedidos(miResultSet);
            }
        } catch (SQLException ex) {System.out.println(ex);
        } finally {
            try {
                miConnection.close();
            } catch (SQLException e) {System.out.println(e);
            }
        }
        return miPedido;
    }
    
    public ArrayList<Pedido> listarCarritoPedidos(int idVenta) {
        ArrayList<Pedido> misPedidos = new ArrayList<>();
        try {
            miConnection = getConexion();
            miPreparedStatement = miConnection.prepareStatement(SEARCH_CARRITO);
            miPreparedStatement.setInt(1, idVenta);
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
    
    public void modificarPedido(int cantidad, int idPedido){
        try {
            miConnection = getConexion();
            miPreparedStatement = miConnection.prepareStatement(UPDATE);
            miPreparedStatement.setInt(1, cantidad);
            miPreparedStatement.setInt(2, idPedido);
            // Mensaje
            if (miPreparedStatement.executeUpdate() != 0) {System.out.println("Pedido modificado");}
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
            if (miPreparedStatement.executeUpdate() != 0) {System.out.println("Pedido eliminado");}
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
        miPedido.setIdPedido(miResultSet.getInt("idPedido"));
        miPedido.setIdVenta(miResultSet.getInt("idVenta"));
        miPedido.setIdProducto(miResultSet.getInt("idProducto"));
        miPedido.setCantidad(miResultSet.getInt("cantidad"));        
        return miPedido;
    }
    
    private Pedido empaquetarDatosListarPedidos(ResultSet miResultSet) throws SQLException {
        Pedido miPedido = new Pedido();
        miPedido.setIdPedido(miResultSet.getInt("idPedido"));
        miPedido.setIdVenta(miResultSet.getInt("idVenta"));
        miPedido.setIdProducto(miResultSet.getInt("idProducto"));
        miPedido.setCantidad(miResultSet.getInt("cantidad"));        
        return miPedido;
    }
}

