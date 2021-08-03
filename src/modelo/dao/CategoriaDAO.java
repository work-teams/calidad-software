/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.vo.Categoria;
import modelo.ConexionDB;

/**
 *
 * @author AlexTprog
 */
public class CategoriaDAO extends ConexionDB {

    // ATRIBUTOS DE CLASE
    private Connection miConnection;
    private PreparedStatement miPreparedStatement;
    private ResultSet miResultSet;

    // SENTENCIAS SQL
    private final String INSERT = "INSERT INTO bikeshop.categoria (idCategoria, nombreCategoria) VALUES (?,?)";
    private final String UPDATE = "UPDATE bikeshop.categoria SET nombreCategoria=? WHERE idCategoria=?";
    private final String SEARCH = "SELECT nombreCategoria FROM bikeshop.categoria WHERE idCategoria=?";
    private final String DELETE = "DELETE FROM bikeshop.categoria WHERE idCategoria=?";
    private final String LISTAR = "SELECT * FROM bikeshop.categoria";

    // MÉTODOS C.R.U.D.
    public void registrarCategoria(Categoria miCategoria) {
        try {
            miConnection = getConexion();
            miPreparedStatement = miConnection.prepareStatement(INSERT);
            miPreparedStatement.setInt(1, miCategoria.getIdCategoria());
            miPreparedStatement.setString(2, miCategoria.getNombreCategoria());
            int mensaje = miPreparedStatement.executeUpdate();
            // Mensaje
            if (mensaje != 0) {
                System.out.println("Categoria registrada");
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

    public Categoria buscarCategoria(int idCategoria) {
        Categoria miCategoria = null;
        try {
            Connection con = getConexion();
            miPreparedStatement = con.prepareStatement(SEARCH);
            miPreparedStatement.setInt(1, idCategoria);
            miResultSet = miPreparedStatement.executeQuery();
            if (miResultSet.next()) {
                miCategoria = empaquetarDatosBuscarCategoria(miResultSet);
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
        return miCategoria;
    }

    //
    public ArrayList<Categoria> listarCategorias() {
        ArrayList<Categoria> misCategorias = new ArrayList<>();
        try {
            miConnection = getConexion();
            miPreparedStatement = miConnection.prepareStatement(LISTAR);
            miResultSet = miPreparedStatement.executeQuery();
            while (miResultSet.next()) {
                misCategorias.add(empaquetarDatosListarCategoria(miResultSet));
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
        return misCategorias;
    }

    public void modificarCategoria(Categoria miCategoria) {
        try {
            miConnection = getConexion();
            miPreparedStatement = miConnection.prepareStatement(UPDATE);
            miPreparedStatement.setString(1, miCategoria.getNombreCategoria());
            miPreparedStatement.setInt(2, miCategoria.getIdCategoria());
            int mensaje = miPreparedStatement.executeUpdate();
            // Mensaje
            if (mensaje != 0) {
                System.out.println("Categoria modificada");
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

    public void eliminarCategoria(int idCategoria) {
        try {
            miConnection = getConexion();
            miPreparedStatement = miConnection.prepareStatement(DELETE);
            miPreparedStatement.setInt(1, idCategoria);
            int mensaje = miPreparedStatement.executeUpdate();
            // Mensaje
            if (mensaje != 0) {
                System.out.println("Categoria eliminada");
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
    private Categoria empaquetarDatosBuscarCategoria(ResultSet miResultSet) throws SQLException {
        Categoria miCategoria = new Categoria();
        miCategoria.setNombreCategoria(miResultSet.getString("nombreCategoria"));
        return miCategoria;
    }

    private Categoria empaquetarDatosListarCategoria(ResultSet miResultSet) throws SQLException {
        Categoria miCategoria = new Categoria();
        miCategoria.setIdCategoria(miResultSet.getInt("idCategoria"));
        miCategoria.setNombreCategoria(miResultSet.getString("nombreCategoria"));
        return miCategoria;
    }
}
