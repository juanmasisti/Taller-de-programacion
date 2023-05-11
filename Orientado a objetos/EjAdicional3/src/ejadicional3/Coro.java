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
public abstract class Coro {
    //Estado
    public Persona director;
    public Persona corista;
    public int cantCoristas;

    //Constructor
    public Coro(Persona director, int cantCoristas) {
      this.director = director;
      this.cantCoristas = cantCoristas;
    }

    //Comportamiento
    public abstract void agregarCorista(Persona p);
    public abstract boolean isLleno();
    public abstract boolean isBienFormado();

    public String toString() {
      return director.toString() + "\n";
    }
}
