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
public class ej3 {
    public static void main(String[] args) {
        Entrenador entre = new Entrenador(); 
        System.out.println("------Nuevo Entrenador------");
        System.out.println("Ingrese el nombre del entrenador: ");
        entre.setNombre(Lector.leerString());
        System.out.println("Ingrese el sueldo basico del entrenador: ");
        entre.setSueldo(Lector.leerDouble());
        System.out.println("Ingrese la cantidad de campeonatos ganados del entrenador: ");
        entre.setCantGan(Lector.leerInt());
        System.out.println("------Sueldo total del entrenador------");
        System.out.println(entre.calcularSueldoACobrar() + "$");
    }
}
