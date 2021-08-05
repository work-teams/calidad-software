/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import javax.swing.JOptionPane;
import modelo.dao.UsuarioDAO;
import modelo.vo.Usuario;
import vista.VentanaLogin;
import vista.VentanaPrincipal;

/**
 *
 * @author krypt97
 */
public class ControladorLogin {

    // ATRIBUTOS DE CLASE
    private VentanaLogin miVentanaLogin;
    private VentanaPrincipal miVentanaPrincipal;
    private UsuarioDAO miUsuarioDAO;
    private Usuario miUsuario; // usuario principal del main
    private Usuario miUsuarioBuscado; // Variable necesaria para setear el usuario principal del main
    private String username;
    private String password;

    // ENLACE VISTA
    public void setVentanaLogin(VentanaLogin miVentanaLogin) {
        this.miVentanaLogin = miVentanaLogin;
    }

    public void setVentanaPrincipal(VentanaPrincipal miVentanaPrincipal) {
        this.miVentanaPrincipal = miVentanaPrincipal;
    }

    // ENLACE MODELO
    // Vo
    public void setUsuario(Usuario miUsuario) { // Usuario (vendedor) unico por cada login
        this.miUsuario = miUsuario;
    }

    // Dao
    public void setUsuarioDAO(UsuarioDAO miUsuarioDAO) {
        this.miUsuarioDAO = miUsuarioDAO;
    }

    // MÉTODOS DE CLASE
    public void logearUsuario() {
        username = miVentanaLogin.getUsername();
        password = miVentanaLogin.getPassword();
        miUsuarioBuscado = miUsuarioDAO.buscarUsuarioUsername(username);
        if (miUsuarioBuscado != null) {
            if (username.equals(miUsuarioBuscado.getUsername())) {
                if (password.equals(miUsuarioBuscado.getPassword())) {
                    // Setea usuario principal del main
                    miUsuario.setDniUsuario(miUsuarioBuscado.getDniUsuario());
                    miUsuario.setUsername(username);
                    miUsuario.setPassword(password);
                    miUsuario.setRol(miUsuarioBuscado.getRol());
                    // Intercambia ventanas
                    miVentanaLogin.setVisible(false);
                    miVentanaPrincipal.setVisible(true);
                    miVentanaPrincipal.panelHome.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "La contraseña proporcionada es incorrecta");
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Usuario no registrado");
        }
        miVentanaLogin.limpiarCampos();
    }

    public void cerrarAplicacion() {
        System.exit(0);
    }
}
