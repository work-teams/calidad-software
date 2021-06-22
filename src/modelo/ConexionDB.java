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
    
    private static final String URL = "jdbc:mysql://localhost/bikeshop";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "12345678";
    
    public static Connection getConexion() {
        Connection con = null;
        
        try {
            con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        
        return con;
    }
}
