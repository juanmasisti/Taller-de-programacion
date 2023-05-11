/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejadicional1;

/**
 *
 * @author Antonio
 */
public class Subsidio {
    //Estado
    public double monto;
    public String motivo;
    public boolean otorgado;

    //Constructor
    public Subsidio(double monto, String motivo) {
        this.monto = monto;
        this.motivo = motivo;
        otorgado = false; 
    }

    //Comportamiento
    public double getMonto() {
        return monto;
    }

    public String getMotivo() {
        return motivo;
    }

    public boolean isOtorgado() {
        return otorgado;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public void setOtorgado(boolean otorgado) {
        this.otorgado = otorgado;
    }
    

}
