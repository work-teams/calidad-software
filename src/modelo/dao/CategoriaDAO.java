/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.vo.Categoria;
import modelo.ConexionDB;

/**
 *
 * @author AlexTprog
 */
public class CategoriaDAO {

    private static PreparedStatement ps;
    private static ResultSet r;

    public static void registrarCategoria(Categoria c) {
        //INSERT INTO CATEGORIA () VALUES (?)        
        try {
            Connection con = ConexionDB.getConexion();
            ps = con.prepareStatement("INSERT INTO categoria "
                    + "(idCategoria,nombreCategoria) "
                    + "VALUES (?,?)");

            ps.setInt(1, c.getIdCategoria());
            ps.setString(2, c.getNombreCategoria());

            int result = ps.executeUpdate();

            if (result > 0) {
                System.out.println("CATEGORIA REGISTRADA CON EXITO");
            }
            con.close();
        } catch (SQLException e) {
            System.err.println(e);
        }
    }

    public static Categoria buscarCategoria(int id) {
        //SELECT * FROM CATEGORIA WHERE idCategoria=?
        Categoria p = null;

        try {
            Connection con = ConexionDB.getConexion();
            ps = con.prepareStatement("SELECT * FROM categoria "
                    + "WHERE idCategoria=?");

            ps.setInt(1, id);
            r = ps.executeQuery();

            if (r.next()) {
                Categoria a;
                int idCat = r.getInt("idCategoria");
                String nombreCat = r.getString("nombreCategoria");

                a = new Categoria(idCat, nombreCat);
                System.out.println("CATEGORIA ENCONTRADA");
                return a;
            } else {
                System.out.println("CATEGORIA NO ENCONTRADA");
            }
        } catch (SQLException e) {
            System.err.println(e);
        }
        return p;
    }

    //
    public static ArrayList<Categoria> mostrarCategorias() {
        ArrayList<Categoria> c = new ArrayList<Categoria>();
        try {
            Connection con = ConexionDB.getConexion();
            ps = con.prepareStatement("SELECT * FROM bikeshop.categoria ");

            r = ps.executeQuery();
            while (r.next()) {
                String nombreCat = r.getString("nombreCategoria");
                int idCat = r.getInt("idCategoria");

                c.add(new Categoria(idCat, nombreCat));
            }
            System.out.println("LISTA DE CATEGORIAS ENVIADA");
            return c;
        } catch (SQLException e) {
            System.err.println(e);
        }

        return null;
    }

    public static void modificarCategoria(Categoria c) {
        //UPDATE PRODUCTO SET WHERE ID=?
        try {
            Connection con = ConexionDB.getConexion();
            ps = con.prepareStatement("UPDATE categoria SET "
                    + "nombreCategoria=? "
                    + "WHERE idCategoria=?");

            ps.setString(1, c.getNombreCategoria());
            //idCategoria
            ps.setInt(2, c.getIdCategoria());

            int result = ps.executeUpdate();

            if (result > 0) {
                System.out.println("CATEGORIA MODIFICADA CON EXITO");
            }
            con.close();
        } catch (SQLException e) {
            System.err.println(e);
        }
    }

    public static void eliminarCategoria(int id) {
        //DELETE FROM CATEGORIA WHERE ID=?
        try {
            Connection con = ConexionDB.getConexion();
            ps = con.prepareStatement("DELETE FROM categoria "
                    + "WHERE idCategoria=?");

            ps.setInt(1, id);

            int result = ps.executeUpdate();

            if (result > 0) {
                System.out.println("CATEGORIA ELIMINADA");
            }

            con.close();
        } catch (SQLException e) {
            System.err.println(e);
        }
    }
}
