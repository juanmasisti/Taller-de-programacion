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
public class ej2 {
    public static void main(String[] args) {
        int i, j, x, tot = 1;
        // 1-9
        for (i=1; i<10; i++) {
            tot= tot * i;
            System.out.println(i + "! = " + tot);
        }
        tot = 1;
        // 1-9 Impares
        for (i=1; i<10; i++) {
            tot= tot * i;
            if (i % 2 == 1) 
                System.out.println(i + "! = " + tot);
        }
    }
}