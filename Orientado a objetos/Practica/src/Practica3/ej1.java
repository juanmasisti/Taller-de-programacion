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
public class ej1 {
    public static void main(String[] args) {
        System.out.println("-----Triangulo-----");
        System.out.println("Ingresar sus 3 lados: ");
        double lado1 = Lector.leerDouble();
        double lado2 = Lector.leerDouble();
        double lado3 = Lector.leerDouble();
        System.out.println("Ingresar su color de relleno: ");
        String colorR = Lector.leerString();
        System.out.println("Ingresar su color de linea: ");
        String colorL = Lector.leerString();
        Triangulo triangulo = new Triangulo(colorR, colorL, lado1, lado2, lado3);
        System.out.println("-----Cuadrado-----");
        System.out.println("Ingresar su lado: ");
        lado1 = Lector.leerDouble();
        System.out.println("Ingresar su color de relleno: ");
        colorR = Lector.leerString();
        System.out.println("Ingresar su color de linea: ");
        colorL = Lector.leerString();
        Cuadrado cuadrado = new Cuadrado(lado1, colorR, colorL);
        System.out.println("-----Circulo-----");
        System.out.println("Ingresar su radio: ");
        double radio = Lector.leerDouble();
        System.out.println("Ingresar su color de relleno: ");
        colorR = Lector.leerString();
        System.out.println("Ingresar su color de linea: ");
        colorL = Lector.leerString();
        Circulo circulo = new Circulo(colorR, colorL, radio);
        System.out.println("-----Resultados-----");
        System.out.println("/Triangulo/");
        System.out.println(triangulo.toString());
        System.out.println("/Cuadrado/");
        System.out.println(cuadrado.toString());
        System.out.println("/Circulo/");
        System.out.println(circulo.toString());
    }
}
