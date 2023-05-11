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
public class Balanza {
    // Estado 
    private double monto;
    private int cant;

    //Comportamiento
        //Metodos
    public void iniciarCompra() {
        monto = 0;
        cant = 0;
    }

    public void registrarProducto(double pesoKg, double valorKg) {
        cant++;
        monto = monto + (pesoKg*valorKg);
    }

    public double devolverMontoAPagar() {
        return monto;
    }

    public String devolverResumenDeCompra() {
        return "Total a pagar " + monto + "$ por la compra de " + cant + " productos";    
    }
}
