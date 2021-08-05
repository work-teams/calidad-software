/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import modelo.vo.Usuario;
import modelo.dao.UsuarioDAO;
import vista.PanelUsuarios;

/**
 *
 * @author krypt97
 */
public class ControladorUsuario {

    // ATRIBUTOS DE CLASE
    private PanelUsuarios miPanelUsuarios;
    private UsuarioDAO miUsuarioDAO;
    private Usuario miUsuario;
    private String dniUsuario;

    // ENLACE VISTA
    public void setPanelUsuarios(PanelUsuarios miPanelUsuarios) {
        this.miPanelUsuarios = miPanelUsuarios;
    }

    // ENLACE MODELO
    // Dao
    public void setUsuarioDAO(UsuarioDAO miUsuarioDAO) {
        this.miUsuarioDAO = miUsuarioDAO;
    }

    // MÉTODOS DE CLASE
    public void registrarUsuario() {
        miUsuario = miPanelUsuarios.empaquetarDatosUsuario();
        miUsuarioDAO.registrarUsuario(miUsuario);
        miPanelUsuarios.setTablaUsuarios(miUsuarioDAO.listarUsuarios());
        miPanelUsuarios.limpiarCampos();
    }

    public void eliminarUsuario() {
        dniUsuario = miPanelUsuarios.txtDni.getText();
        miUsuarioDAO.eliminarUsuario(dniUsuario);
        miPanelUsuarios.setTablaUsuarios(miUsuarioDAO.listarUsuarios());
        miPanelUsuarios.limpiarCampos();
    }

    public void modificarUsuario() {
        miUsuario = miPanelUsuarios.empaquetarDatosUsuario();
        miUsuarioDAO.modificarUsuario(miUsuario);
        miPanelUsuarios.setTablaUsuarios(miUsuarioDAO.listarUsuarios());
        miPanelUsuarios.limpiarCampos();
    }

    public void buscarUsuario() {
        dniUsuario = miPanelUsuarios.txtDni.getText();
        if (miUsuarioDAO.buscarUsuario(dniUsuario) != null) {
            miPanelUsuarios.desempaquetarDatosUsuario(miUsuarioDAO.buscarUsuario(dniUsuario));
        }
    }
}
