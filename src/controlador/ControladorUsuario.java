/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import modelo.Usuario;
import modelo.UsuarioDAO;
import vista.PanelUsuarios;

/**
 *
 * @author krypt97
 */
public class ControladorUsuario {
    // Atributos de clase
    PanelUsuarios miPanelUsuarios;
    UsuarioDAO miUsuarioDAO;

    // Enlace con vista y modelo
    public void setPanelUsuarios(PanelUsuarios miPanelUsuarios) {
        this.miPanelUsuarios = miPanelUsuarios;
    }

    public void setUsuarioDAO(UsuarioDAO miUsuarioDAO) {
        this.miUsuarioDAO = miUsuarioDAO;
    }
    
    // Métodos de clase
    public void registrar(Usuario miUsuario) {
        miUsuarioDAO.registrarUsuario(miUsuario);
    }
    
    public void eliminar(String dniUsuario) {
        miUsuarioDAO.eliminarUsuario(dniUsuario);
    }

    public void modificar(Usuario miUsuario) {
        miUsuarioDAO.modificarUsuario(miUsuario);
    }
    
    public void listar() {
        ArrayList<Usuario> miArrayList = miUsuarioDAO.listarUsuarios();
        String[] columnas = {"DNI", "APELLIDO", "NOMBRE", "USUARIO", "CONTRASEÑA", "ROL"};
        Object[][] miData = new Object[miArrayList.size()][6];
        for (int i = 0; i < miArrayList.size(); i++) {
            miData[i][0] = miArrayList.get(i).getDniUsuario();
            miData[i][1] = miArrayList.get(i).getDniUsuario();
            miData[i][2] = miArrayList.get(i).getDniUsuario();
            miData[i][3] = miArrayList.get(i).getDniUsuario();
            miData[i][4] = miArrayList.get(i).getDniUsuario();
            miData[i][5] = miArrayList.get(i).getDniUsuario();
        }
        DefaultTableModel modelo = new DefaultTableModel(miData, columnas);
        miPanelUsuarios.setTablaUsuarios(modelo);
    }

}
