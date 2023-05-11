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
public class ej6b {
    public static void main(String[] args) {
        double radio;
        String linea, relleno;
        System.out.println("-------Nuevo Circulo-------");
        System.out.println("Ingresar el radio del Circulo");
        radio = Lector.leerDouble();
        System.out.println("Ingresar el color de lineas del Circulo");
        linea = Lector.leerString();
        System.out.println("Ingresar el color de relleno del Circulo");
        relleno = Lector.leerString();
        Circulo2 cir = new Circulo2(radio, linea, relleno);
        System.out.println("Area del Circulo: ");
        System.out.println(cir.calcularArea());
        System.out.println("Perimetro del Circulo: ");
        System.out.println(cir.calcularPerimetro());
    }
}
