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
import modelo.ConexionDB;
import modelo.vo.Cliente;

/**
 *
 * @author krypt97
 */
public class ClienteDAO extends ConexionDB {

    // ATRIBUTOS DE CLASE
    private Connection miConnection;
    private PreparedStatement miPreparedStatement;
    private ResultSet miResultSet;

    // SENTENCIAS SQL
    private final String INSERT = "INSERT INTO cliente (dniCliente, apellido, nombre, ruc) VALUES (?,?,?,?)";
    private final String UPDATE = "UPDATE cliente SET apellido=?, nombre=?, ruc=? WHERE dniCliente=?";
    private final String SEARCH = "SELECT apellido, nombre, ruc FROM cliente WHERE dniCliente=?";
    private final String DELETE = "DELETE FROM cliente WHERE dniCliente=?";
    private final String LISTAR = "SELECT * FROM cliente";

    // MÉTODOS C.R.U.D.
    public void registrarCliente(Cliente miCliente) {
        try {
            miConnection = getConexion();
            miPreparedStatement = miConnection.prepareStatement(INSERT);
            miPreparedStatement.setString(1, miCliente.getDniCliente());
            miPreparedStatement.setString(2, miCliente.getApellido());
            miPreparedStatement.setString(3, miCliente.getNombre());
            miPreparedStatement.setString(4, miCliente.getRuc());
            int mensaje = miPreparedStatement.executeUpdate();
            // Mensaje
            if (mensaje != 0) {
            }
            // Fin mensaje
        } catch (SQLException | NullPointerException ex) {
            System.out.println(ex);
        } finally {
            try {
                miConnection.close();
            } catch (SQLException | NullPointerException e) {
                System.out.println(e);
            }
        }
    }

    public Cliente buscarCliente(String dniCliente) {
        Cliente miCliente = null;
        try {
            miConnection = getConexion();
            miPreparedStatement = miConnection.prepareStatement(SEARCH);
            miPreparedStatement.setString(1, dniCliente);
            miResultSet = miPreparedStatement.executeQuery();
            if (miResultSet.next()) {
                miCliente = empaquetarDatosBuscarCliente(miResultSet);
            }
        } catch (SQLException | NullPointerException ex) {
            System.out.println(ex);
        } finally {
            try {
                miConnection.close();
            } catch (SQLException | NullPointerException e) {
                System.out.println(e);
            }
        }
        return miCliente;
    }

    public void modificarCliente(Cliente miCliente) {
        try {
            miConnection = getConexion();
            miPreparedStatement = miConnection.prepareStatement(UPDATE);
            miPreparedStatement.setString(1, miCliente.getApellido());
            miPreparedStatement.setString(2, miCliente.getNombre());
            miPreparedStatement.setString(3, miCliente.getRuc());
            miPreparedStatement.setString(4, miCliente.getDniCliente());
            int mensaje = miPreparedStatement.executeUpdate();
            // Mensaje
            if (mensaje != 0) {
                System.out.println("Cliente modificado");
            }
            // Fin mensaje
        } catch (SQLException | NullPointerException ex) {
            System.out.println(ex);
        } finally {
            try {
                miConnection.close();
            } catch (SQLException | NullPointerException e) {
                System.out.println(e);
            }
        }
    }

    public void eliminarCliente(String dniCliente) {
        try {
            miConnection = getConexion();
            miPreparedStatement = miConnection.prepareStatement(DELETE);
            miPreparedStatement.setString(1, dniCliente);
            int mensaje = miPreparedStatement.executeUpdate();
            // Mensaje
            if (mensaje != 0) {
                System.out.println("Cliente eliminado");
            }
            // Fin mensaje
        } catch (SQLException | NullPointerException ex) {
            System.out.println(ex);
        } finally {
            try {
                miConnection.close();
            } catch (SQLException | NullPointerException e) {
                System.out.println(e);
            }
        }
    }

    public ArrayList<Cliente> listarClientes() {
        ArrayList<Cliente> misClientes = new ArrayList<>();
        try {
            miConnection = getConexion();
            miPreparedStatement = miConnection.prepareStatement(LISTAR);
            miResultSet = miPreparedStatement.executeQuery();
            while (miResultSet.next()) {
                misClientes.add(empaquetarDatosListarClientes(miResultSet));
            }
        } catch (SQLException | NullPointerException e) {
            System.out.println(e);
        } finally {
            try {
                miConnection.close();
            } catch (SQLException | NullPointerException e) {
                System.out.println(e);
            }
        }
        return misClientes;
    }

    // MÉTODOS AUXILIARES
    private Cliente empaquetarDatosBuscarCliente(ResultSet miResultSet) throws SQLException {
        Cliente miCliente = new Cliente();
        miCliente.setApellido(miResultSet.getString("apellido"));
        miCliente.setNombre(miResultSet.getString("nombre"));
        miCliente.setRuc(miResultSet.getString("ruc"));
        return miCliente;
    }

    private Cliente empaquetarDatosListarClientes(ResultSet miResultSet) throws SQLException {
        Cliente miCliente = new Cliente();
        miCliente.setDniCliente(miResultSet.getString("dniCliente"));
        miCliente.setApellido(miResultSet.getString("apellido"));
        miCliente.setNombre(miResultSet.getString("nombre"));
        miCliente.setRuc(miResultSet.getString("ruc"));
        return miCliente;
    }
}
