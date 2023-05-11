/*
 Programa que instancia un objeto libro e inicializa sus v.i.s enviando mensajes set#
 */
package Practica2;

/**
 *
 * @author vsanz
 */
import PaqueteLectura.Lector;
public class ej8 {

    public static void main(String[] args) {
        Libro libro = new Libro();
        String nombre, desc;
        System.out.println("-----Nuevo Libro-----");
        System.out.println("Titulo del libro: ");
        libro.setTitulo(Lector.leerString());
        System.out.println("Editorial del libro: ");
        libro.setEditorial(Lector.leerString());
        System.out.println("Año de edicion del libro: ");
        libro.setAñoEdicion(Lector.leerInt());
        System.out.println("Autor del libro: ");
        nombre = Lector.leerString();
        System.out.println("Descripcion del Autor: ");
        desc = Lector.leerString();
        libro.setPrimerAutor(new Autor(nombre, desc));
        System.out.println("ISBN del libro: ");
        libro.setISBN(Lector.leerString());
        System.out.println("Precio del libro: ");
        libro.setPrecio(Lector.leerInt());
        System.out.println(libro.toString());
    }
    
}
