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
public class Proyecto {
    //Estado
    public String nombre;
    public int codigo;
    public String nombreD;
    public String apellidoD;
    public Investigador[] investigadores;
    private int dimL;
    
    //Constructor
    public Proyecto(String nombre, int codigo) {
        this.nombre = nombre;
        this.codigo = codigo;
        investigadores = new Investigador[50];
        dimL = 0;
    }

    public Proyecto(String nombre, int codigo, String nombreD, String apellidoD) {
      this.nombre = nombre;
      this.codigo = codigo;
      this.nombreD = nombreD;
      this.apellidoD = apellidoD;
      investigadores = new Investigador[50];
      dimL = 0;
  }

    //Comportamiento
      //Setters y Getters
    public String getNombre() {
        return nombre;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNombreD() {
        return nombreD;
    }

    public String getApellidoD() {
        return apellidoD;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setNombreD(String nombreD) {
        this.nombreD = nombreD;
    }

    public void setApellidoD(String apellidoD) {
        this.apellidoD = apellidoD;
    }
    
    //Modulos
    public void agregarInvestigador(Investigador inv) {
        investigadores[dimL] = inv;
        dimL++;
    }

    public double dineroTotalOtorgado() {
      double dinero = 0;
      for (int i = 0; i<dimL; i++) 
        for (int j = 0; j<investigadores[i].getDiml(); j++)
          if (investigadores[i].subsidios[j].isOtorgado() )
            dinero += investigadores[i].subsidios[j].getMonto(); 
      return dinero;
    }

    public int cantidadDeSubsidios(String nombre, String apellido) {
      for (int i = 0; i<dimL; i++)
        if ((investigadores[i].getNombre().equals(nombre)) && (investigadores[i].getApellido().equals(apellido)))
          return investigadores[i].getDiml();
      return 0;
    }

    public int otorgarTodos(String nombre, String apellido) {
      for (int i = 0; i<dimL; i++)
        if ((investigadores[i].getNombre().equals(nombre)) && (investigadores[i].getApellido().equals(apellido)))
          for (int j = 0; j< investigadores[i].getDiml(); j++)
            investigadores[i].subsidios[j].setOtorgado(true);
      return 0;
    }

    public String toString() {
      String invS = "";
      for (int i = 0; i < dimL; i++)
        invS += investigadores[i].toString();
      return "-----------------------------------------\n" +
      "Nombre del Proyecto: " + nombre + "\n" + 
      "Nombre del director: " + nombreD + "\n" +
      "Apellido del director: " + apellidoD + "\n" +
      "Total de dinero otorgado: " + dineroTotalOtorgado() + "\n" +  
      "-----Investigadores-----\n" + 
      invS + "\n";
    }
}
