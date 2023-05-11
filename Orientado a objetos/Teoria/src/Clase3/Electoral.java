/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clase3;

/**
 *
 * @author Antonio
 */
public class Electoral extends Urna {
    //Estado
    private int cantListas;
    private int [] votos;

    //Constructor
    public Electoral(int U, int L) {
        super(U);
        this.cantListas = L;
        this.votos = new int[cantListas];
    }

    //Metodos
    public int getCantListas() {
        return cantListas;
    }

    public void setCantListas(int cantListas) {
        this.cantListas = cantListas;
    }

    public boolean validarNumeroDeLista(int N) {
        return (N >= 0 && N < cantListas);
    }

    public void votarPorLista(int L) {
        votos[L]++;
    }

    public int devolverVotosPorLista(int L) {
        return votos[L];
    }

    public int calcularGanador() {
        int max = -1, maxLista = 0;
        for (int i = 0; i < cantListas; i++) {
            if (votos[i] > max) {
                max = votos[i];
                maxLista = i;
            }
        }
        return maxLista;
    }

    public int calcularTotalVotos() {
        int total = 0;
        for (int i = 0; i < cantListas; i++) {
            total += votos[i];
        }
        return total + getContEnBlanco();
    }
}
