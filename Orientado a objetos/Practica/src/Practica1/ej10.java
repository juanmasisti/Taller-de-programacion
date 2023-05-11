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
public class ej10 {
    public static void main(String[] args) {
        Persona [][] casting = new Persona[5][8];
        int dimLF = 0, dimLC = 0;
        System.out.println("Ingresar el nombre de la persona: ");
        String nombre = Lector.leerString();
        while ((!"ZZZ".equals(nombre)) && (dimLF < 5)) {
            dimLC = 0;
            while ((!"ZZZ".equals(nombre)) && (dimLC < 8)) {
                System.out.println("Ingresar la edad de la persona: ");
                int edad = GeneradorAleatorio.generarInt(100);
                System.out.println(edad);
                System.out.println("Ingresar el DNI de la persona: ");
                int dni = GeneradorAleatorio.generarInt(9999);
                System.out.println(dni);
                casting[dimLF][dimLC] = new Persona(nombre, dni, edad);
                System.out.println("Ingresar el nombre de la persona: ");
                nombre = Lector.leerString();
                dimLC++;
            }
            dimLF++;
        }
        int z, x;
        for (z = 0; z < dimLF-1; z++) {
            for (x = 0; x < 8; x++) {
                System.out.println("El nombre de la persona en el turno " + x + " del dia " + z + " es " + casting[z][x].getNombre());
            }
        }
        for (x = 0; x < dimLC; x++) {
            System.out.println("El nombre de la persona en el turno " + x + " del dia " + (dimLF-1) + " es " + casting[z][x].getNombre());
        }
    }
}