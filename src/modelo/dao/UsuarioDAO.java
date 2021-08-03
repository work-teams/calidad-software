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
import modelo.ConexionDB;
import modelo.vo.Usuario;

public class UsuarioDAO extends ConexionDB {

    // ATRIBUTOS DE CLASE
    private Connection miConnection;
    private PreparedStatement miPreparedStatement;
    private ResultSet miResultSet;

    // SENTENCIAS SQL
    private final String INSERT = "INSERT INTO bikeshop.usuarios (dniUsuario, apellido, nombre, username, password, rol) VALUES (?,?,?,?,?,?)";
    private final String UPDATE = "UPDATE bikeshop.usuarios SET apellido=?, nombre=?, username=?, password=?, rol=? WHERE dniUsuario=?";
    private final String SEARCH = "SELECT apellido, nombre, username, password, rol FROM bikeshop.usuarios WHERE dniUsuario=?";
    private final String DELETE = "DELETE FROM bikeshop.usuarios WHERE dniUsuario=?";
    private final String LISTAR = "SELECT * FROM bikeshop.usuarios";

    // MÉTODOS C.R.U.D.
    public void registrarUsuario(Usuario miUsuario) {
        try {
            miConnection = getConexion();
            miPreparedStatement = miConnection.prepareStatement(INSERT);
            miPreparedStatement.setString(1, miUsuario.getDniUsuario());
            miPreparedStatement.setString(2, miUsuario.getApellido());
            miPreparedStatement.setString(3, miUsuario.getNombre());
            miPreparedStatement.setString(4, miUsuario.getUsername());
            miPreparedStatement.setString(5, miUsuario.getPassword());
            miPreparedStatement.setString(6, miUsuario.getRol());
            int mensaje = miPreparedStatement.executeUpdate();
            // Mensaje
            if (mensaje != 0) {
                System.out.println("Usuario registrado");
            }
            // Fin mensaje
        } catch (SQLException | NullPointerException e) {
            System.out.println(e);
        } finally {
            try {
                miConnection.close();
            } catch (SQLException | NullPointerException e) {
                System.out.println(e);
            }
        }
    }

    public Usuario buscarUsuario(String dniUsuario) {
        Usuario miUsuario = null;
        try {
            miConnection = getConexion();
            miPreparedStatement = miConnection.prepareStatement(SEARCH);
            miPreparedStatement.setString(1, dniUsuario);
            miResultSet = miPreparedStatement.executeQuery();
            if (miResultSet.next()) {
                miUsuario = empaquetarDatosUsuario(miResultSet);
            }
            // Fin mensaje
        } catch (SQLException | NullPointerException e) {
            System.out.println(e);
        } finally {
            try {
                miConnection.close();
            } catch (SQLException | NullPointerException e) {
                System.out.println(e);
            }
        }
        return miUsuario;
    }

    public void modificarUsuario(Usuario miUsuario) {
        try {
            miConnection = getConexion();
            miPreparedStatement = miConnection.prepareStatement(UPDATE);
            miPreparedStatement.setString(1, miUsuario.getApellido());
            miPreparedStatement.setString(2, miUsuario.getNombre());
            miPreparedStatement.setString(3, miUsuario.getUsername());
            miPreparedStatement.setString(4, miUsuario.getPassword());
            miPreparedStatement.setString(5, miUsuario.getRol());
            miPreparedStatement.setString(6, miUsuario.getDniUsuario());
            int mensaje = miPreparedStatement.executeUpdate();
            // Mensaje
            if (mensaje != 0) {
                System.out.println("Usuario modificado");
            }
            // Fin mensaje
        } catch (SQLException | NullPointerException e) {
            System.out.println(e);
        } finally {
            try {
                miConnection.close();
            } catch (SQLException | NullPointerException e) {
                System.out.println(e);
            }
        }
    }

    public void eliminarUsuario(String dniUsuario) {
        try {
            miConnection = getConexion();
            miPreparedStatement = miConnection.prepareStatement(DELETE);
            miPreparedStatement.setString(1, dniUsuario);
            int mensaje = miPreparedStatement.executeUpdate();
            // Mensaje
            if (mensaje != 0) {
                System.out.println("Usuario eliminado");
            }
            // Fin mensaje
        } catch (SQLException | NullPointerException e) {
            System.out.println(e);
        } finally {
            try {
                miConnection.close();
            } catch (SQLException | NullPointerException e) {
                System.out.println(e);
            }
        }
    }

    public ArrayList<Usuario> listarUsuarios() {
        ArrayList<Usuario> misUsuarios = new ArrayList<>();
        try {
            miConnection = getConexion();
            miPreparedStatement = miConnection.prepareStatement(LISTAR);
            miResultSet = miPreparedStatement.executeQuery();
            while (miResultSet.next()) {
                misUsuarios.add(empaquetarDatosListarUsuarios(miResultSet));
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
        return misUsuarios;
    }

    // MÉTODOS AUXILIARES
    private Usuario empaquetarDatosUsuario(ResultSet miResultSet) throws SQLException {
        Usuario miUsuario = new Usuario();
        miUsuario.setApellido(miResultSet.getString("apellido"));
        miUsuario.setNombre(miResultSet.getString("nombre"));
        miUsuario.setUsername(miResultSet.getString("username"));
        miUsuario.setPassword(miResultSet.getString("password"));
        miUsuario.setRol(miResultSet.getString("rol"));
        return miUsuario;
    }

    private Usuario empaquetarDatosListarUsuarios(ResultSet miResultSet) throws SQLException {
        Usuario miUsuario = new Usuario();
        miUsuario.setDniUsuario(miResultSet.getString("dniUsuario"));
        miUsuario.setApellido(miResultSet.getString("apellido"));
        miUsuario.setNombre(miResultSet.getString("nombre"));
        miUsuario.setUsername(miResultSet.getString("username"));
        miUsuario.setPassword(miResultSet.getString("password"));
        miUsuario.setRol(miResultSet.getString("rol"));
        return miUsuario;
    }
}
