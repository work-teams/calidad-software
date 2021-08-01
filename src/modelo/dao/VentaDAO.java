/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao;

import controlador.ControladorVenta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.ConexionDB;
import static modelo.ConexionDB.getConexion;
import modelo.vo.Venta;

/**
 *
 * @author nick_
 */
public class VentaDAO {
    ControladorVenta miControladorVenta;
    private PreparedStatement ps;
    private ResultSet r;
    
    // ATRIBUTOS DE CLASE
    private Connection miConnection;
    private PreparedStatement miPreparedStatement;
    private ResultSet miResultSet;
    
    // SENTENCIAS MYSQL
    private String LAST_VENTA = "SELECT idVenta FROM venta ORDER BY idVenta DESC LIMIT 1";
    
    // ENLACE CONTROLADOR
    public void setControladorVentas(ControladorVenta miControladorVenta) {
        this.miControladorVenta = miControladorVenta;
    }
    
    public void registrarVenta(Venta p){
        //INSERT INTO VENTA () VALUES (?)        
        try {
            Connection con = ConexionDB.getConexion();
            ps = con.prepareStatement("INSERT INTO venta "
                    + "(dniUsuario,dniCliente,monto,boleta) "
                    + "VALUES (?,?,?,?)");

            ps.setString(1, p.getDniUsuario());
            ps.setString(2, p.getDniCliente());
            ps.setFloat(3, p.getMonto());
            ps.setBoolean(4, p.isBoleta());
                    
            int result = ps.executeUpdate();

            if (result > 0) {
                System.out.println("VENTA REGISTRADA CON EXITO");
            }

            con.close();
        } catch (SQLException e) {
            System.err.println(e);
        }
    }
    //Buscar por ID
    public Venta buscarVenta(int id) {
        //SELECT * FROM VENTA WHERE id_venta=?
        Venta p = null;

        try {
            Connection con = ConexionDB.getConexion();
            ps = con.prepareStatement("SELECT * FROM venta "
                    + "WHERE idVenta=?");

            ps.setInt(1, id);

            r = ps.executeQuery();

            if (r.next()) {
                int idV = r.getInt("idVenta");
                String dniUsuario = r.getString("dniUsuario");
                String dniCliente = r.getString("dniCliente");
                int idPedido = r.getInt("idPedido");
                float monto = r.getFloat("monto");
                boolean boleta = r.getBoolean("boleta");
                

                //p = new Venta(idV, dniUsuario, dniCliente, idPedido, monto, boleta);
                System.out.println("VENTA ENCONTRADA");
                return p;
            } else {
                System.out.println("VENTA NO ENCONTRADA");
            }
        } catch (SQLException e) {
            System.err.println(e);
        }
        return p;
    }
    
    //Devuelve arraylist con ventas
    public ArrayList<Venta> listarVentas() {
        ArrayList<Venta> p = new ArrayList<Venta>();
        try {
            Connection con = ConexionDB.getConexion();
            ps = con.prepareStatement("SELECT * FROM bikeshop.venta ");

            r = ps.executeQuery();
            while (r.next()) {
                int idV = r.getInt("idVenta");
                String dniUsuario = r.getString("dniUsuario");
                String dniCliente = r.getString("dniCliente");
                int idPedido = r.getInt("idPedido");
                float monto = r.getFloat("monto");
                boolean boleta = r.getBoolean("boleta");

                //p.add(new Venta(idV, dniUsuario, dniCliente, idPedido, monto, boleta));
            }

            System.out.println("LISTA DE VENTAS ENVIADA");
            return p;
        } catch (SQLException e) {
            System.err.println(e);
        }

        return null;
    }
    
    //Seleccion por ID y modifica
    public void modificarVenta(Venta p) {
        //UPDATE VENTA SET WHERE ID=?
        try {
            Connection con = ConexionDB.getConexion();
            ps = con.prepareStatement("UPDATE venta SET "
                    + "dniUsuario=?, dniCliente=?, idPedido=?, monto=?, boleta=? "
                    + "WHERE idVenta=?");

            ps.setString(1, p.getDniUsuario());
            ps.setString(2, p.getDniCliente());
            //ps.setInt(3, p.getIdPedido());
            ps.setFloat(4, p.getMonto());
            ps.setBoolean(5, p.isBoleta());
            
            //idProducto de la venta a modificar
            ps.setInt(7, p.getIdVenta());

            int result = ps.executeUpdate();

            if (result > 0) {
                System.out.println("VENTA MODIFICADA CON EXITO");
            }

            con.close();
        } catch (SQLException e) {
            System.err.println(e);
        }
    }

    
    //Elimina por id
    public void eliminarVenta(int id) {
        //DELETE FROM VENTA WHERE ID=?
        try {
            Connection con = ConexionDB.getConexion();
            ps = con.prepareStatement("DELETE FROM venta "
                    + "WHERE idVenta=?");

            ps.setInt(1, id);

            int result = ps.executeUpdate();

            if (result == 0) {
                System.out.println("VENTA NO ENCONTRADA");
            } else {
                System.out.println("VENTA ELIMINADA");
            }

            con.close();
        } catch (SQLException e) {
            System.err.println(e);
        }
    }
    
    // Devolver id de la nueva venta realizada.
    public int generarIdVenta() {
        int idNuevaVenta = 1;
        try {
            miConnection = getConexion();
            miPreparedStatement = miConnection.prepareStatement(LAST_VENTA);
            miResultSet = miPreparedStatement.executeQuery();
            if (miResultSet.next()) {
                idNuevaVenta = miResultSet.getInt("idVenta") + 1;
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            try {
                miConnection.close();
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
        return idNuevaVenta;
    }
}
