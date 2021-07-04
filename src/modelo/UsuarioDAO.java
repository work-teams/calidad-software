/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author willi
 */

import controlador.ControladorUsuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UsuarioDAO extends ConexionDB{
    // Atributos de clase
    ControladorUsuario miControladorUsuario;
    Connection miConnection;
    PreparedStatement miPreparedStatement;
    ResultSet miResultSet;
    
    // Sentencias SQL
    private final String INSERT = "INSERT INTO usuarios (dniUsuario, apellido, nombre, username, password, rol) VALUES (?,?,?,?,?,?)";
    private final String UPDATE = "UPDATE usuarios SET apellido=?, nombre=?, username=?, password=?, rol=? WHERE dniUsuario=?";
    private final String SEARCH = "SELECT apellido, nombre, username, password, rol FROM usuarios WHERE dniUsuario=?";
    private final String DELETE = "DELETE FROM usuarios WHERE dniUsuario=?";
    private final String LISTAR = "SELECT * FROM usuarios";
    
    // Enlance controlador
    public void setControlador(ControladorUsuario miControladorUsuario) {
        this.miControladorUsuario = miControladorUsuario;
    }
    
    // Metodos CRUD
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
            miPreparedStatement.executeUpdate();
        } catch (SQLException ex) {System.out.println(ex);
        } finally {
            try {
                miConnection.close();
            } catch (SQLException e) {System.out.println(e);
            }
        }
    }
    
    public Usuario buscarUsuario(String dniUsuario) throws NullPointerException {
        Usuario miUsuario = null;
        try {
            miConnection = getConexion();
            miPreparedStatement = miConnection.prepareStatement(SEARCH);
            miPreparedStatement.setString(1, dniUsuario);
            miResultSet = miPreparedStatement.executeQuery();
            miUsuario = empaquetarDatos(miResultSet);
        } catch (SQLException ex) {System.out.println(ex);
        } finally {
            try {
                miConnection.close();
            } catch (SQLException e) {System.out.println(e);
            }
        }
        return miUsuario;
    }
    
    public void modificarUsuario(Usuario miUsuario){
        try {
            miConnection = getConexion();
            miPreparedStatement = miConnection.prepareStatement(UPDATE);
            miPreparedStatement.setString(1, miUsuario.getApellido());
            miPreparedStatement.setString(2, miUsuario.getNombre());
            miPreparedStatement.setString(3, miUsuario.getUsername());
            miPreparedStatement.setString(4, miUsuario.getPassword());
            miPreparedStatement.setString(5, miUsuario.getRol());
            miPreparedStatement.setString(6, miUsuario.getDniUsuario());
            miPreparedStatement.executeUpdate();
        } catch (SQLException ex) {System.out.println(ex);
        } finally {
            try {
                miConnection.close();
            } catch (SQLException e) {System.out.println(e);
            }
        }
    }
    
    public void eliminarUsuario(String dniUsuario){
        try {
            miConnection = getConexion();
            miPreparedStatement = miConnection.prepareStatement(DELETE);
            miPreparedStatement.setString(1, dniUsuario);
            miPreparedStatement.executeUpdate();
        } catch (SQLException ex) {System.out.println(ex);
        } finally {
            try {
                miConnection.close();
            } catch (SQLException e) {System.out.println(e);
            }
        }
    }
    
    // Métodos auxiliares
    private Usuario empaquetarDatos(ResultSet miResultSet) throws SQLException {
        if (miResultSet.next()) {
            Usuario miUsuario = new Usuario();
            miUsuario.setApellido(miResultSet.getString(1));
            miUsuario.setNombre(miResultSet.getString(2));
            miUsuario.setUsername(miResultSet.getString(3));
            miUsuario.setPassword(miResultSet.getString(4));
            miUsuario.setRol(miResultSet.getString(5));
            return miUsuario;
        }
        else {
            return null;
        }
    }
    
    public ArrayList<Usuario> listarUsuarios() throws NullPointerException {
        ArrayList<Usuario> misUsuarios = new ArrayList<>();
        Usuario miUsuario;
        try {
            miConnection = getConexion();
            miPreparedStatement = miConnection.prepareStatement(LISTAR);
            miResultSet = miPreparedStatement.executeQuery();
            while (miResultSet.next()) {
                miUsuario = empaquetarDatos(miResultSet);
                misUsuarios.add(miUsuario);
            }
        } catch (SQLException e) {System.out.println(e);
        } finally {
            try {
                miConnection.close();
            } catch (SQLException e) {System.out.println(e);
            }
        }
        return misUsuarios;
    }
}
