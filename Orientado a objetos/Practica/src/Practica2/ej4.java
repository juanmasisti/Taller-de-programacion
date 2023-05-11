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
public class ej4 {
    public static void main(String[] args) {
        Circulo cir = new Circulo();
        System.out.println("-------Nuevo Circulo-------");
        System.out.println("Ingresar el radio del Circulo");
        cir.setRadio(Lector.leerDouble());
        System.out.println("Ingresar el color de lineas del Circulo");
        cir.setLinea(Lector.leerString());
        System.out.println("Ingresar el color de relleno del Circulo");
        cir.setRelleno(Lector.leerString());
        System.out.println("Area del Circulo: ");
        System.out.println(cir.calcularArea());
        System.out.println("Perimetro del Circulo: ");
        System.out.println(cir.calcularPerimetro());
    }
}
