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
public class EventoOcasional extends Recital {
    //Estado
    public String motivo;
    public String nombre;
    public int dia;

    //Constructor
    public EventoOcasional(String nombreB, int cantTemas, String motivo, String nombre, int dia) {
      super(nombreB, cantTemas);
      this.motivo = motivo;
      this.nombre = nombre;
      this.dia = dia;
    }

    //Comportamiento
    public String getMotivo() {
        return motivo;
    }

    public String getNombre() {
        return nombre;
    }

    public int getDia() {
        return dia;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public void actuar() {
      if (motivo.equals("Beneficiencia")) {
        System.out.println("Acuerdense de colaborar con..." + nombre + "\n");
      } else if (motivo.equals("Show de TV")) {
        System.out.println("Saludos amigos televidentes.\n");
      } else {
        System.out.println("Un feliz cumpleaños para..." + nombre + "\n");
      }
      super.actuar();
    }

    public boolean finalizado() {
      return super.terminar;
    }
    
    public int calcularCosto() {
      if (motivo.equals("Beneficiencia")) {
        return 0;
      } else if (motivo.equals("Show de TV")) {
        return 50000;
      } else {
        return 150000;
      }
    }
}
