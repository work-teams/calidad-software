/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao;

import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Connection;
import java.util.ArrayList;
import modelo.ConexionDB;
import modelo.vo.Producto;

/**
 *
 * @author AlexTprog
 */
public class ProductoDAO extends ConexionDB {

    // ATRIBUTOS DE CLASE
    private Connection miConnection;
    private PreparedStatement miPreparedStatement;
    private ResultSet miResultSet;

    // SENTENCIAS SQL
    private final String INSERT = "INSERT INTO bikeshop.producto (idProducto, nombre, cantidad, categoria, precio, idProveedor, idCategoria) VALUES (?,?,?,?,?,?,?)";
    private final String UPDATE = "UPDATE bikeshop.producto SET nombre=?, cantidad=?, categoria=?, precio=?, idProveedor=?, idCategoria=? WHERE idProducto=?";
    private final String SEARCH = "SELECT nombre, cantidad, categoria, precio, idProveedor, idCategoria FROM bikeshop.producto WHERE idProducto=?";
    private final String DELETE = "DELETE FROM bikeshop.producto WHERE idProducto=?";
    private final String LISTAR = "SELECT * FROM bikeshop.producto";

    // MÉTODOS C.R.U.D.
    public void registrarProducto(Producto miProducto) {
        try {
            miConnection = getConexion();
            miPreparedStatement = miConnection.prepareStatement(INSERT);
            miPreparedStatement.setInt(1, miProducto.getIdProducto());
            miPreparedStatement.setString(2, miProducto.getNombre());
            miPreparedStatement.setInt(3, miProducto.getCantidad());
            miPreparedStatement.setString(4, miProducto.getCategoria());
            miPreparedStatement.setFloat(5, miProducto.getPrecio());
            miPreparedStatement.setInt(6, miProducto.getIdProveedor());
            miPreparedStatement.setInt(7, miProducto.getIdCategoria());
            int mensaje = miPreparedStatement.executeUpdate();
            // Mensaje
            if (mensaje != 0) {
                System.out.println("Producto registrado");
            }
            // Fin mensaje
        } catch (SQLException | NullPointerException e) {
            System.err.println(e);
        } finally {
            try {
                miConnection.close();
            } catch (SQLException | NullPointerException e) {
                System.out.println(e);
            }
        }
    }

    public Producto buscarProducto(int idProducto) {
        Producto miProducto = null;
        try {
            miConnection = getConexion();
            miPreparedStatement = miConnection.prepareStatement(SEARCH);
            miPreparedStatement.setInt(1, idProducto);
            miResultSet = miPreparedStatement.executeQuery();
            if (miResultSet.next()) {
                miProducto = empaquetarDatosBuscarProducto(miResultSet);
            }
        } catch (SQLException | NullPointerException e) {
            System.err.println(e);
        } finally {
            try {
                miConnection.close();
            } catch (SQLException | NullPointerException e) {
                System.out.println(e);
            }
        }
        return miProducto;
    }

    public ArrayList<Producto> listarProductos() {
        ArrayList<Producto> misProductos = new ArrayList<>();
        try {
            miConnection = getConexion();
            miPreparedStatement = miConnection.prepareStatement(LISTAR);
            miResultSet = miPreparedStatement.executeQuery();
            while (miResultSet.next()) {
                misProductos.add(empaquetarDatosListarProducto(miResultSet));
            }
        } catch (SQLException | NullPointerException e) {
            System.err.println(e);
        } finally {
            try {
                miConnection.close();
            } catch (SQLException | NullPointerException e) {
                System.out.println(e);
            }
        }
        return misProductos;
    }

    public void modificarProducto(Producto miProducto) {
        try {
            miConnection = getConexion();
            miPreparedStatement = miConnection.prepareStatement(UPDATE);
            miPreparedStatement.setString(1, miProducto.getNombre());
            miPreparedStatement.setInt(2, miProducto.getCantidad());
            miPreparedStatement.setString(3, miProducto.getCategoria());
            miPreparedStatement.setFloat(4, miProducto.getPrecio());
            miPreparedStatement.setInt(5, miProducto.getIdProveedor());
            miPreparedStatement.setInt(6, miProducto.getIdCategoria());
            miPreparedStatement.setInt(7, miProducto.getIdProducto());
            int mensaje = miPreparedStatement.executeUpdate();
            // Mensaje
            if (mensaje != 0) {
                System.out.println("Producto modificado");
            }
            // Fin mensaje
        } catch (SQLException | NullPointerException e) {
            System.err.println(e);
        } finally {
            try {
                miConnection.close();
            } catch (SQLException | NullPointerException e) {
                System.out.println(e);
            }
        }
    }

    public void eliminarProducto(int idProducto) {
        try {
            miConnection = getConexion();
            miPreparedStatement = miConnection.prepareStatement(DELETE);
            miPreparedStatement.setInt(1, idProducto);
            int mensaje = miPreparedStatement.executeUpdate();
            // Mensaje
            if (mensaje != 0) {
                System.out.println("Producto eliminado");
            }
            // Fin mensaje
        } catch (SQLException | NullPointerException e) {
            System.err.println(e);
        } finally {
            try {
                miConnection.close();
            } catch (SQLException | NullPointerException e) {
                System.out.println(e);
            }
        }
    }

    // MÉTODOS AUXILIARES
    private Producto empaquetarDatosBuscarProducto(ResultSet miResultSet) throws SQLException {
        Producto miProducto = new Producto();
        miProducto.setNombre(miResultSet.getString("nombre"));
        miProducto.setCantidad(miResultSet.getInt("cantidad"));
        miProducto.setCategoria(miResultSet.getString("categoria"));
        miProducto.setPrecio(miResultSet.getFloat("precio"));
        miProducto.setIdProveedor(miResultSet.getInt("idProveedor"));
        miProducto.setIdCategoria(miResultSet.getInt("idCategoria"));
        return miProducto;
    }

    private Producto empaquetarDatosListarProducto(ResultSet miResultSet) throws SQLException {
        Producto miProducto = new Producto();
        miProducto.setIdProducto(miResultSet.getInt("idProducto"));
        miProducto.setNombre(miResultSet.getString("nombre"));
        miProducto.setCantidad(miResultSet.getInt("cantidad"));
        miProducto.setCategoria(miResultSet.getString("categoria"));
        miProducto.setPrecio(miResultSet.getFloat("precio"));
        miProducto.setIdProveedor(miResultSet.getInt("idProveedor"));
        miProducto.setIdCategoria(miResultSet.getInt("idCategoria"));
        return miProducto;
    }
}
