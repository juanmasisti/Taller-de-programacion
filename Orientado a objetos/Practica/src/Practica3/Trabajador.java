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
public class Trabajador extends Persona {
    //Estado
    private String tarea;

    //Constructor
    public Trabajador(String nombre, int DNI, int edad, String tarea) {
        super(nombre, DNI, edad);
        this.tarea = tarea;
    }

    //Comportamiento
    public void setTarea(String tarea) {
        this.tarea = tarea;
    }

    public String getTarea() {
        return tarea;
    }

    public String toString() {
        return super.toString() + " Soy " + tarea;
    }
}
