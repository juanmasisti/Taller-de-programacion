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
public class ej3 {
    public static void main(String[] args) {
        int patente, i, j, piso, plaza;
        String dueño;
        Auto [][] estacionamiento = new Auto[5][10];
        for (i=0; i<5; i++) 
            for (j=0; j<10; j++)
                estacionamiento[i][j] = null;
        GeneradorAleatorio.iniciar();
        patente = GeneradorAleatorio.generarInt(5);
        while (patente != 0) {
            System.out.println(patente);
            if (patente % 2 == 0) {
                System.out.println("Tiene permitido el paso");
                // A
                System.out.println("Ingresar Piso del estacionamiento: ");
                piso = Lector.leerInt();
                System.out.println("Ingresar Plaza del estacionamiento: ");
                plaza = Lector.leerInt();
                System.out.println("Ingresar Dueño del estacionamiento: ");
                dueño = Lector.leerString();
                Auto auto = new Auto();
                auto.setPatente(patente);
                auto.setDueño(dueño);
                estacionamiento[piso][plaza] = auto;
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
                if (estacionamiento[i][j] != null) {
                    System.out.println(estacionamiento[i][j].toString());
                    cantAuto++;
                }
            if (cantAuto > cantAutoMax){
                pisoMax = i;
                cantAutoMax = cantAuto;
            }
            cantAuto = 0;
        }
        System.out.println("El piso mayormente ocupado es el: " + pisoMax);
    }
}
