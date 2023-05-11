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
public class ej6a {
    public static void main(String[] args) {
        double a, b, c;
        String linea, relleno;
        System.out.println("-------Nuevo Triangulo-------");
        System.out.println("Ingresar los tres lados del Triangulo");
        a = Lector.leerDouble();
        b = Lector.leerDouble();
        c = Lector.leerDouble();
        System.out.println("Ingresar el color de lineas del Triangulo");
        linea = Lector.leerString();
        System.out.println("Ingresar el color de relleno del Triangulo");
        relleno = Lector.leerString();
        Triangulo2 tri = new Triangulo2(a, b, c, linea, relleno);
        System.out.println("Area del triangulo: ");
        System.out.println(tri.calcularArea());
        System.out.println("Perimetro del triangulo: ");
        System.out.println(tri.calcularPerimetro());
    }
}
