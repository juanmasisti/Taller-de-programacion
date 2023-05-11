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
public class ej12 {
    public static void main(String[] args) {
        Partido [] campeonato = new Partido[20];
        int dimL = 0;
        System.out.println("Ingresar el equipo visitante: ");
        String visitante = Lector.leerString();
        while (!"ZZZ".equals(visitante) && (dimL < 20)) {
            System.out.println("Ingresar el equipo local: ");
            String local = Lector.leerString();
            System.out.println("Ingresar los goles del visitante: ");
            int golVisitante = GeneradorAleatorio.generarInt(6);
            System.out.println(golVisitante);
            System.out.println("Ingresar los goles del local: ");
            int golLocal = GeneradorAleatorio.generarInt(6);
            System.out.println(golLocal);
            campeonato[dimL] = new Partido(local, visitante, golLocal, golVisitante);
            System.out.println("Ingresar el equipo visitante: ");
            visitante = Lector.leerString();
            dimL++;
        }
        int i, river = 0, golesB = 0, empates = 0;
        for (i = 0; i<dimL; i++) {
            if ("River".equals(campeonato[i].getGanador()))
                river++;
            if ("Boca".equals(campeonato[i].getLocal()))
                golesB = golesB + campeonato[i].getGolesLocal();
            if (campeonato[i].hayEmpate())
                empates++;
        }  
        System.out.println("La cantidad de partidos que gano River fue: " + river); 
        System.out.println("La cantidad de goles de Boca tuvo de local fue: " + golesB); 
        System.out.println("EL porcentaje de empates contra el total de partidos fue: " + (double) empates*100/dimL + "%"); 
    }
}