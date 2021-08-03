/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author krypt97
 */
public class ConexionDB {
    
    private final String URL = "jdbc:mysql://localhost/bikeshop";
    private final String USERNAME = "root";
    private final String PASSWORD = "12345678";
    
    public Connection getConexion() throws NullPointerException {
        Connection miConnection = null;
        try {
            miConnection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return miConnection;
    }
}
