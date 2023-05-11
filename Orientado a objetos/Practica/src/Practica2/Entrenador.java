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
public class Entrenador {
    //Estado
    private String nombre;
    private double sueldo;
    private int cantGan;

    //Comportamiento
        //Getters
    public String getNombre() {
        return nombre;
    }

    public double getSueldo() {
        return sueldo;
    }

    public int getCantGan() {
        return cantGan;
    }

        //Setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    public void setCantGan(int cantGan) {
        this.cantGan = cantGan;
    }

        //Metodos
    public double calcularSueldoACobrar() {
        int plus;

        if (cantGan == 0) {
            plus = 0;
        } else if(cantGan < 5) {
            plus = 5000;
        } else if ( cantGan < 11) {
            plus = 30000;
        } else {
            plus = 50000;
        }

        return sueldo + plus;
    }
    
}
