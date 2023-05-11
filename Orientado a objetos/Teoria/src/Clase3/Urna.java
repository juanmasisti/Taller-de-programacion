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
public abstract class Urna {
    //Estado
    private int numero, contEnBlanco;

    //Constructor
    public Urna(int U) {
        this.numero = U;
    }

    //Comportamiento
    public int getNumero() {
        return numero;
    }

    public int getContEnBlanco() {
        return contEnBlanco;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
    
    public void votarEnBlanco() {
        contEnBlanco++;
    }

    public abstract int calcularGanador();

    public abstract int calcularTotalVotos();
}
