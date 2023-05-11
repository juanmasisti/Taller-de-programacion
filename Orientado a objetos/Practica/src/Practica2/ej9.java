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
public class ej9 {
    public static void main(String[] args) {
        int asiento;
        System.out.println("-----Nuevo Micro-----");
        Micro micro = new Micro("ABC123", "Mar del Plata", "5:00");
        System.out.println("Ingrese el asiento a ocupar: ");
        asiento = Lector.leerInt();
        while (asiento != -1 && !micro.estaCompleto()) {
            if (micro.comprobarEnRango(asiento) && !micro.getEstadoAsiento(asiento)) {
                micro.ocuparAsiento(asiento);
                System.out.println("Asiento libre, puede ser ocupado");
            } else {
                System.out.println("Asiento Ocupado o Fuera de Rango");
                System.out.println("Existe el Asiento libre nro: " + micro.getPrimerAsientoLibre());
            }
            System.out.println("Ingrese el asiento a ocupar: ");
            asiento = Lector.leerInt();
        }
        System.out.println("Hay " + micro.getCantOcu() + " asientos ocupados");
    }
}
