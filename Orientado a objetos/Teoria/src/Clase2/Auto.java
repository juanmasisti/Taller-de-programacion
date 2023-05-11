/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clase2;

public class Auto {
    // Estado interno
    private int patente;
    private String dueño;

    // Constructor
    public Auto() {
    }

    public Auto(String nombre, int patente) {
        dueño = nombre;
        this.patente = patente;
    }

    // Comportamiento
    public int getPatente() {
        return patente;
    }

    public String getDueño() {
        return dueño;
    }

    public void setPatente(int patente) {
        this.patente = patente;
    }

    public void setDueño(String dueño) {
        this.dueño = dueño;
    }

    @Override
    public String toString() {
        return "Patente: "+patente+ " Dueño: "+dueño; //To change body of generated methods, choose Tools | Templates.
    }

    
    
    
}