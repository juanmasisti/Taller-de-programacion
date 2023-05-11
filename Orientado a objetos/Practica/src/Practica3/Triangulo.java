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
public class Triangulo extends Figura {
    //Estado 
    private double lado1, lado2, lado3;

    //Constructor
    public Triangulo(String coloR, String colorL, double lado1, double lado2, double lado3) {
        super(coloR, colorL);
        this.lado1 = lado1;
        this.lado2 = lado2;
        this.lado3 = lado3;
    }

    //Comportamiento
    public void setLado1(double lado1) {
        this.lado1 = lado1;
    }

    public void setLado2(double lado2) {
        this.lado2 = lado2;
    }

    public void setLado3(double lado3) {    
        this.lado3 = lado3;
    }

    public double getLado1() {
        return lado1;
    }

    public double getLado2() {
        return lado2;
    }

    public double getLado3() {
        return lado3;
    }

    public double calcularArea() {
        double s = (lado1 + lado2 + lado3)/2;
        return Math.sqrt(s * (s - lado1) * (s - lado2) * (s - lado3));
    }

    public double calcularPerimetro() {
        return lado1+lado2+lado3;
    }

    public String toString() {
        return super.toString() + "Lado1: " + lado1 + "\n" + "Lado2: " + lado2 + "\n" + "Lado3: " + lado3;
    }   
}
