/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import modelo.ConexionDB;
import modelo.vo.Venta;

/**
 *
 * @author nick_
 */
public class VentaDAO extends ConexionDB {

    // ATRIBUTOS DE CLASE
    private Connection miConnection;
    private PreparedStatement miPreparedStatement;
    private ResultSet miResultSet;

    // SENTENCIAS SQL
    private final String INSERT = "INSERT INTO venta (dniUsuario, dniCliente, monto, boleta) VALUES (?,?,?,?)";
    private final String SEARCH = "SELECT dniUsuario, dniCliente, monto, boleta FROM venta WHERE idVenta=?";
    private final String LISTAR = "SELECT * FROM venta";
    private final String LAST_VENTA = "SELECT idVenta FROM venta ORDER BY idVenta DESC LIMIT 1";

    // MÉTODOS C.R.U.D.
    public void registrarVenta(Venta miVenta) {
        try {
            miConnection = getConexion();
            miPreparedStatement = miConnection.prepareStatement(INSERT);
            miPreparedStatement.setString(1, miVenta.getDniUsuario());
            miPreparedStatement.setString(2, miVenta.getDniCliente());
            miPreparedStatement.setFloat(3, miVenta.getMonto());
            miPreparedStatement.setBoolean(4, miVenta.isBoleta());
            int resultado = miPreparedStatement.executeUpdate();
            // Mensaje
            if (resultado != 0) {
                System.out.println("Venta registrada");
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

    public Venta buscarVenta(int idVenta) {
        Venta miVenta = null;
        try {
            miConnection = getConexion();
            miPreparedStatement = miConnection.prepareStatement(SEARCH);
            miPreparedStatement.setInt(1, idVenta);
            miResultSet = miPreparedStatement.executeQuery();
            if (miResultSet.next()) {
                miVenta = empaquetarDatosBuscarVentas(miResultSet);
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
        return miVenta;
    }

    public ArrayList<Venta> listarVentas() {
        ArrayList<Venta> misVentas = new ArrayList<>();
        try {
            miConnection = getConexion();
            miPreparedStatement = miConnection.prepareStatement(LISTAR);
            miResultSet = miPreparedStatement.executeQuery();
            while (miResultSet.next()) {
                misVentas.add(empaquetarDatosListarVentas(miResultSet));
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
        return misVentas;
    }

    public int generarIdVenta() {
        int idNuevaVenta = 1;
        try {
            miConnection = getConexion();
            miPreparedStatement = miConnection.prepareStatement(LAST_VENTA);
            miResultSet = miPreparedStatement.executeQuery();
            if (miResultSet.next()) {
                idNuevaVenta = miResultSet.getInt("idVenta") + 1;
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
        return idNuevaVenta;
    }

    // MÉTODOS AUXILIARES
    private Venta empaquetarDatosBuscarVentas(ResultSet miResultSet) throws SQLException {
        Venta miVenta = new Venta();
        miVenta.setDniUsuario(miResultSet.getString("dniUsuario"));
        miVenta.setDniCliente(miResultSet.getString("dniCliente"));
        miVenta.setMonto(miResultSet.getFloat("monto"));
        miVenta.setBoleta(miResultSet.getBoolean("boleta"));
        return miVenta;
    }

    private Venta empaquetarDatosListarVentas(ResultSet miResultSet) throws SQLException {
        Venta miVenta = new Venta();
        miVenta.setIdVenta(miResultSet.getInt("idVenta"));
        miVenta.setDniUsuario(miResultSet.getString("dniUsuario"));
        miVenta.setDniCliente(miResultSet.getString("dniCliente"));
        miVenta.setMonto(miResultSet.getFloat("monto"));
        miVenta.setBoleta(miResultSet.getBoolean("boleta"));
        return miVenta;
    }
}
