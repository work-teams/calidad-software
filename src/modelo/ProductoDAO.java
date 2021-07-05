/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import controlador.ControladorProducto;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Connection;
import java.util.ArrayList;

/**
 *
 * @author AlexTprog
 */
public class ProductoDAO {

    private static ControladorProducto controlador;
    private static PreparedStatement ps;
    private static ResultSet r;

    public static void registrarProducto(Producto p) {
        //INSERT INTO PRODUCTO () VALUES (?)        
        try {
            Connection con = ConexionDB.getConexion();
            ps = con.prepareStatement("INSERT INTO producto "
                    + "(idProducto,nombre,cantidad,categoria,precio,idProveedor,idCategoria) "
                    + "VALUES (?,?,?,?,?,?,?)");

            ps.setInt(1, p.getIdProducto());
            ps.setString(2, p.getNombre());
            ps.setInt(3, p.getCantidad());
            ps.setString(4, p.getCategoria());
            ps.setFloat(5, p.getPrecio());
            ps.setInt(6, p.getIdProveedor());
            ps.setInt(7, p.getIdCategoria());

            int result = ps.executeUpdate();

            if (result > 0) {
                System.out.println("PRODUCTO REGISTRADO CON EXITO");
            }

            con.close();
        } catch (SQLException e) {
            System.err.println(e);
        }
    }

    //Buscar por ID
    public static Producto buscarProducto(int id) {
        //SELECT * FROM PRODUCTO WHERE id_producto=?
        Producto p = null;

        try {
            Connection con = ConexionDB.getConexion();
            ps = con.prepareStatement("SELECT * FROM producto "
                    + "WHERE idProducto=?");

            ps.setInt(1, id);

            r = ps.executeQuery();

            if (r.next()) {
                int idP = r.getInt("idProducto");
                String nombre = r.getString("nombre");
                int cantidad = r.getInt("cantidad");
                String nombreCat = r.getString("categoria");
                float precio = r.getFloat("precio");
                int idProv = r.getInt("idProveedor");
                int idCat = r.getInt("idCategoria");

                p = new Producto(idP, nombre, cantidad, nombreCat, precio, idProv, idCat);
                System.out.println("PRODUCTO ENCONTRADO");
                return p;
            } else {
                System.out.println("PRODUCTO NO ENCONTRADO");
            }
        } catch (SQLException e) {
            System.err.println(e);
        }
        return p;
    }

    //Devuelve arraylist con productos
    public static ArrayList<Producto> mostrarProductos() {
        ArrayList<Producto> p = new ArrayList<Producto>();
        try {
            Connection con = ConexionDB.getConexion();
            ps = con.prepareStatement("SELECT * FROM bikeshop.producto ");

            r = ps.executeQuery();
            while (r.next()) {
                int idP = r.getInt("idProducto");
                String nombre = r.getString("nombre");
                int cantidad = r.getInt("cantidad");
                String nombreCat = r.getString("categoria");
                float precio = r.getFloat("precio");
                int idProv = r.getInt("idProveedor");
                int idCat = r.getInt("idCategoria");

                p.add(new Producto(idP, nombre, cantidad, nombreCat, precio, idProv, idCat));
            }

            System.out.println("LISTA DE PRODUCTOS ENVIADA");
            return p;
        } catch (SQLException e) {
            System.err.println(e);
        }

        return null;
    }

    //Seleccion por ID y modifica
    public static void modificarProducto(Producto p) {
        //UPDATE PRODUCTO SET WHERE ID=?
        try {
            Connection con = ConexionDB.getConexion();
            ps = con.prepareStatement("UPDATE producto SET "
                    + "nombre=?, cantidad=?, categoria=?, precio=?, idProveedor=?, idCategoria=? "
                    + "WHERE idProducto=?");

            ps.setString(1, p.getNombre());
            ps.setInt(2, p.getCantidad());
            ps.setString(3, p.getCategoria());
            ps.setFloat(4, p.getPrecio());
            ps.setInt(5, p.getIdProveedor());
            ps.setInt(6, p.getIdCategoria());
            //idProducto del producto a modificar
            ps.setInt(7, p.getIdProducto());

            int result = ps.executeUpdate();

            if (result > 0) {
                System.out.println("PRODUCTO MODIFICADO CON EXITO");
            }

            con.close();
        } catch (SQLException e) {
            System.err.println(e);
        }
    }

    //Elimina por id
    public static void eliminarProducto(int id) {
        //DELETE FROM PRODUCTO WHERE ID=?
        try {
            Connection con = ConexionDB.getConexion();
            ps = con.prepareStatement("DELETE FROM producto "
                    + "WHERE idProducto=?");

            ps.setInt(1, id);

            int result = ps.executeUpdate();

            if (result == 0) {
                System.out.println("PRODUCTO NO ENCONTRADO");
            }
            else{
                System.out.println("PRODUCTO ELIMINADO");
            }

            con.close();
        } catch (SQLException e) {
            System.err.println(e);            
        }
    }

    public void setControladorProducto(ControladorProducto control) {
        this.controlador = control;
    }
}
