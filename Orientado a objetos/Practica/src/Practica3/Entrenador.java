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
public class Entrenador extends Empleado {
    //Estado
    private int cantCG;

    //Constructor
    public Entrenador(String nombre, double sueldo, int cantCG) {
        super(nombre, sueldo);
        this.cantCG = cantCG;
    }

    //Comportamiento
    public int getCantCG() {
        return cantCG;
    }

    public void setCantCG(int cantCG) {
        this.cantCG = cantCG;
    }

    public double calcularSueldoACobrar() {
        double sueldo = super.getSueldo();
        if (cantCG > 0 && cantCG <= 4)
            return sueldo + 5000;
        else if (cantCG > 4 && cantCG <= 10)
            return sueldo + 30000;
        else
            return sueldo + 50000;
    };
}
