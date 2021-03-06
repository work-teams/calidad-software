/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.ControladorProducto;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import modelo.vo.Categoria;
import modelo.vo.Producto;
import modelo.vo.Proveedor;

/**
 *
 * @author krypt97
 */
public class PanelProducto extends javax.swing.JPanel {

    ControladorProducto miControladorProducto;

    /**
     * Creates new form NewPanelUsuarios
     */
    public PanelProducto() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextFieldRoundBeanInfo1 = new jtextfieldround.JTextFieldRoundBeanInfo();
        panEncabezado = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        panDatos = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        cbxCategoria = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        txtProveedor = new jtextfieldround.JTextFieldRound();
        txtNombre = new jtextfieldround.JTextFieldRound();
        txtIdProducto = new jtextfieldround.JTextFieldRound();
        txtPrecio = new jtextfieldround.JTextFieldRound();
        txtCantidad = new jtextfieldround.JTextFieldRound();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProductos = tblProductos = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex,int colIndex){
                return false;//Disallow the editing of any cell
            }
        };
        lblImg = new javax.swing.JLabel();
        btnAgregarProd = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnBorrarProd = new javax.swing.JButton();

        setMinimumSize(new java.awt.Dimension(1120, 690));
        setPreferredSize(new java.awt.Dimension(1120, 690));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panEncabezado.setBackground(new java.awt.Color(44, 80, 154));
        panEncabezado.setForeground(new java.awt.Color(255, 255, 255));
        panEncabezado.setMinimumSize(new java.awt.Dimension(1120, 40));
        panEncabezado.setPreferredSize(new java.awt.Dimension(1120, 40));

        jLabel1.setFont(new java.awt.Font("Roboto", 1, 36));
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Productos");

        javax.swing.GroupLayout panEncabezadoLayout = new javax.swing.GroupLayout(panEncabezado);
        panEncabezado.setLayout(panEncabezadoLayout);
        panEncabezadoLayout.setHorizontalGroup(
            panEncabezadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panEncabezadoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap())
        );
        panEncabezadoLayout.setVerticalGroup(
            panEncabezadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1)
        );

        add(panEncabezado, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        panDatos.setBackground(new java.awt.Color(57, 103, 196));
        panDatos.setMinimumSize(new java.awt.Dimension(1120, 650));
        panDatos.setPreferredSize(new java.awt.Dimension(1120, 650));
        panDatos.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setBackground(new java.awt.Color(70, 106, 124));
        jLabel9.setFont(new java.awt.Font("Roboto", 1, 16));
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("ID");
        panDatos.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(145, 28, -1, -1));

        jLabel11.setBackground(new java.awt.Color(70, 106, 124));
        jLabel11.setFont(new java.awt.Font("Roboto", 1, 16));
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Nombre");
        panDatos.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(145, 70, 70, 18));

        jLabel13.setBackground(new java.awt.Color(70, 106, 124));
        jLabel13.setFont(new java.awt.Font("Roboto", 1, 16));
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Categoria");
        panDatos.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(584, 28, 80, 19));

        cbxCategoria.setFont(new java.awt.Font("Roboto", 1, 12));
        panDatos.add(cbxCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(659, 23, 253, 27));

        jLabel10.setBackground(new java.awt.Color(70, 106, 124));
        jLabel10.setFont(new java.awt.Font("Roboto", 1, 16));
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Cantidad");
        panDatos.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(582, 111, -1, -1));

        jLabel12.setBackground(new java.awt.Color(70, 106, 124));
        jLabel12.setFont(new java.awt.Font("Roboto", 1, 16));
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Precio");
        panDatos.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(584, 69, -1, -1));

        jLabel17.setBackground(new java.awt.Color(70, 106, 124));
        jLabel17.setFont(new java.awt.Font("Roboto", 1, 16));
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("ID Proveedor");
        panDatos.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(145, 111, -1, -1));

        txtProveedor.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtProveedor.setFont(new java.awt.Font("Roboto", 0, 14));
        panDatos.add(txtProveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(258, 107, 257, 27));

        txtNombre.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtNombre.setFont(new java.awt.Font("Roboto", 0, 14));
        panDatos.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(258, 65, 257, 27));

        txtIdProducto.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtIdProducto.setFont(new java.awt.Font("Roboto", 0, 14));
        panDatos.add(txtIdProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(258, 23, 257, 27));

        txtPrecio.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtPrecio.setFont(new java.awt.Font("Roboto", 0, 14));
        panDatos.add(txtPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(659, 65, 253, 27));

        txtCantidad.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtCantidad.setFont(new java.awt.Font("Roboto", 0, 14));
        panDatos.add(txtCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(659, 108, 253, 27));

        tblProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Nombre", "Categoria", "Proveedor", "Precio", "Cantidad"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblProductos.setShowGrid(true);
        tblProductos.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tblProductosFocusGained(evt);
            }
        });
        jScrollPane1.setViewportView(tblProductos);

        panDatos.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 181, 1100, 440));

        lblImg.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblImg.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        lblImg.setMinimumSize(new java.awt.Dimension(130, 130));
        lblImg.setOpaque(true);
        lblImg.setPreferredSize(new java.awt.Dimension(130, 130));
        panDatos.add(lblImg, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 19, 120, 120));

        btnAgregarProd.setBackground(new java.awt.Color(57, 103, 196));
        btnAgregarProd.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregarProd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/agregar.png"))); // NOI18N
        btnAgregarProd.setToolTipText("Agregar");
        btnAgregarProd.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(""), "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(50, 133, 203))); // NOI18N
        btnAgregarProd.setBorderPainted(false);
        btnAgregarProd.setContentAreaFilled(false);
        btnAgregarProd.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnAgregarProd.setFocusPainted(false);
        btnAgregarProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarProdActionPerformed(evt);
            }
        });
        panDatos.add(btnAgregarProd, new org.netbeans.lib.awtextra.AbsoluteConstraints(982, 10, 65, 65));

        btnBuscar.setBackground(new java.awt.Color(44, 80, 154));
        btnBuscar.setForeground(new java.awt.Color(255, 255, 255));
        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/buscar.png"))); // NOI18N
        btnBuscar.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(""), "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(50, 133, 203))); // NOI18N
        btnBuscar.setBorderPainted(false);
        btnBuscar.setContentAreaFilled(false);
        btnBuscar.setFocusPainted(false);
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        panDatos.add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(982, 79, 65, 65));

        btnModificar.setBackground(new java.awt.Color(44, 80, 154));
        btnModificar.setForeground(new java.awt.Color(255, 255, 255));
        btnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/editar.png"))); // NOI18N
        btnModificar.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(""), "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(50, 133, 203))); // NOI18N
        btnModificar.setBorderPainted(false);
        btnModificar.setContentAreaFilled(false);
        btnModificar.setFocusPainted(false);
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });
        panDatos.add(btnModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 79, 65, 65));

        btnBorrarProd.setBackground(new java.awt.Color(44, 80, 154));
        btnBorrarProd.setForeground(new java.awt.Color(255, 255, 255));
        btnBorrarProd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/eliminar.png"))); // NOI18N
        btnBorrarProd.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(""), "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(50, 133, 203))); // NOI18N
        btnBorrarProd.setBorderPainted(false);
        btnBorrarProd.setContentAreaFilled(false);
        btnBorrarProd.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnBorrarProd.setFocusPainted(false);
        btnBorrarProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarProdActionPerformed(evt);
            }
        });
        panDatos.add(btnBorrarProd, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 10, 65, 65));

        add(panDatos, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        // TODO add your handling code here:
        miControladorProducto.buscarProducto();
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        // TODO add your handling code here:
        miControladorProducto.modificarProducto();
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnBorrarProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarProdActionPerformed
        miControladorProducto.eliminarProducto();
    }//GEN-LAST:event_btnBorrarProdActionPerformed

    private void btnAgregarProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarProdActionPerformed
        miControladorProducto.registrarProducto();
    }//GEN-LAST:event_btnAgregarProdActionPerformed

    private void tblProductosFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tblProductosFocusGained
        // TODO add your handling code here:
        miControladorProducto.cargarProductoSeleccionado();
    }//GEN-LAST:event_tblProductosFocusGained


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnAgregarProd;
    public javax.swing.JButton btnBorrarProd;
    public javax.swing.JButton btnBuscar;
    public javax.swing.JButton btnModificar;
    public javax.swing.JComboBox<String> cbxCategoria;
    private javax.swing.JLabel jLabel1;
    public javax.swing.JLabel jLabel10;
    public javax.swing.JLabel jLabel11;
    public javax.swing.JLabel jLabel12;
    public javax.swing.JLabel jLabel13;
    public javax.swing.JLabel jLabel17;
    public javax.swing.JLabel jLabel9;
    public javax.swing.JScrollPane jScrollPane1;
    private jtextfieldround.JTextFieldRoundBeanInfo jTextFieldRoundBeanInfo1;
    private javax.swing.JLabel lblImg;
    private javax.swing.JPanel panDatos;
    private javax.swing.JPanel panEncabezado;
    public javax.swing.JTable tblProductos;
    private jtextfieldround.JTextFieldRound txtCantidad;
    public jtextfieldround.JTextFieldRound txtIdProducto;
    private jtextfieldround.JTextFieldRound txtNombre;
    private jtextfieldround.JTextFieldRound txtPrecio;
    private jtextfieldround.JTextFieldRound txtProveedor;
    // End of variables declaration//GEN-END:variables

    public void setControlador(ControladorProducto miControladorProducto) {
        this.miControladorProducto = miControladorProducto;
    }

    public void setTablaProductos(ArrayList<Producto> misProductos, ArrayList<Categoria> misCategorias, ArrayList<Proveedor> misProveedores) {
        String[] columnas = {"ID", "Nombre", "Categoria", "Proveedor", "Precio", "Cantidad"};
        Object[][] miData = new Object[misProductos.size()][6];

        for (int i = 0; i < misProductos.size(); i++) {
            miData[i][0] = Integer.toString(misProductos.get(i).getIdProducto());
            miData[i][1] = misProductos.get(i).getNombre();
            miData[i][4] = misProductos.get(i).getPrecio();
            miData[i][5] = misProductos.get(i).getCantidad();

            for (int j = 0; j < misCategorias.size(); j++) {
                if (misCategorias.get(j).getIdCategoria() == misProductos.get(i).getIdCategoria()) {
                    miData[i][2] = misCategorias.get(j).getNombreCategoria();
                }
            }

            for (int j = 0; j < misProveedores.size(); j++) {
                if (misProveedores.get(j).getIdProveedor() == misProductos.get(i).getIdProveedor()) {
                    miData[i][3] = misProveedores.get(j).getNombre();
                }
            }
        }
        DefaultTableModel modelo = new DefaultTableModel(miData, columnas);
        tblProductos.setModel(modelo);
    }

    public void setTablaCategoria(ArrayList<Categoria> cat) {
        String matriz[][] = new String[cat.size()][2];
        String[] columnas = {"ID", "Nombre"};

        for (int i = 0; i < cat.size(); i++) {
            matriz[i][0] = Integer.toString(cat.get(i).getIdCategoria());
            matriz[i][1] = cat.get(i).getNombreCategoria();
        }

        DefaultTableModel modelo = new DefaultTableModel(matriz, columnas);
        //tblCategoria.setModel(modelo);
    }

    public void limpiarCampos() {
        txtIdProducto.setText("");
        txtNombre.setText("");
        txtCantidad.setText("");
        cbxCategoria.setSelectedIndex(0);
        txtPrecio.setText("");
        txtProveedor.setText("");
        txtIdProducto.requestFocus();
    }

    public Producto empaquetarDatosProducto() {
        Producto miProducto = new Producto();
        miProducto.setIdProducto(Integer.parseInt(txtIdProducto.getText()));
        miProducto.setIdProveedor(Integer.parseInt(txtProveedor.getText()));
        miProducto.setIdCategoria(cbxCategoria.getSelectedIndex() + 1);
        miProducto.setNombre(txtNombre.getText().toUpperCase());
        miProducto.setCantidad(Integer.parseInt(txtCantidad.getText()));
        miProducto.setPrecio(Float.parseFloat(txtPrecio.getText()));
        return miProducto;
    }

    public void setCmbxCategorias(ArrayList<Categoria> cat) {
        cbxCategoria.removeAllItems();
        for (int i = 0; i < cat.size(); i++) {
            cbxCategoria.addItem(cat.get(i).getNombreCategoria());
        }
    }

    public void desempaquetarDatosProducto(Producto miProducto) {
        //txtIdProducto.setText(Integer.toString(miProducto.getIdProducto()));
        txtNombre.setText(miProducto.getNombre());
        txtCantidad.setText(Integer.toString(miProducto.getCantidad()));
        cbxCategoria.setSelectedIndex(miProducto.getIdCategoria() - 1);
        txtPrecio.setText(Float.toString(miProducto.getPrecio()));
        txtProveedor.setText(Integer.toString(miProducto.getIdProveedor()));
    }

    public String idProductoSeleccionado() {
        String id = "";
        if (tblProductos.getSelectedRow() != -1) {
            id = (String) tblProductos.getValueAt(tblProductos.getSelectedRow(), 0);
        }
        return id;
    }
}
