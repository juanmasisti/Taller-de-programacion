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
public class Hileras extends Coro {
    //Estado
    public Persona[][] coristas;
    public int cantCoristasF;
    public int cantCoristasC;
    public int dimF;
    public int dimC;

    //Constructor
    public Hileras(Persona director, int cantCoristasF, int cantCoristasC) {
      super(director, cantCoristasF*cantCoristasC);
      this.cantCoristasF = cantCoristasF;
      this.cantCoristasC = cantCoristasC;
      coristas = new Persona[cantCoristasF][cantCoristasC];
      dimF = 0;
      dimC = 0;
    }

    //Comportamiento
    public void agregarCorista(Persona corista) {
      if (dimF < cantCoristasF) {
        if (dimC == cantCoristasC) {
          dimF++;
          dimC = 0;
        } 
        coristas[dimF][dimC] = corista;
        dimC++;
      }
    }

    public boolean isLleno() {
      if ((dimF == cantCoristasF) & (dimC == cantCoristasC)) 
        return true;
      else
        return false;
    }

    public boolean isBienFormado() {
      boolean bienFormado = true;
      int i = 0;
      int j = 0;
      while ((i<cantCoristasF-1) & (bienFormado)) {
        while ((j<cantCoristasC-1) & (bienFormado)) {
          if(coristas[i][j].valor != coristas[i][j+1].valor) 
            bienFormado = false;
          j++;
        }
        if (coristas[i][j-1].valor >= coristas[i+1][j-1].valor)
          bienFormado = false;
        i++;
        j = 0;
      }
      return bienFormado;
    }

    public String toString() {
      String str = "";
      for (int i = 0; i<cantCoristasF; i++) {
        for (int j = 0; j<cantCoristasC; j++) {
          str += coristas[i][j].toString();
        }
      }
      return "-----Director-----\n" + super.toString() + "-----Coristas-----\n" + str;
    }
}
