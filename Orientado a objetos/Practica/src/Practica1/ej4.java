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
public class ej4 {
    public static void main(String[] args) {
        int [][] matriz = new int[10][10];
        int [] vector = new int[10];
        int i, j, x, sum = 0, posF = 0, posC = 0;
        boolean encontro = false;

        // Generar
        GeneradorAleatorio.iniciar();
        for (i = 0; i<10; i++)
            for (j = 0; j<10; j++) 
                matriz[i][j] = GeneradorAleatorio.generarInt(201);

        // Imprimir Matriz 
        for (i = 0; i<10; i++) {
            for (j = 0; j<10; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }

        //Suma filas 2-9, columnas 0-3
        for (i = 2; i<10; i++) {
            for (j = 0; j<4; j++) {
                sum = sum + matriz[i][j];
            }
        }
        System.out.println("La suma de todos los elementos almacenados entre las filas 2 y 9 y las columnas 0 y 3 es: " + sum);

        // Vector con suma
        for (j = 0; i<10; i++) {
            vector[i] = 0;
            for (j = 0; j<10; j++) {
                vector[i] = vector[i] + matriz[i][j];
            }
        }

        // Encontrar valor
        System.out.println("Ingresar elemento para indicar si es parte de la Matriz: ");
        x = Lector.leerInt();
        i = 0;
        boolean esta = false;
        while ((!esta) && (i<10))  {
            j = 0;
            while ((!esta) && (j<10)) {
                if (matriz[i][j] == x) {
                    posF = i;
                    posC = j;
                    esta = true;
                } else
                    j++;
            }
            i++;
        }
        if (esta)
            System.out.println("El elemento se encuentra en la fila: " + posF + " y la columna " + posC);
        else
            System.out.println("No se encontro el elemento");
    }
}