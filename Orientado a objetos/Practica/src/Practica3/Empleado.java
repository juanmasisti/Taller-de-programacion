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
public abstract class Empleado {
    //Estado
    private String nombre;
    private double sueldo;
    
    //Constructor
    public Empleado(String nombre, double sueldo) {
        this.nombre = nombre;
        this.sueldo = sueldo;
    }

    //Comportamiento
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    public String getNombre() {
        return nombre;
    }

    public double getSueldo() {
        return sueldo;
    }
    
    public abstract double calcularSueldoACobrar();

    public String toString() {
        return "Nombre: " + nombre + "\n" + "Sueldo: $" + calcularSueldoACobrar();
    }
}
