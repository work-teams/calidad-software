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
    PanelUsuarios miPanelUsuarios;
    UsuarioDAO miUsuarioDAO;

    public void setPanelUsuarios(PanelUsuarios miPanelUsuarios) {
        this.miPanelUsuarios = miPanelUsuarios;
    }

    public void setUsuarioDAO(UsuarioDAO miUsuarioDAO) {
        this.miUsuarioDAO = miUsuarioDAO;
    }
    
    public void registrar(Usuario miUsuario) {
        miUsuarioDAO.registrarUsuario(miUsuario);
    }
    
    public void eliminar(int dniUsuario) {
        miUsuarioDAO.eliminarUsuario(dniUsuario);
    }

}
