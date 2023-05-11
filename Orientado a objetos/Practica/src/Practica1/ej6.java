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
import PaqueteLectura.GeneradorAleatorio;
import PaqueteLectura.Lector;
public class ej6 {
    public static void main(String[] args) {
        GeneradorAleatorio.iniciar();
        int [] operaciones = new int[5];
        int i, oper;
        for (i = 0; i<5; i++)
            operaciones[i] = 0;
        System.out.println("Indicar la operacion a realizar: ");
        oper = GeneradorAleatorio.generarInt(6);
        while (oper != 5) {
            operaciones[oper]++;
            System.out.println("Indicar la operacion a realizar: ");
            oper = GeneradorAleatorio.generarInt(6);
        }
        int max = -1, maxI = -1; 
        for (i = 0; i<5; i++)
            if (operaciones[i] > max){
                max = operaciones[i];
                maxI = i;
            }
        for (i = 0; i<5; i++)
        System.out.println("La operacion " + i + " tuvo " + operaciones[i] + " clientes");
        System.out.println("La operacion " + i + " fue la mas concurrida");
    }
}