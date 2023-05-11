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
public class ej2 {
    public static void main(String[] args) {
        System.out.println("-----Jugador-----");
        System.out.println("Ingrese el nombre: ");
        String nombre = Lector.leerString();
        System.out.println("Ingrese el sueldo basico del jugador: ");
        Double sueldo = Lector.leerDouble();
        System.out.println("Ingrese la cantidad de Partidos jugados: ");
        int cantP = Lector.leerInt();
        System.out.println("Ingrese la cantidad de Goles totales: ");
        int cantG = Lector.leerInt();
        Jugador jugador = new Jugador(nombre, sueldo, cantP, cantG);
        System.out.println("-----Entrenador-----");
        System.out.println("Ingrese el nombre: ");
        nombre = Lector.leerString();
        System.out.println("Ingrese el sueldo basico del Entrenador: ");
        sueldo = Lector.leerDouble();
        System.out.println("Ingrese la cantidad de Campeonatos ganados: ");
        int cantCG = Lector.leerInt();
        Entrenador entrenador = new Entrenador(nombre, sueldo, cantCG);
        System.out.println("-----Resultados-----");
        System.out.println("/Jugador/");
        System.out.println(jugador.toString());
        System.out.println("/Entrenador/");
        System.out.println(entrenador.toString());
    }
}