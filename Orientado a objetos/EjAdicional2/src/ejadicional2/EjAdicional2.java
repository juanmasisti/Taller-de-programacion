/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejadicional2;

/**
 *
 * @author Antonio
 */
import PaqueteLectura.Lector;
public class EjAdicional2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("-----Evento Ocasional-----");
        System.out.println("Ingresar el nombre de la banda");
        String nombreB = Lector.leerString();
        System.out.println("Ingresar la cantidad de temas");
        int cantTemas = Lector.leerInt();
        System.out.println("Ingresar el motivo de la banda");
        String motivo = Lector.leerString();
        System.out.println("Ingresar el nombre del Contratador");
        String nombre = Lector.leerString();
        System.out.println("Ingresar el dia del evento");
        int dia = Lector.leerInt();
        EventoOcasional eventoOcasional = new EventoOcasional(nombreB, cantTemas, motivo, nombre, dia);
        for (int i = 0; i<cantTemas; i++){
            System.out.println("Ingresar el tema a tocar");
            String tema = Lector.leerString();
            eventoOcasional.agregarTema(tema);
        }
        System.out.println("El costo del Evento Ocasional es: " + eventoOcasional.calcularCosto());
        eventoOcasional.actuar();
        System.out.println("-----Gira-----");
        System.out.println("Ingresar el nombre de la banda");
        nombreB = Lector.leerString();
        System.out.println("Ingresar la cantidad de temas");
        cantTemas = Lector.leerInt();
        System.out.println("Ingresar el nombre del evento");
        nombre = Lector.leerString();
        System.out.println("Ingresar la cantidad de fechas");
        int cantFechas = Lector.leerInt();
        Gira gira = new Gira(nombreB, cantTemas, nombre, dia);
        for (int i = 0; i<cantFechas; i++){
            System.out.println("Ingresar la ciudad de la fecha");
            String ciudad = Lector.leerString();
            System.out.println("Ingresar el dia de la fecha");
            dia = Lector.leerInt();
            Fecha fecha = new Fecha(ciudad, dia);
            gira.agregarFecha(fecha);
        }
        for (int i = 0; i<cantTemas; i++){
            System.out.println("Ingresar el tema a tocar");
            String tema = Lector.leerString();
            gira.agregarTema(tema);
        }
        System.out.println("El costo de la Gira es: " + gira.calcularCosto());
        for (int i = 0; i < cantFechas; i++) {
            gira.actuar();
        }
    }
    
}
