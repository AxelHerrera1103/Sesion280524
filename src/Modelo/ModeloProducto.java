package Modelo;

import Vista.VistaProducto;

public class ModeloProducto {
    
    private String nombre;
    private String codigo;
    private int cantidad;
    private double precio;
    private VistaProducto vistaP;

    public ModeloProducto() {
    }

    public ModeloProducto(VistaProducto vistaP) {
        this.vistaP = vistaP;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public VistaProducto getVistaP() {
        return vistaP;
    }

    public void setVistaP(VistaProducto vistaP) {
        this.vistaP = vistaP;
    }
    
    
}
