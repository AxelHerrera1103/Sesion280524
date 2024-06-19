package Modelo;

import Vista.VistaLogin;
import Vista.VistaRegistro;

public class ModeloUsuario {
    private String usuario;
    private String password;
    private String correo;
    private VistaLogin vista;
    private VistaRegistro vistaR;
    private String passwordC;
    
    public ModeloUsuario(){
        
    }
    
    public ModeloUsuario(VistaLogin vista){
        this.vista = vista;
    }

    public ModeloUsuario(VistaRegistro vistaR) {
        this.vistaR = vistaR;
    }

    public VistaLogin getVista() {
        return vista;
    }

    public void setVista(VistaLogin vista) {
        this.vista = vista;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public VistaRegistro getVistaR() {
        return vistaR;
    }

    public void setVistaR(VistaRegistro vistaR) {
        this.vistaR = vistaR;
    }

    public String getPasswordC() {
        return passwordC;
    }

    public void setPasswordC(String passwordC) {
        this.passwordC = passwordC;
    }
    
    
    
}
