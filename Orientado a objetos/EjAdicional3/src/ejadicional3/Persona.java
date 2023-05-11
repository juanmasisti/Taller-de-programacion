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
public class Persona {
    //Estado
    public String nombre;
    public int dni;
    public int edad;
    public int valor;
    
    //Constructor
    public Persona(String nombre, int dni, int edad, int valor) {
      this.nombre = nombre;
      this.dni = dni;
      this.edad = edad;
      this.valor = valor;
    }

    //Comportamiento
    public String getNombre() {
        return nombre;
    }

    public int getDni() {
        return dni;
    }

    public int getEdad() {
        return edad;
    }

    public int getValor() {
        return valor;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }
    
    public String toString() {
      return "Su nombre es: " + nombre + "\n" +
      "Su dni es: " + dni + "\n" +
      "Su edad es: " + edad + "\n" + 
      "Su Antiguedad/Tono fundamental es: " + valor + "\n";
    }
}
