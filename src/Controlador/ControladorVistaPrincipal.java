package Controlador;

import Modelo.ModeloVistaPrincipal;
import Vista.VistaProducto;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorVistaPrincipal implements ActionListener{

    ModeloVistaPrincipal modeloVP;
    
    public ControladorVistaPrincipal(ModeloVistaPrincipal modeloVP){
        this.modeloVP = modeloVP;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        /**
         * Sirve para validar si una vista es nula y así saber a que metodos se puede acceder.
         */
        if(e.getActionCommand().equals(modeloVP.getVistaPrin().btnVistaProducto.getActionCommand())){ 
            VistaProducto vproducto = new VistaProducto();
            vproducto.setVisible(true);
            modeloVP.getVistaPrin().dispose();
        }    
    }
    
}
