package Clase1;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Antonio
 */
import PaqueteLectura.GeneradorAleatorio;
import PaqueteLectura.Lector;
public class ej2 {
    public static void main(String[] args) {
        int patente, piso, plaza;
        boolean [][] estacionamiento = new boolean[5][10];
        GeneradorAleatorio.iniciar();
        patente = GeneradorAleatorio.generarInt(10);
        int i, j;
        for (i=0; i<5; i++) 
            for (j=0; j<10; j++)
                estacionamiento[i][j] = false;
        while (patente != 0) {
            System.out.println(patente);
            if (patente % 2 == 0) {
                System.out.println("Tiene permitido el paso");
                // A
                System.out.println("Ingresar Piso del estacionamiento: ");
                piso = Lector.leerInt();
                System.out.println("Ingresar Plaza del estacionamiento: ");
                plaza = Lector.leerInt();
                estacionamiento[piso][plaza] = true;
            }
            else
                System.out.println("No Tiene permitido el paso");
            patente = GeneradorAleatorio.generarInt(10);
        }
        // B
        int cantAuto, cantAutoMax, pisoMax;
        cantAutoMax = -1;
        pisoMax = -1;
        cantAuto = 0;
        for (i=0; i<5; i++) {
            for (j=0; j<10; j++)
                if (estacionamiento[i][j]) 
                    cantAuto++;
            if (cantAuto > cantAutoMax){
                pisoMax = i;
                cantAutoMax = cantAuto;
            }
            cantAuto = 0;
        }
        System.out.println("El piso mayormente ocupado es el: " + pisoMax);
    }
}
