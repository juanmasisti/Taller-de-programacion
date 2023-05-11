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
public class Fecha {
    //Estado
    public String ciudad;
    public int dia;
    
    //Constructor
    public Fecha(String ciudad, int dia) {
      this.ciudad = ciudad;
      this.dia = dia;
    }
    
    //Comportamiento
    public String getCiudad() {
        return ciudad;
    }

    public int getDia() {
        return dia;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }
    
}
