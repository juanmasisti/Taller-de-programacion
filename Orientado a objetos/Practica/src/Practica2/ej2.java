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
public class ej2 {
    public static void main(String[] args) {
        double pesoKg, valorKg;
        Balanza bal = new Balanza(); 
        bal.iniciarCompra();
        System.out.println("------Nuevo Producto------");
        System.out.println("Ingrese el peso del producto: ");
        pesoKg = Lector.leerDouble();
        while (pesoKg != 0) {
            System.out.println("Ingrese el valor por peso del producto: ");
            valorKg = Lector.leerDouble();
            bal.registrarProducto(pesoKg, valorKg);
            System.out.println("------Nuevo Producto------");
            System.out.println("Ingrese el peso del producto: ");
            pesoKg = Lector.leerDouble();
        }
        System.out.println("------Resumen de la compra------");
        System.out.println(bal.devolverResumenDeCompra());
    }
}
