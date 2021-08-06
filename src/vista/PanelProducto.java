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
        panCuerpo.setOpaque(true);
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
        panCuerpo = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProductos = new javax.swing.JTable();
        panRegistro = new javax.swing.JPanel();
        cbxCategoria = new javax.swing.JComboBox<>();
        txtNombre = new jtextfieldround.JTextFieldRound();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        lblImgProd = new javax.swing.JLabel();
        txtProveedor = new jtextfieldround.JTextFieldRound();
        jLabel17 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtPrecio = new jtextfieldround.JTextFieldRound();
        txtIdProducto = new jtextfieldround.JTextFieldRound();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtCantidad = new jtextfieldround.JTextFieldRound();
        panBtns = new javax.swing.JPanel();
        btnBuscar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnBorrarProd = new javax.swing.JButton();
        btnAgregarProd = new javax.swing.JButton();
        panEncabezado = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(1150, 720));
        setMinimumSize(new java.awt.Dimension(1150, 720));
        setPreferredSize(new java.awt.Dimension(1150, 720));
        setLayout(new java.awt.BorderLayout());

        panCuerpo.setBackground(new java.awt.Color(57, 103, 196));
        panCuerpo.setForeground(new java.awt.Color(255, 255, 255));
        panCuerpo.setMaximumSize(new java.awt.Dimension(1150, 680));
        panCuerpo.setMinimumSize(new java.awt.Dimension(1150, 680));
        panCuerpo.setPreferredSize(new java.awt.Dimension(1150, 680));

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
        jScrollPane1.setViewportView(tblProductos);

        panRegistro.setBackground(new java.awt.Color(57, 103, 196));
        panRegistro.setMaximumSize(new java.awt.Dimension(1150, 190));
        panRegistro.setMinimumSize(new java.awt.Dimension(1150, 190));
        panRegistro.setPreferredSize(new java.awt.Dimension(1150, 190));

        txtNombre.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtNombre.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });

        jLabel11.setBackground(new java.awt.Color(70, 106, 124));
        jLabel11.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Nombre");

        jLabel13.setBackground(new java.awt.Color(70, 106, 124));
        jLabel13.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Categoria");

        lblImgProd.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblImgProd.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        lblImgProd.setOpaque(true);

        txtProveedor.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtProveedor.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel17.setBackground(new java.awt.Color(70, 106, 124));
        jLabel17.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("ID Proveedor");

        jLabel12.setBackground(new java.awt.Color(70, 106, 124));
        jLabel12.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Precio");

        txtPrecio.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtPrecio.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        txtIdProducto.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtIdProducto.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel9.setBackground(new java.awt.Color(70, 106, 124));
        jLabel9.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("ID");

        jLabel10.setBackground(new java.awt.Color(70, 106, 124));
        jLabel10.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Cantidad");

        txtCantidad.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtCantidad.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        panBtns.setBackground(new java.awt.Color(57, 103, 196));

        btnBuscar.setBackground(new java.awt.Color(44, 80, 154));
        btnBuscar.setForeground(new java.awt.Color(255, 255, 255));
        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/buscar.png"))); // NOI18N
        btnBuscar.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(""), "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 12), new java.awt.Color(50, 133, 203))); // NOI18N
        btnBuscar.setBorderPainted(false);
        btnBuscar.setContentAreaFilled(false);
        btnBuscar.setFocusPainted(false);
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        btnModificar.setBackground(new java.awt.Color(44, 80, 154));
        btnModificar.setForeground(new java.awt.Color(255, 255, 255));
        btnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/editar.png"))); // NOI18N
        btnModificar.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(""), "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 12), new java.awt.Color(50, 133, 203))); // NOI18N
        btnModificar.setBorderPainted(false);
        btnModificar.setContentAreaFilled(false);
        btnModificar.setFocusPainted(false);
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        btnBorrarProd.setBackground(new java.awt.Color(44, 80, 154));
        btnBorrarProd.setForeground(new java.awt.Color(255, 255, 255));
        btnBorrarProd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/eliminar.png"))); // NOI18N
        btnBorrarProd.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(""), "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 12), new java.awt.Color(50, 133, 203))); // NOI18N
        btnBorrarProd.setBorderPainted(false);
        btnBorrarProd.setContentAreaFilled(false);
        btnBorrarProd.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnBorrarProd.setFocusPainted(false);
        btnBorrarProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarProdActionPerformed(evt);
            }
        });

        btnAgregarProd.setBackground(new java.awt.Color(57, 103, 196));
        btnAgregarProd.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregarProd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/agregar.png"))); // NOI18N
        btnAgregarProd.setToolTipText("Agregar");
        btnAgregarProd.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(""), "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 12), new java.awt.Color(50, 133, 203))); // NOI18N
        btnAgregarProd.setBorderPainted(false);
        btnAgregarProd.setContentAreaFilled(false);
        btnAgregarProd.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnAgregarProd.setFocusPainted(false);
        btnAgregarProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarProdActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panBtnsLayout = new javax.swing.GroupLayout(panBtns);
        panBtns.setLayout(panBtnsLayout);
        panBtnsLayout.setHorizontalGroup(
            panBtnsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panBtnsLayout.createSequentialGroup()
                .addContainerGap(90, Short.MAX_VALUE)
                .addComponent(btnBorrarProd)
                .addContainerGap())
            .addGroup(panBtnsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panBtnsLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(panBtnsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btnAgregarProd)
                        .addGroup(panBtnsLayout.createSequentialGroup()
                            .addComponent(btnBuscar)
                            .addGap(18, 18, 18)
                            .addComponent(btnModificar)))
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        panBtnsLayout.setVerticalGroup(
            panBtnsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panBtnsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnBorrarProd)
                .addContainerGap(78, Short.MAX_VALUE))
            .addGroup(panBtnsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panBtnsLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(btnAgregarProd)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(panBtnsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btnBuscar)
                        .addComponent(btnModificar))
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout panRegistroLayout = new javax.swing.GroupLayout(panRegistro);
        panRegistro.setLayout(panRegistroLayout);
        panRegistroLayout.setHorizontalGroup(
            panRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panRegistroLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblImgProd, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panRegistroLayout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel12)
                        .addGap(582, 582, 582))
                    .addGroup(panRegistroLayout.createSequentialGroup()
                        .addGroup(panRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtProveedor, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 337, Short.MAX_VALUE)
                            .addComponent(txtIdProducto, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNombre, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(panRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panRegistroLayout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(panRegistroLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                                .addGroup(panRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel13)
                                    .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbxCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(197, 197, 197)))
                        .addComponent(panBtns, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(101, 101, 101))
                    .addGroup(panRegistroLayout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel10)
                        .addGap(565, 565, 565))))
        );
        panRegistroLayout.setVerticalGroup(
            panRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panRegistroLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panRegistroLayout.createSequentialGroup()
                        .addComponent(panBtns, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14))
                    .addGroup(panRegistroLayout.createSequentialGroup()
                        .addGroup(panRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panRegistroLayout.createSequentialGroup()
                                .addGroup(panRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel10))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtIdProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel17)
                                    .addComponent(jLabel12))
                                .addGap(7, 7, 7)
                                .addGroup(panRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel13)
                                    .addComponent(jLabel11)))
                            .addComponent(lblImgProd, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbxCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12))))
        );

        javax.swing.GroupLayout panCuerpoLayout = new javax.swing.GroupLayout(panCuerpo);
        panCuerpo.setLayout(panCuerpoLayout);
        panCuerpoLayout.setHorizontalGroup(
            panCuerpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(panCuerpoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1130, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        panCuerpoLayout.setVerticalGroup(
            panCuerpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panCuerpoLayout.createSequentialGroup()
                .addComponent(panRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 469, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );

        add(panCuerpo, java.awt.BorderLayout.CENTER);

        panEncabezado.setBackground(new java.awt.Color(44, 80, 154));
        panEncabezado.setForeground(new java.awt.Color(255, 255, 255));
        panEncabezado.setMaximumSize(new java.awt.Dimension(1150, 40));
        panEncabezado.setMinimumSize(new java.awt.Dimension(1150, 40));
        panEncabezado.setPreferredSize(new java.awt.Dimension(1150, 40));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
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

        add(panEncabezado, java.awt.BorderLayout.PAGE_START);
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

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed


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
    private javax.swing.JLabel lblImgProd;
    private javax.swing.JPanel panBtns;
    public javax.swing.JPanel panCuerpo;
    private javax.swing.JPanel panEncabezado;
    private javax.swing.JPanel panRegistro;
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

}
