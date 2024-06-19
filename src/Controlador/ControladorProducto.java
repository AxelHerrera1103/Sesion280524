package Controlador;

import Modelo.ModeloProducto;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ControladorProducto implements ActionListener{
    
    ModeloProducto modeloP;
    ArrayList<ModeloProducto> baseDatos = new ArrayList<>();
    
    public ControladorProducto (ModeloProducto modeloP){
         this.modeloP = modeloP;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        /**
         * Sirve para verificar que boton se está pulsando y así realizar la acción de cada uno.
         */
        if(e.getActionCommand().equals(modeloP.getVistaP().btnAgregarProducto.getActionCommand())){
            agregarProducto();
        }else if(e.getActionCommand().equals(modeloP.getVistaP().btnBuscar.getActionCommand())){
            buscarProducto();
        }
    }
    /**
     * Este método sirve para poder agregar un producto a la base de datos, en este caso un ArryList.
     */
    public void agregarProducto(){
        /**
         * Nos sirve para que cuando haya un error se pueda mandar un mensaje a la vista, y así mismo un mensaje si es que todo salió bien.
         */
        try {
            ModeloProducto producto = new ModeloProducto();
            producto.setCodigo(modeloP.getVistaP().ingresoCodigo.getText());
            producto.setNombre(modeloP.getVistaP().ingresoNombre.getText());
            producto.setCantidad(Integer.parseInt(modeloP.getVistaP().ingresoCantidad.getText()));
            producto.setPrecio(Double.parseDouble(modeloP.getVistaP().ingresoPrecio.getText()));

            baseDatos.add(producto);
            limpiarProducto();
            mostrarMensaje("Producto Agregado con éxito", "Agregar Productos", JOptionPane.INFORMATION_MESSAGE);
        }catch(Exception ex){
            mostrarMensaje("Solo se permiten numeros enteros en la cantidad y numeros decimales en el precio.", "Error Agregar Producto", JOptionPane.ERROR_MESSAGE);
            modeloP.getVistaP().ingresoCantidad.setText("0");
            modeloP.getVistaP().ingresoPrecio.setText("0");
        }
    }
    /**
     * Este método sirve para poder buscar un producto dentro de nuestra base de datos, en este caso un ArrayList.
     */
    public void buscarProducto(){
        /**
         * Se utiliza para poder recorrer el tamaño de un ArrayList sin un tamaño predeterminado
         */
        for(int i = 0; i < baseDatos.size(); i++){
            /**
             * Se valida si el codigo encontrado en el ArrayList es igual al codigo ingresado por el usuario.
             */
            if(baseDatos.get(i).getCodigo().equals(modeloP.getVistaP().ingresoCodigoB.getText())){
                modeloP.getVistaP().salidaNombre.setText(baseDatos.get(i).getNombre());
                modeloP.getVistaP().salidaCantidad.setText(String.valueOf(baseDatos.get(i).getCantidad()));
                modeloP.getVistaP().salidaPrecio.setText(String.valueOf(baseDatos.get(i).getPrecio()));
            }
            modeloP.getVistaP().ingresoCodigoB.setEditable(true);
        }
    
    }
    /**
     * Este método sirve para poder limpiar los cuadros de texto de la interfaz.
     */
    public void limpiarProducto(){
    modeloP.getVistaP().ingresoCodigo.setText("");
    modeloP.getVistaP().ingresoNombre.setText("");
    modeloP.getVistaP().ingresoCantidad.setText("");
    modeloP.getVistaP().ingresoPrecio.setText("");
    
    }
    /**
     * Este metodo sirve para facilitar la creación de un mensaje en un JOptionPane.
     * @param mensaje
     * @param titulo
     * @param tipoMensaje 
     */
    public void mostrarMensaje(String mensaje, String titulo, int tipoMensaje){
        JOptionPane.showMessageDialog(null, mensaje, titulo, tipoMensaje);
    }
    
}
 