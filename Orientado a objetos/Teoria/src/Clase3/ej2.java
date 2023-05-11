/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clase3;

/**
 *
 * @author Antonio
 */
import PaqueteLectura.Lector; 
public class ej2 {
    public static void main(String[] args) {
        int lista, voto, ganadorR, ganadorE;
        Electoral urnaE = new Electoral(203, 5);
        Referendum urnaR = new Referendum(203);
        System.out.println("-----Nueva Votacion-----");
        System.out.println("Ingresar el numero de DNI: ");
        int DNI = Lector.leerInt();
        while (DNI != 0) {
            System.out.println("/Voto Electoral/");
            System.out.println("Ingresar el numero de lista a votar: ");
            lista = Lector.leerInt();
            if (urnaE.validarNumeroDeLista(lista)) 
                urnaE.votarPorLista(lista);
            else
                urnaE.votarEnBlanco();
            System.out.println("/Voto Referendum/");
            System.out.println("Ingresar Si votar en Contra-AFavor-Blanco: ");
            voto = Lector.leerInt();
            if (voto > 0)
                urnaR.votarAFavor();
            else if (voto < 0)
                urnaR.votarEnContra();
            else
                urnaR.votarEnBlanco();
            System.out.println("-----Nueva Votacion-----");
            System.out.println("Ingresar el numero de DNI: ");
            DNI = Lector.leerInt();
        }
        System.out.println("-----Resultados-----");
        System.out.println("/Voto Electoral/");
        ganadorE =  urnaE.calcularGanador();
        System.out.println("La lista ganadora en el voto electoral fue la: " + ganadorE);
        System.out.println("El porcentaje de votos sobre el total por parte de la lista ganadora fue: " + urnaE.devolverVotosPorLista(ganadorE)*100/urnaE.calcularTotalVotos() + "%");
        System.out.println("/Voto Referendum/");
        ganadorR = urnaR.calcularGanador();
        switch (ganadorR) {
            case 0:
                System.out.println("Se denego el Referendum");
                System.out.println("El porcentaje de votos sobre el total por parte de la opcion ganadora fue: " + urnaR.getCantEnContra()*100/urnaR.calcularTotalVotos() + "%");
                break;
            case 1: 
                System.out.println("Se aprobo el Referendum");
                System.out.println("El porcentaje de votos sobre el total por parte de la opcion ganadora fue: " + urnaR.getCantAFavor()*100/urnaR.calcularTotalVotos() + "%");
                break;
            case -1:
                System.out.println("Hubo un empate");
                break;
        }
    }
}
