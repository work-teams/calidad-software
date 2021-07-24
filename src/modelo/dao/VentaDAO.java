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
import modelo.ConexionDB;
import modelo.vo.Venta;

/**
 *
 * @author nick_
 */
public class VentaDAO {
    private ControladorVenta controlador;
    private PreparedStatement ps;
    private ResultSet r;
    
    
    public void registrarVenta(Venta p){
        //INSERT INTO VENTA () VALUES (?)        
        try {
            Connection con = ConexionDB.getConexion();
            ps = con.prepareStatement("INSERT INTO venta "
                    + "(idVenta,dniUsuario,dniCliente,idPedido,monto,boleta) "
                    + "VALUES (?,?,?,?,?,?)");

            ps.setInt(1, p.getIdVenta());
            ps.setString(2, p.getDniUsuario());
            ps.setString(3, p.getDniCliente());
            ps.setInt(4, p.getIdPedido());
            ps.setFloat(5, p.getMonto());
            ps.setBoolean(6, p.isBoleta());
                    
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
                

                p = new Venta(idV, dniUsuario, dniCliente, idPedido, monto, boleta);
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
    public ArrayList<Venta> mostrarVentas() {
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

                p.add(new Venta(idV, dniUsuario, dniCliente, idPedido, monto, boleta));
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
            ps.setInt(3, p.getIdPedido());
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
    public void setControladorVenta(ControladorVenta control) {
        this.controlador = control;
    }
}
