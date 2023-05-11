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
public class Investigador {
    //Estado
    public String nombre;
    public String apellido;
    public int categoria;
    public String especialidad;
    public Subsidio[] subsidios;
    public int dimL; 
    
    //Constructor
    public Investigador(String nombre, String apellido, int categoria, String especialidad) {
      this.nombre = nombre;
      this.apellido = apellido;
      this.categoria = categoria;
      this.especialidad = especialidad;
      subsidios = new Subsidio[5];
    }

    //Comportamiento
    public String getNombre() {
      return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public int getCategoria() {
      return categoria;
    }

    public String getEspecialidad() {
      return especialidad;
    }

    public int getDiml() {
      return dimL;
    }

    public void setNombre(String nombre) {
      this.nombre = nombre;
    }

    public void setApellido(String apellido) {
      this.apellido = apellido;
    }

    public void setCategoria(int categoria) {
      this.categoria = categoria;
    }

    public void setEspecialidad(String especialidad) {
      this.especialidad = especialidad;
    }
    
      //Modulos
    public void agregarSubsidio(Subsidio sub) {
      subsidios[dimL] = sub;
      dimL++;
    }

    public double subsidiosOtorgados() {
      double total = 0;
      for (int i = 0; i<dimL; i++)
        if (subsidios[i].isOtorgado())
          total += subsidios[i].getMonto();
      return total;
    }

    public String toString() {
      return "Nombre del Investigador: " + nombre + "\n" + 
      "Apellido del Investigador: " + apellido + "\n" +
      "Categoria del Investigador: " + categoria + "\n" +  
      "Dinero de subsidios otorgados: " + subsidiosOtorgados() + "\n";
    }

}
