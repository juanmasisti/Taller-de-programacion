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
public class Circulo extends Figura {
    //Estado 
    private double radio;

    //Constructor
    public Circulo(String coloR, String colorL, double radio) {
        super(coloR, colorL);
        this.radio = radio;
    }

    //Comportamiento
    public void setRadio(double radio) {
        this.radio = radio;
    }

    public double getRadio() {
        return radio;
    }

    public double calcularArea() {
        return Math.PI*radio*radio;
    }

    public double calcularPerimetro() {
        return Math.PI*radio*2;
    }

    public String toString() {
        return super.toString() + "Radio: " + radio;
    }   
}
