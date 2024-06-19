package Modelo;

import Vista.VistaPrincipal;

public class ModeloVistaPrincipal {
    private VistaPrincipal vistaPrin;

    public ModeloVistaPrincipal() {
    }

    public ModeloVistaPrincipal(VistaPrincipal vistaPrin) {
        this.vistaPrin = vistaPrin;
    }

    public VistaPrincipal getVistaPrin() {
        return vistaPrin;
    }

    public void setVistaPrin(VistaPrincipal vistaPrin) {
        this.vistaPrin = vistaPrin;
    }
    
    
}
