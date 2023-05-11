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
public class ej1 {
    public static void main(String[] args) {
        int patente;
        GeneradorAleatorio.iniciar();
        patente = GeneradorAleatorio.generarInt(10);
        while (patente != 0) {
            System.out.println(patente);
            if (patente % 2 == 0) 
                System.out.println("Tiene permitido el paso");
            else
                System.out.println("No Tiene permitido el paso");
            patente = GeneradorAleatorio.generarInt(10);
        }
    }
}
