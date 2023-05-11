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
public class Gira extends Recital {
    //Estado
    public String nombre;
    public Fecha[] fechas;
    public int dimL;
    public int fechaActual;
    
    //Constructor
    public Gira(String nombreB, int cantTemas, String nombre, int cantFechas) {
      super(nombreB, cantTemas);
      this.nombre = nombre;
      fechas = new Fecha[cantFechas];
      dimL = 0;
      fechaActual = 0;
    }

    //Comportamiento
    public String getNombre() {
        return nombre;
    }

    public int getFechaActual() {
        return fechaActual;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setFechaActual(int fechaActual) {
        this.fechaActual = fechaActual;
    }
    
    public void agregarFecha(Fecha fecha) {
       fechas[dimL] = fecha;
       dimL++;
    }

    public void actuar() {
      if (fechaActual<dimL) {
        System.out.println("Buenas noches..." + fechas[fechaActual].getCiudad() + "\n");
        super.actuar();
        fechaActual++;
      }
    }

    public boolean finalizado() {
      if (fechaActual == dimL) 
        return true;
      else
        return false;
    }

    public int calcularCosto() {
      return 30000*dimL;
    }
}
