/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import modelo.Usuario;
import modelo.UsuarioDAO;
import vista.PanelUsuarios;

/**
 *
 * @author krypt97
 */
public class ControladorUsuario {
    // ATRIBUTOS DE CLASE
    PanelUsuarios miPanelUsuarios;
    UsuarioDAO miUsuarioDAO;

    // ENLACE VISTA
    public void setPanelUsuarios(PanelUsuarios miPanelUsuarios) {
        this.miPanelUsuarios = miPanelUsuarios;
    }

    // ENLACE MODELO
    public void setUsuarioDAO(UsuarioDAO miUsuarioDAO) {
        this.miUsuarioDAO = miUsuarioDAO;
    }
    
    // MÉTODOS DE CLASE
    public void registrar(Usuario miUsuario) {
        miUsuarioDAO.registrarUsuario(miUsuario);
        miPanelUsuarios.limpiarCampos();
    }
    
    public void eliminar(String dniUsuario) {
        miUsuarioDAO.eliminarUsuario(dniUsuario);
        miPanelUsuarios.limpiarCampos();
    }

    public void modificar(Usuario miUsuario) {
        miUsuarioDAO.modificarUsuario(miUsuario);
        miPanelUsuarios.limpiarCampos();
    }
    
    public void actualizarTabla() {
        miPanelUsuarios.setTabla(miUsuarioDAO.listarUsuarios());
    }

}
