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
public class ej11 {
    public static void main(String[] args) {
        String [] mensaje = new String[10];
        int i;
        for (i = 0; i<10; i++){
            System.out.println("Ingresar el string para el mensaje: ");
            String men = Lector.leerString();
            mensaje[i] = men;
        }
        System.out.println("El mensaje oculto es: ");
        for (i = 0; i<10; i++){
            System.out.print(mensaje[i].charAt(0));
        }
    }
}