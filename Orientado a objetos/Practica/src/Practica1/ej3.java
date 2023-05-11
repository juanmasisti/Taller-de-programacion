package Practica1;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Antonio
 */
import PaqueteLectura.Lector;
public class ej3 {
    public static void main(String[] args) {
        int i , x;
        double tot = 0, mayor = 0;
        double prom;
        double [] alturas = new double[15]; 
        System.out.println("Ingresar las 15 alturas de los jugadores en cm: ");
        for (i = 0; i<15; i++) {
            alturas[i] = Lector.leerDouble();
            tot = tot + alturas[i];
        }
        // Altura promedio
        prom = (double) tot/15;
        System.out.println("La altura promedio es: " + prom + "cm");
        for (i = 0; i<15; i++) {
            if (alturas[i] > prom)
                mayor++; 
        }
        System.out.println("Los jugadores con altura mayor al promedio son: " + mayor);
    }
}