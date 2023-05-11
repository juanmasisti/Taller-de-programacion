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
public class Balanza2 {
    // Estado 
    private double monto;
    private int cant;
    private String resumen;

    //Comportamiento
        //Metodos
    public void iniciarCompra() {
        monto = 0;
        cant = 0;
        resumen = "";
    }

    public void registrarProducto(Producto prod, double valorKg) {
        cant++;
        double mul = prod.getPesoEnKg() * valorKg;
        monto = monto + mul;
        resumen = resumen + prod.getDescripcion() + " " + mul + " pesos - ";
    }

    public double devolverMontoAPagar() {
        return monto;
    }

    public String devolverResumenDeCompra() {
        return resumen + "\n" + "Total a pagar " + monto + "$ por la compra de " + cant + " productos";    
    }
}
