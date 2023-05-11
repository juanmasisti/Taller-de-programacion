/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practica2;

/**
 *
 * @author Antonio
 */
import PaqueteLectura.Lector;
public class ej7 {
    public static void main(String[] args) {
        String nombre;
        double sueldo;
        int cantGan;
        System.out.println("------Nuevo Entrenador------");
        System.out.println("Ingrese el nombre del entrenador: ");
        nombre = Lector.leerString();
        System.out.println("Ingrese el sueldo basico del entrenador: ");
        sueldo = Lector.leerDouble();
        System.out.println("Ingrese la cantidad de campeonatos ganados del entrenador: ");
        cantGan = Lector.leerInt();
        Entrenador2 entre = new Entrenador2(nombre, sueldo, cantGan); 
        System.out.println("------Sueldo total del entrenador------");
        System.out.println(entre.calcularSueldoACobrar() + "$");
    }
}
