/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejadicional3;

/**
 *
 * @author Antonio
 */
import PaqueteLectura.Lector;
public class EjAdicional3 {
    /**
     * @param args the command line arguments
     */
  public static void main(String[] args) {
    Coro[] coros = new Coro[4];
    for (int i = 0; i<4; i++) {
      System.out.println("Ingresar el tipo de Coro");
      String tipo = Lector.leerString();
			System.out.println("Ingresar el nombre del Director");
			String nombre = Lector.leerString();
			System.out.println("Ingresar el dni del Director");
			int dni = Lector.leerInt();
			System.out.println("Ingresar la edad del Director");
			int edad = Lector.leerInt();
			System.out.println("Ingresar la antiguedad del Director");
			int antiguedad = Lector.leerInt();
			Persona director = new Persona(nombre, dni, edad, antiguedad);
		  if (tipo.equals("Hileras")) {
				System.out.println("Ingresar la cantidad de Coristas por Fila");
				int cantCoristaF = Lector.leerInt();
				System.out.println("Ingresar la cantidad de Coristas por Columna");
				int cantCoristaC = Lector.leerInt();
				coros[i] = new Hileras(director, cantCoristaF, cantCoristaF);
				for (int j = 0; j<cantCoristaF*cantCoristaC; j++) {
					System.out.println("Ingresar el nombre del Corista");
					nombre = Lector.leerString();
					System.out.println("Ingresar el dni del Corista");
					dni = Lector.leerInt();
					System.out.println("Ingresar la edad del Corista");
					edad = Lector.leerInt();
					System.out.println("Ingresar el Tono Fundamental del Corista");
					int tonoFundamental = Lector.leerInt();
					Persona corista = new Persona(nombre, dni, edad, tonoFundamental);
					coros[i].agregarCorista(corista);
				}
			} else {
				System.out.println("Ingresar la cantidad de Coristas");
				int cantCorista = Lector.leerInt();
				coros[i] = new Semicirculo(director, cantCorista);
				for (int j = 0; j<cantCorista; j++) {
					System.out.println("Ingresar el nombre del Corista");
					nombre = Lector.leerString();
					System.out.println("Ingresar el dni del Corista");
					dni = Lector.leerInt();
					System.out.println("Ingresar la edad del Corista");
					edad = Lector.leerInt();
					System.out.println("Ingresar el Tono Fundamental del Corista");
					int tonoFundamental = Lector.leerInt();
					Persona corista = new Persona(nombre, dni, edad, tonoFundamental);
					coros[i].agregarCorista(corista);
				}
			}
    }
		for (int i = 0; i<4; i++) {
			System.out.println("¿El coro esta bien formado? " + coros[i].isBienFormado());
			System.out.println(coros[i].toString());
		}
	}   
}
