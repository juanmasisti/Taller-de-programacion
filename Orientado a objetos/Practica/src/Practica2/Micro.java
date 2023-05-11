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
public class Micro {
    //Estado
    private String patente, destino, horaSa;
    private int cantOcu;
    private boolean [] asientos = new boolean[20];

    //Constructor
    public Micro(String patente, String destino, String horaSa) {
        this.patente = patente;
        this.destino = destino;
        this.horaSa = horaSa;
        cantOcu = 0;
    }

    //Metodos
        //Getters

    public String getPatente() {
        return patente;
    }

    public String getDestino() {
        return destino;
    }

    public String getHoraSa() {
        return horaSa;
    }

    public int getCantOcu() {
        return cantOcu;
    }
    
        //Setters
    public void setPatente(String patente) {
        this.patente = patente;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public void setHoraSa(String horaSa) {
        this.horaSa = horaSa;
    }

        //Metodos
    public boolean estaCompleto() {
        return cantOcu == 20;
    }

    public boolean comprobarEnRango(int num) {
        return (num >= 0 && num < 20);
    }

    public boolean getEstadoAsiento(int num) {
        return asientos[num];
    } 

    public void ocuparAsiento(int num) {
        asientos[num] = true;
        cantOcu++;
    }

    public void liberarAsiento(int num) {
        asientos[num] = false;
        cantOcu--;
    }

    public int getPrimerAsientoLibre() {
        int i = 0;
        while(i < 20 && asientos[i]) {
            i++;
        }
        return i;
    }
}
