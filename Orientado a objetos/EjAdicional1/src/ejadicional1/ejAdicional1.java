/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejadicional1;

/**
 *
 * @author Antonio
 */
import PaqueteLectura.Lector;
public class ejAdicional1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Proyecto proyecto = new Proyecto("Proyecto1", 1);
        for (int i = 0; i<2; i++) {
            System.out.println("Ingresar el nombre del Investigador");
            String nombre = Lector.leerString();
            System.out.println("Ingresar el apellido del Investigador");
            String apellido = Lector.leerString();
            System.out.println("Ingresar la categoria del Investigador");
            int categoria = Lector.leerInt();
            System.out.println("Ingresar la especialidad del Investigador");
            String especialidad = Lector.leerString();
            Investigador investigador = new Investigador(nombre, apellido, categoria, especialidad);
            for (int j = 0; j < 2; j++) {
                System.out.println("Ingresar el monto del Subsidio");
                double monto = Lector.leerDouble();
                System.out.println("Ingresar el motivo del Subsidio");
                String motivo = Lector.leerString();
                System.out.println("Ingresar si es otorgado o no");
                boolean otorgado = Lector.leerBoolean();
                Subsidio subsidio = new Subsidio(monto, motivo);
                subsidio.setOtorgado(otorgado);
                investigador.agregarSubsidio(subsidio);
            }
            proyecto.agregarInvestigador(investigador);
        }
        System.out.println(proyecto.toString());
    }
    
}
