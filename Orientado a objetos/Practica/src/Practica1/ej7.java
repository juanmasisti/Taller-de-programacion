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
public class ej7 {
    public static void main(String[] args) {
        System.out.println("Ingresar el nombre de la persona: ");
        String nombre = Lector.leerString();
        System.out.println("Ingresar la edad de la persona: ");
        int edad = Lector.leerInt();
        System.out.println("Ingresar el DNI de la persona: ");
        int dni = Lector.leerInt();
        Persona persona1 = new Persona(nombre, dni, edad);
        System.out.println(persona1.toString());
    }
}