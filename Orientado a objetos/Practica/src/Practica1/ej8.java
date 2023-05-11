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
public class ej8 {
    public static void main(String[] args) {
        Persona [] personas = new Persona[15];
        int i;
        for (i = 0; i<15; i++) {
            System.out.println("Ingresar el nombre de la persona: ");
            String nombre = Lector.leerString();
            System.out.println("Ingresar la edad de la persona: ");
            int edad = GeneradorAleatorio.generarInt(100);
            System.out.println("Ingresar el DNI de la persona: ");
            int dni = GeneradorAleatorio.generarInt(9999);
            personas[i] = new Persona(nombre, dni, edad);
        }
        int cant65 = 0;
        Persona min = new Persona();
        min.setDNI(9999);
        for (i = 0; i<15; i++) {
            if (personas[i].getEdad() > 65)
                cant65++;
            if (personas[i].getDNI() < min.getDNI())
                min = personas[i];
        }
        System.out.println("La cantidad de gente mayor a 65 años es " + cant65);
        System.out.println("La persona con menor DNI es: " + min.toString());
    }
}