/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao;

/**
 *
 * @author Daniel
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import modelo.ConexionDB;
import modelo.vo.Proveedor;

public class ProveedorDAO extends ConexionDB {

    // ATRIBUTOS DE CLASE
    private Connection miConnection;
    private PreparedStatement miPreparedStatement;
    private ResultSet miResultSet;

    // SENTENCIAS SQL
    private final String INSERT = "INSERT INTO proveedores(idProveedor, nombre, direccion, telefono) VALUES (?,?,?,?)";
    private final String UPDATE = "UPDATE proveedores SET nombre=?, direccion=?, telefono=? WHERE idProveedor=?";
    private final String DELETE = "DELETE FROM proveedores WHERE idProveedor=?";
    private final String SEARCH = "SELECT nombre, direccion, telefono FROM proveedores WHERE idProveedor=?";
    private final String LISTAR = "SELECT * FROM proveedores";

    // MÉTODOS C.R.U.D.
    public void registrarProveedor(Proveedor miProveedor) {
        try {
            miConnection = getConexion();
            miPreparedStatement = miConnection.prepareStatement(INSERT);
            miPreparedStatement.setInt(1, miProveedor.getIdProveedor());
            miPreparedStatement.setString(2, miProveedor.getNombre());
            miPreparedStatement.setString(3, miProveedor.getDireccion());
            miPreparedStatement.setString(4, miProveedor.getTelefono());
            int mensaje = miPreparedStatement.executeUpdate();
            // Mensaje
            if (mensaje != 0) {
                System.out.println("Proveedor registrado");
            }
            // Fin mensaje
        } catch (SQLException | NullPointerException ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                miConnection.close();
            } catch (SQLException | NullPointerException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    public Proveedor buscarProveedor(int idProveedor) {
        Proveedor miProveedor = null;
        try {
            miConnection = getConexion();
            miPreparedStatement = miConnection.prepareStatement(SEARCH);
            miPreparedStatement.setInt(1, idProveedor);
            miResultSet = miPreparedStatement.executeQuery();
            if (miResultSet.next()) {
                miProveedor = empaquetarDatosBuscarProveedor(miResultSet);
            }
        } catch (SQLException | NullPointerException ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                miConnection.close();
            } catch (SQLException | NullPointerException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return miProveedor;
    }

    public ArrayList<Proveedor> listarProveedores() {
        ArrayList<Proveedor> misProveedores = new ArrayList<>();
        try {
            miConnection = getConexion();
            miPreparedStatement = miConnection.prepareStatement(LISTAR);
            miResultSet = miPreparedStatement.executeQuery();
            while (miResultSet.next()) {
                misProveedores.add(empaquetarDatosListarProveedor(miResultSet));
            }
        } catch (SQLException | NullPointerException ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                miConnection.close();
            } catch (SQLException | NullPointerException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return misProveedores;
    }

    public void modificarProveedor(Proveedor miProveedor) {
        try {
            miConnection = getConexion();
            miPreparedStatement = miConnection.prepareStatement(UPDATE);
            miPreparedStatement.setString(1, miProveedor.getNombre());
            miPreparedStatement.setString(2, miProveedor.getDireccion());
            miPreparedStatement.setString(3, miProveedor.getTelefono());
            miPreparedStatement.setInt(4, miProveedor.getIdProveedor());
            int mensaje = miPreparedStatement.executeUpdate();
            // Mensaje
            if (mensaje != 0) {
                System.out.println("Proveedor modificado");
            }
            // Fin mensaje
        } catch (SQLException | NullPointerException ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                miConnection.close();
            } catch (SQLException | NullPointerException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    public void eliminarProveedor(int idProveedor) {
        try {
            miConnection = getConexion();
            miPreparedStatement = miConnection.prepareStatement(DELETE);
            miPreparedStatement.setInt(1, idProveedor);
            int mensaje = miPreparedStatement.executeUpdate();
            // Mensaje
            if (mensaje != 0) {
                System.out.println("Proveedor eliminado");
            }
            // Fin mensaje
        } catch (SQLException | NullPointerException ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                miConnection.close();
            } catch (SQLException | NullPointerException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    // MÉTODOS AUXILIARES
    private Proveedor empaquetarDatosBuscarProveedor(ResultSet miResultSet) throws SQLException {
        Proveedor miProveedor = new Proveedor();
        miProveedor.setNombre(miResultSet.getString("nombre"));
        miProveedor.setDireccion(miResultSet.getString("direccion"));
        miProveedor.setTelefono(miResultSet.getString("telefono"));
        return miProveedor;
    }

    private Proveedor empaquetarDatosListarProveedor(ResultSet miResultSet) throws SQLException {
        Proveedor miProveedor = new Proveedor();
        miProveedor.setIdProveedor(miResultSet.getInt("idProveedor"));
        miProveedor.setNombre(miResultSet.getString("nombre"));
        miProveedor.setDireccion(miResultSet.getString("direccion"));
        miProveedor.setTelefono(miResultSet.getString("telefono"));
        return miProveedor;
    }
}
