/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practica2;

/**
 *
 * @author Antonio
 */
public class Autor {
    //Estado
    private String nombre, biografia;

    //Constructor
    public Autor(String nombre, String descripcion) {
        this.nombre = nombre;
        this.biografia = descripcion;
    }
    
    public Autor() {}
    
    //Comportamiento
        //Getters
    public String getNombre() {
        return nombre;
    }

    public String getBiografia() {
        return biografia;
    }
    
        //Setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setBiografia(String biografia) {
        this.biografia = biografia;
    }
}
