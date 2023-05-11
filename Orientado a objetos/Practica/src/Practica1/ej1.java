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
import PaqueteLectura.Lector;
public class ej1 {
    public static void main(String[] args) {
        int i, x, tot = 1;
        System.out.println("Ingresar el numero a realizar el factorial: ");
        x = Lector.leerInt();
        for (i=x; i>0; i--) 
            tot= tot * i;
        System.out.println(x + "! = " + tot);
    }
}
