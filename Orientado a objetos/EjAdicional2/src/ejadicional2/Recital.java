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
public abstract class Recital {
    //Estado
    public String nombre;
    public String[] listaTemas;
    public int dimL;
    public boolean terminar;
    
    //Constructor
    public Recital(String nombre, int cantTemas) {
      this.nombre = nombre;
      listaTemas = new String[cantTemas];
      dimL = 0;
    }

    //Comportamiento
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public void agregarTema(String tema) {
       listaTemas[dimL] = tema;
       dimL++;
    }

    public void actuar() {
      for (int i = 0; i<dimL; i++) {
        System.out.println("Y ahora tocaremos..." + listaTemas[i] + "\n");
      }
      terminar = true;
    }

    public abstract boolean finalizado();

    public abstract int calcularCosto();
}
