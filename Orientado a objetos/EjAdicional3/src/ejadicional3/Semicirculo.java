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
public class Semicirculo extends Coro {
    //Estado
    public Persona[] coristas;
    public int dimL;

    //Constructor
    public Semicirculo(Persona director, int cantCoristas) {
      super(director, cantCoristas);
      coristas = new Persona[cantCoristas];
      dimL = 0;
    }

    //Comportamiento
    public void agregarCorista(Persona corista) {
      if (dimL<super.cantCoristas) {
        coristas[dimL] = corista;
        dimL++;
      }
    }

    public boolean isLleno() {
      if (dimL == super.cantCoristas) 
        return true;
      else
        return false;
    }

    public boolean isBienFormado() {
      boolean bienFormado = true;
      int i = 0;
      while ((i<dimL) & (bienFormado)) {
        if(coristas[i].valor < coristas[i+1].valor) 
          bienFormado = false;
        i++;
      }
      return bienFormado;
    }

    public String toString() {
      String str = "";
      for (int i = 0; i<dimL; i++) {
        str += coristas[i].toString();
      }
      return "-----Director-----\n" + super.toString() + "-----Corista-----\n" + str;
    }
}
