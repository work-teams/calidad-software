/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Connection;

/**
 *
 * @author AlexTprog
 */
public class ProductoDAO {

    private static PreparedStatement ps;
    private static ResultSet r;

    public static void registrarProducto(Producto p) {
        //INSERT INTO PRODUCTO () VALUES (?)        
        try {
            Connection con = ConexionDB.getConexion();
            ps = con.prepareStatement("INSERT INTO PRODUCTO "
                    + "(idProducto,nombre,cantidad,categoria,precio,idProveedor,idCategoria) "
                    + "VALUES (?,?,?,?,?,?)");

            ps.setInt(1, p.getIdProducto());
            ps.setString(2, p.getNombre());
            ps.setInt(3, p.getCantidad());
            ps.setString(4, p.getCategoria());//CATEGORIA NOMBRE
            ps.setFloat(5, p.getPrecio());
            ps.setInt(6, p.getIdProveedor());//IDPROVEEDOR
            ps.setInt(7, p.getIdCategoria());//CATEGORIA ID

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
            ps = con.prepareStatement("SELECT * FROM PRODUCTO "
                    + "WHERE id_producto=?");

            r = ps.executeQuery();

            if (r.next()) {
                int idP = r.getInt("idProducto");
                String nombre = r.getString("nombre");
                int cantidad = r.getInt("cantidad");
                String nombreCat = r.getString("categoria");
                float precio = r.getFloat("precio");
                int idProv = r.getInt("idProveedor");
                int idCat = r.getInt("idProveedor");

                p = new Producto(idP, nombre, cantidad, precio, nombreCat, idCat, idProv);
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
    //Seleccion por ID y modifica

    public static void modificarProducto(Producto p, int id) {
        //UPDATE PRODUCTO SET WHERE ID=?
        try {
            Connection con = ConexionDB.getConexion();
            ps = con.prepareStatement("UPDATE INTO PRODUCTO "
                    + "cantidad=?, categoria=?, precio=?, idProveedor=?, idCategoria=? "
                    + "WHERE idProducto=?");

            ps.setInt(1, p.getCantidad());
            ps.setString(2, p.getNombre());
            ps.setString(3, p.getCategoria());
            ps.setFloat(5, p.getPrecio());
            ps.setInt(6, p.getIdProveedor());
            ps.setInt(7, p.getIdCategoria());
            //idProducto
            ps.setInt(8, p.getIdProducto());

            int result = ps.executeUpdate();

            if (result > 0) {
                System.out.println("PRODUCTO REGISTRADO CON EXITO");
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
            ps = con.prepareStatement("DELETE FROM PRODUCTO "
                    + "WHERE idProducto=?");

            ps.setInt(1, id);

            int result = ps.executeUpdate();

            if (result > 0) {
                System.out.println("PRODUCTO ELIMINADO");
            }

            con.close();
        } catch (SQLException e) {
            System.err.println(e);
        }
    }
}
