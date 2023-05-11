/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practica2;

/**
 *
 * @author Antonio
 */
public class Flota {
    //Estado
    Micro [] micros = new Micro[15];
    int dimL;

    //Construcor
    public Flota() {}

    //Metodos
    public boolean estaCompleto() {
        return dimL == 15;
    }

    public void agregarALaFlota(Micro micro) {
        micros[dimL] = micro;
        dimL++; 
    }

    private int getPosMicroPatente(String patente) {
        int i = 0;
        boolean esta = false;
        while (!esta && i < dimL) {
            if (micros[i].getPatente().equals(patente)) {
                esta = true;
            } else
                i++;
        }
        return i;
    }

    public boolean eliminarMicro(String patente) {
        int i = 0, pos;
        pos = this.getPosMicroPatente(patente);
        if (pos < dimL) {
            for (i = pos; i < dimL ; i++) 
                micros[i] = micros[i+1];
            dimL--;
            return true;
        }
        return false;
    }

    public Micro buscarMicroPatente(String patente) {
        int pos = this.getPosMicroPatente(patente); 
        if (pos < dimL) 
            return micros[pos];
        else
            return null;
    }

    public Micro buscarMicroDestino(String destino) {
        int i = 0;
        Micro m = null;
        boolean encontro = false;
        while (!encontro && i < dimL)
            if (micros[i].getDestino().equals(destino)) {
                m = micros[i];
                encontro = true;
            }
            else
                i++;
        return m;
    }
}
