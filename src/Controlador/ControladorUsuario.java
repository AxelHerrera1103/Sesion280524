package Controlador;

import Modelo.ModeloUsuario;
import Vista.VistaLogin;
import Vista.VistaPrincipal;
import Vista.VistaRegistro;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ControladorUsuario implements ActionListener{
    
    private static ArrayList<ModeloUsuario> baseDatos = new ArrayList();
    ModeloUsuario modelo;
    public ControladorUsuario(ModeloUsuario modelo){
        this.modelo = modelo;
        /**
         * Sirve para validar si no existe ningun dato en la base de datos, y si es así le asigna un usurio y contraseña para poder acceder a la vista sin que se hayan agregado usuarios nuevos.
         */
        if(baseDatos.isEmpty()){
            baseDatos.add(new ModeloUsuario());
            baseDatos.get(0).setUsuario("axelhs");
            baseDatos.get(0).setPassword("12345");
        }
    }
    
    /**
     * Nos sirve para valirdad un usuario existe en una base de datos, en este caso un ArrayList.
     * @return 
     */
    public boolean validarUsuario(){
        boolean resutado = false;
        /**
         * Sirve para buscar dentro de la base de datos (ArrayList), recorreindo cada espacio sin un tamaño establecido. 
         */
        for (int i = 0; i < baseDatos.size(); i++){
            /**
             * Sirve para validar si el usuario y la contraseña encontrado es igual al usuario y contraseña ingresados por el usuario.
             */
            if(modelo.getVista().txtUsuario.getText().equals(baseDatos.get(i).getUsuario()) && 
                    String.valueOf(modelo.getVista().txtPassword.getPassword()).equals(baseDatos.get(i).getPassword())){
                resutado = true;
            }
        }
        return resutado;
    }
    /**
     * Nos sirve para registrar un usuario a la base de datos, en este caso en un ArrayList.
     */
    public void registrarUsuario(){
        /**
         * Sirve para validar que las contraseñas ingresadas por el usuario sean iguales.
         */
        if(String.valueOf(modelo.getVistaR().ingresoContraseñaRU.getPassword()).equals(String.valueOf(modelo.getVistaR().ingresoConfirmarContraseñaRU.getPassword()))){
            ModeloUsuario usuarioL = new ModeloUsuario();
            usuarioL.setUsuario(modelo.getVistaR().IngresoUsuarioRU.getText());
            usuarioL.setPassword(String.valueOf(modelo.getVistaR().ingresoContraseñaRU.getPassword()));

            baseDatos.add(usuarioL);
            JOptionPane.showMessageDialog(null, "Usurio registrado con exito", "Registro de usuario", JOptionPane.INFORMATION_MESSAGE);
            modelo.getVistaR().IngresoUsuarioRU.setText("");
            modelo.getVistaR().ingresoContraseñaRU.setText("");
            modelo.getVistaR().ingresoConfirmarContraseñaRU.setText("");
        }else{
            JOptionPane.showMessageDialog(null, "Contraseñas diferentes, favor de validad", "Registro de usuario", JOptionPane.ERROR_MESSAGE);
            modelo.getVistaR().IngresoUsuarioRU.setText("");
            modelo.getVistaR().ingresoContraseñaRU.setText("");
            modelo.getVistaR().ingresoConfirmarContraseñaRU.setText("");
        }
        System.out.println(modelo.getUsuario());
        System.out.println(modelo.getPassword());

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        /**
         * Sirve para validar si una vista es nula y así saber a que metodos se puede acceder.
         */
        if(modelo.getVistaR() == null){
            /**
             * Sirve para verificar que boton se está pulsando y así realizar la acción de cada uno.
             */
            if(e.getActionCommand().equals(modelo.getVista().btnIngresar.getActionCommand())){
                if(validarUsuario()){
                    VistaPrincipal vprincipal = new VistaPrincipal();
                    vprincipal.setVisible(true);

                }else{
                    System.out.println("No ingreso...");
                }
            }else if(e.getActionCommand().equals(modelo.getVista().btnIngresarRegistrarse.getActionCommand())){
                VistaRegistro vregistro = new VistaRegistro();
                vregistro.setVisible(true);}
        }else if(modelo.getVista() == null){
            /**
             * Sirve para verificar que boton se está pulsando y así realizar la acción de cada uno.
             */
            if(e.getActionCommand().equals(modelo.getVistaR().btnAgregarUsuario.getActionCommand())){
                registrarUsuario();
            }else if(e.getActionCommand().equals(modelo.getVistaR().btnRegresarLogin.getActionCommand())){
                VistaLogin vlogin = new VistaLogin();
                vlogin.setVisible(true);
            }
        }
    }   
}
