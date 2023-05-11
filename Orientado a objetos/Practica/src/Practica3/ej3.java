/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practica3;

/**
 *
 * @author Antonio
 */
import PaqueteLectura.Lector;
public class ej3 {
    public static void main(String[] args) {
        System.out.println("-----Persona-----");
        System.out.println("Ingresar el nombre de la persona: ");
        String nombre = Lector.leerString();
        System.out.println("Ingresar el DNI de la persona: ");
        int DNI = Lector.leerInt();
        System.out.println("Ingresar la edad de la persona: ");
        int edad = Lector.leerInt();
        Persona persona = new Persona(nombre, DNI, edad);
        System.out.println("-----Trabajador-----");
        System.out.println("Ingresar el nombre del trabajador: ");
        nombre = Lector.leerString();
        System.out.println("Ingresar el DNI del trabajador: ");
        DNI = Lector.leerInt();
        System.out.println("Ingresar la edad del trabajador: ");
        edad = Lector.leerInt();
        System.out.println("Ingresar la tarea del trabajador");
        String tarea = Lector.leerString();
        Trabajador trabajador = new Trabajador(nombre, DNI, edad, tarea);
        System.out.println("-----Resultados-----");
        System.out.println("/Persona/");
        System.out.println(persona.toString());
        System.out.println("/Trabajador/");
        System.out.println(trabajador.toString());
    }
}