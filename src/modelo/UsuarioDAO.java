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

public class UsuarioDAO extends ConexionDB{
    // Atributos de clase
    ControladorUsuario miconControladorUsuario;
    Connection miConnection;
    PreparedStatement miprePreparedStatement;
    ResultSet mireResultSet;
    
    // Sentencias SQL
    private final String INSERT = "INSERT INTO usuarios (dniUsuario, apellido, nombre, username, password, rol) VALUES (?,?,?,?,?,?)";
    private final String UPDATE = "UPDATE usuarios SET apellido=?, nombre=?, username=?, password=?, rol=? WHERE dniUsuario=?";
    private final String SEARCH = "SELECT apellido, nombre, username, password, rol FROM usuarios WHERE dniUsuario=?";
    private final String DELETE = "DELETE FROM usuarios WHERE dniUsuario=?";
    private final String LISTAR = "SELECT * FROM usuarios";
    
//    public UsuarioDAO (){
//    }
    
    // Metodos CRUD
    public void registrarUsuario(Usuario miUsuario) {
        try {
            miConnection = getConexion();
            miprePreparedStatement = miConnection.prepareStatement(INSERT);
            miprePreparedStatement.setString(1, miUsuario.getDniUsuario());
            miprePreparedStatement.setString(2, miUsuario.getApellido());
            miprePreparedStatement.setString(3, miUsuario.getNombre());
            miprePreparedStatement.setString(4, miUsuario.getUsername());
            miprePreparedStatement.setString(5, miUsuario.getPassword());
            miprePreparedStatement.setString(6, miUsuario.getRol());
            miprePreparedStatement.executeUpdate();
        } catch (SQLException ex) {
        } finally {
            try {
                miConnection.close();
            } catch (SQLException e) {
            }
        }
    }
    
    public Usuario buscarUsuario(String dniUsuario) throws NullPointerException {
        Usuario miUsuario = null;
        try {
            miConnection = getConexion();
            miprePreparedStatement = miConnection.prepareStatement(SEARCH);
            miprePreparedStatement.setString(1, dniUsuario);
            mireResultSet = miprePreparedStatement.executeQuery();
            miUsuario = convertir(mireResultSet);
        } catch (SQLException ex) {
        } finally {
            try {
                miConnection.close();
            } catch (SQLException e) {
            }
        }
        return miUsuario;
    }
    
    public void modificarUsuario(Usuario miUsuario){
        try {
            miConnection = getConexion();
            miprePreparedStatement = miConnection.prepareStatement(UPDATE);
            miprePreparedStatement.setString(1, miUsuario.getApellido());
            miprePreparedStatement.setString(2, miUsuario.getNombre());
            miprePreparedStatement.setString(3, miUsuario.getUsername());
            miprePreparedStatement.setString(4, miUsuario.getPassword());
            miprePreparedStatement.setString(5, miUsuario.getRol());
            miprePreparedStatement.setString(6, miUsuario.getDniUsuario());
            miprePreparedStatement.executeUpdate();
        } catch (SQLException ex) {
        } finally {
            try {
                miConnection.close();
            } catch (SQLException e) {
            }
        }
    }
    
    public void eliminarUsuario(String dniUsuario){
        try {
            miConnection = getConexion();
            miprePreparedStatement = miConnection.prepareStatement(DELETE);
            miprePreparedStatement.setString(1, dniUsuario);
            miprePreparedStatement.executeUpdate();
        } catch (SQLException ex) {
        } finally {
            try {
                miConnection.close();
            } catch (SQLException e) {
            }
        }
    }
    
    // Métodos auxiliares
    private Usuario convertir(ResultSet miResultSet) throws SQLException {
        if (miResultSet.next()) {
            Usuario miUsuario = new Usuario();
            miUsuario.setApellido(miResultSet.getString(1));
            miUsuario.setNombre(miResultSet.getString(1));
            miUsuario.setUsername(miResultSet.getString(1));
            miUsuario.setPassword(miResultSet.getString(1));
            miUsuario.setRol(miResultSet.getString(1));
            return miUsuario;
        }
        else {
            return null;
        }
    }
    
    public ResultSet listarUsuarios() throws NullPointerException {
        ResultSet miResulSet = null;
        try {
            miConnection = getConexion();
            miprePreparedStatement = miConnection.prepareStatement(LISTAR);
            miResulSet = miprePreparedStatement.executeQuery();
        } catch (SQLException e) {
        } finally {
            try {
                miConnection.close();
            } catch (SQLException e) {
            }
        }
        return miResulSet;
    }
    
    // Vinculo controlador
    public void setControlador(ControladorUsuario miControladorUsuario) {
        this.miconControladorUsuario = miControladorUsuario;
    }
}
