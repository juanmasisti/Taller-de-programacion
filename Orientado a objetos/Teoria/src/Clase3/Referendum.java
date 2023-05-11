/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clase3;

/**
 *
 * @author Antonio
 */
public class Referendum extends Urna {
    //Estado
    private int cantAFavor, cantEnContra;

    //Constructor
    public Referendum(int U) {
        super(U);
    }

    //Comportamiento
    public int getCantAFavor() {
        return cantAFavor;
    }

    public int getCantEnContra() {
        return cantEnContra;
    }

    public void votarAFavor() {
        cantAFavor++;
    }

    public void votarEnContra() {
        cantEnContra++;
    }

    public int calcularGanador() {
        if (cantAFavor>cantEnContra)
            return 1;
        else if (cantEnContra>cantAFavor) 
            return 0;
        else
            return -1;
    }

    public int calcularTotalVotos() {
        return cantAFavor + cantEnContra + getContEnBlanco();
    }
}
