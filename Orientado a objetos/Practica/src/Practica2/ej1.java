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
public class ej1 {
    public static void main(String[] args) {
        Triangulo tri = new Triangulo();
        System.out.println("-------Nuevo Triangulo-------");
        System.out.println("Ingresar los tres lados del Triangulo");
        tri.setLadoA(Lector.leerDouble());
        tri.setLadoB(Lector.leerDouble());
        tri.setLadoC(Lector.leerDouble());
        System.out.println("Ingresar el color de lineas del Triangulo");
        tri.setLinea(Lector.leerString());
        System.out.println("Ingresar el color de relleno del Triangulo");
        tri.setRelleno(Lector.leerString());
        System.out.println("Area del triangulo: ");
        System.out.println(tri.calcularArea());
        System.out.println("Perimetro del triangulo: ");
        System.out.println(tri.calcularPerimetro());
    }
}
