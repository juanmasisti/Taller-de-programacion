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
public class ej10 {
    public static void main(String[] args) {
        String patente, destino, horaSa;
        System.out.println("-----Nueva Flota-----");
        Flota flota = new Flota();
        System.out.println("Ingrese la patente del Micro: ");
        patente = Lector.leerString();
        while (!patente.equals("ZZZ000") && !flota.estaCompleto()) {
            System.out.println("Ingrese el destino del Micro: ");
            destino = Lector.leerString();
            System.out.println("Ingrese el horario de salida del Micro: ");
            horaSa = Lector.leerString();
            flota.agregarALaFlota(new Micro(patente, destino, horaSa));
            System.out.println("Ingrese la patente del Micro: ");
            patente = Lector.leerString();
        }
        System.out.println("Ingrese patente de Micro a eliminar: ");
        patente = Lector.leerString();
        if (flota.eliminarMicro(patente)) 
            System.out.println("Eliminado correctamente");
        else
            System.out.println("No ha podido ser eliminado");
        Micro m = flota.buscarMicroPatente(patente);
        if (m == null)
            System.out.println("No ha sido encontrado");
        else
            System.out.println(m.getPatente());
        System.out.println("Ingrese el destino del Micro a buscar: ");
        destino = Lector.leerString();
        if (flota.buscarMicroDestino(destino) == null ) 
            System.out.println("Ese Micro no existe en la flota");
        else
            System.out.println("Su patente es " + flota.buscarMicroDestino(destino).getPatente());

    }
}
