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
public class Circulo {
    //Estado
    private double radio;
    private String relleno, linea;

    //Comportamiento
        //Getters
    public double getRadio() {
        return radio;
    }

    public String getRelleno() {
        return relleno;
    }

    public String getLinea() {
        return linea;
    }
    
        //Setters
    public void setRadio(double radio) {
        this.radio = radio;
    }

    public void setRelleno(String relleno) {
        this.relleno = relleno;
    }

    public void setLinea(String linea) {
        this.linea = linea;
    }
    
        //Metodos
    public double calcularArea() {
        return Math.PI * radio * radio;
    }

    public double calcularPerimetro() {
        return Math.PI * 2 * radio;
    }
    
}
