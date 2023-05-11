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
import PaqueteLectura.GeneradorAleatorio;
import PaqueteLectura.Lector;
public class ej5 {
    public static void main(String[] args) {
        GeneradorAleatorio.iniciar();
        int [][] edificio = new int[8][4];
        int i, j, piso, oficina;
        for (i = 0; i<8; i++)
            for (j = 0; j<4; j++) 
                edificio[i][j] = 0;
        System.out.println("Indicar el piso a concurrir: ");
        piso = GeneradorAleatorio.generarInt(9) + 1;
        System.out.println(piso);
        while (piso != 9) {
            System.out.println("Indicar la oficina a concurrir: ");
            oficina = GeneradorAleatorio.generarInt(4);
            System.out.println(oficina);
            edificio[piso-1][oficina]++;
            System.out.println("Indicar el piso a concurrir: ");
            piso = GeneradorAleatorio.generarInt(9) + 1;
            System.out.println(piso);
        }
        for (i = 0; i<8; i++)
            for (j = 0; j<4; j++) 
                System.out.println("En la oficina " + j + " del piso " + (i+1) + " concurrieron " + edificio[i][j] + " persona/s");
    }
}