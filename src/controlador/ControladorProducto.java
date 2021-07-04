/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOError;
import java.util.ArrayList;
import modelo.Categoria;
import modelo.CategoriaDAO;
import modelo.Producto;
import modelo.ProductoDAO;
import vista.PanelProducto;

/**
 *
 * @author AlexTprog
 */
public class ControladorProducto {

    private PanelProducto panel;

    public ControladorProducto(PanelProducto pan) {
        this.panel = pan;

        colocarCategorias();
        rellenarTabla();
        this.panel.btnAgregarProd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    int idP = Integer.parseInt(panel.txtIdProducto.getText());
                    String nombre = panel.txtNombre.getText();
                    int cantidad = Integer.parseInt(panel.txtCantidad.getText());
                    String nombreCat = panel.cbxCategoria.getSelectedItem().toString();
                    float precio = Float.parseFloat(panel.txtPrecio.getText());
                    int idProv = Integer.parseInt(panel.txtProveedor.getText());
                    int idCat = panel.cbxCategoria.getSelectedIndex() + 1;
                    ProductoDAO.registrarProducto(new Producto(idP, nombre, cantidad, nombreCat, precio, idProv, idCat));
                    rellenarTabla();
                    panel.lblAlerta.setText("Insertado con exito");
                } catch (NumberFormatException error) {
                    System.out.println("CAMPOS INCOMPLETOS");
                    panel.lblAlerta.setText("Complete todos los campos");
                    limpiar();
                }

            }
        });

        this.panel.btnBorrarProd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

    }

    void rellenarTabla() {
        ArrayList<Producto> prod = ProductoDAO.mostrarProductos();
        String matriz[][] = new String[prod.size()][6];

        for (int i = 0; i < prod.size(); i++) {
            matriz[i][0] = Integer.toString(prod.get(i).getIdProducto());
            matriz[i][1] = prod.get(i).getNombre();
            matriz[i][2] = Integer.toString(prod.get(i).getCantidad());
            matriz[i][3] = prod.get(i).getCategoria();
            matriz[i][4] = Float.toString(prod.get(i).getPrecio());
            matriz[i][5] = Integer.toString(prod.get(i).getIdProveedor());
        }

        this.panel.tblProductos.setModel(new javax.swing.table.DefaultTableModel(
                matriz,
                new String[]{
                    "ID", "Nombre", "Cantidad", "Categoria", "Precio", "ID Proveedor"
                }
        ) {
            boolean[] canEdit = new boolean[]{
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });

    }

    void colocarCategorias() {
        ArrayList<Categoria> cat = CategoriaDAO.mostrarCategorias();
        for (int i = 0; i < cat.size(); i++) {
            this.panel.cbxCategoria.addItem(cat.get(i).getNombreCategoria());
        }

    }

    void limpiar() {
        panel.txtIdProducto.setText("");
        panel.txtNombre.setText("");
        panel.txtCantidad.setText("");
        panel.cbxCategoria.setSelectedIndex(0);
        panel.txtPrecio.setText("");
        panel.txtProveedor.setText("");
    }

}
