/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practica3;

/**
 *
 * @author Antonio
 */
public class Jugador extends Empleado{
    //Estado
    private int numP, numG;
    
    //Constructor
    public Jugador(String nombre, double sueldo, int numP, int numG) {
        super(nombre, sueldo);
        this.numP = numP;
        this.numG = numG;
    }

    //Comportamiento
    public void setNumP(int numP) {
        this.numP = numP;
    }

    public void setNumG(int numG) {
        this.numG = numG;
    }

    public int getNumP() {
        return numP;
    }

    public int getNumG() {
        return numG;
    }

    public double calcularSueldoACobrar() {
        double sueldo = super.getSueldo();
        if (numG/numP > 0.5) 
            return sueldo*2;
        else
            return sueldo;
    };
}
